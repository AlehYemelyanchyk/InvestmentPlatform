package by.epam.investmentplatform.controller.filter;

import by.epam.investmentplatform.Constants;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "ErrorHandlerFilter")
public class ErrorHandlerFilter extends AbstractFilter {
    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain filterChain)
            throws IOException, ServletException {
        try {
            filterChain.doFilter(req, resp);
        } catch (Throwable th) {
            String requestUrl = req.getRequestURI();
            req.setAttribute(Constants.ERROR_ATTRIBUTE, th.getMessage());
            LOGGER.error("Request " + requestUrl + " error: " + th.getMessage(), th);
            RoutingUtils.forwardToPage("error.jsp", req, resp);
        }
    }
}
