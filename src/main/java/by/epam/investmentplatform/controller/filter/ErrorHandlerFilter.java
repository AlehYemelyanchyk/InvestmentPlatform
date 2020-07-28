package by.epam.investmentplatform.controller.filter;

import by.epam.investmentplatform.NamesConstants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.controller.exception.AbstractApplicationException;
import by.epam.investmentplatform.controller.exception.InternalServerErrorException;
import by.epam.investmentplatform.controller.exception.ResourceNotFoundException;
import by.epam.investmentplatform.controller.exception.ValidationException;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.nio.file.AccessDeniedException;

@WebFilter(filterName = "ErrorHandlerFilter")
public class ErrorHandlerFilter extends AbstractFilter {
    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain filterChain)
            throws IOException, ServletException {
        try {
            filterChain.doFilter(req, new ThrowExceptionInsteadOfSendErrorResponse(resp));
        } catch (Throwable th) {
            String requestUrl = req.getRequestURI();
            LOGGER.error("Request " + requestUrl + " error: " + th.getMessage(), th);
            int statusCode = getStatusCode(th);
            resp.setStatus(statusCode);
            req.setAttribute(NamesConstants.STATUS_CODE, statusCode);
            if (th instanceof AbstractApplicationException) {
                req.setAttribute(NamesConstants.ERROR_ATTRIBUTE, th.getMessage());
            }
            RoutingUtils.forwardToPage(JspPageName.ERROR_PAGE, req, resp);
        }
    }

    private int getStatusCode(Throwable th) {
        if (th instanceof AbstractApplicationException) {
            return (((AbstractApplicationException) th).getCode());
        } else {
            return (HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    private static class ThrowExceptionInsteadOfSendErrorResponse extends HttpServletResponseWrapper {

        public ThrowExceptionInsteadOfSendErrorResponse(HttpServletResponse response) {
            super(response);
        }

        @Override
        public void sendError(int sc) throws IOException {
            sendError(sc, NamesConstants.INTERNAL_ERROR);
        }

        @Override
        public void sendError(int sc, String msg) throws IOException {
            switch (sc) {
                case 400:
                    throw new ValidationException(msg);
                case 403:
                    throw new AccessDeniedException(msg);
                case 404:
                    throw new ResourceNotFoundException(msg);
                default:
                    throw new InternalServerErrorException(msg);
            }
        }
    }
}
