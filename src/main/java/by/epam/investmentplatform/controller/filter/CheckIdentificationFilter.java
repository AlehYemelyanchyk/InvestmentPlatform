package by.epam.investmentplatform.controller.filter;

import by.epam.investmentplatform.NamesConstants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "CheckIdentificationFilter")
public class CheckIdentificationFilter extends AbstractFilter {

    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        if (req.getSession().getAttribute(NamesConstants.CURRENT_USER_LOGIN) != null) {
            filterChain.doFilter(req, resp);
        } else {
            String requestUrl = req.getRequestURI();
            req.getSession().setAttribute(NamesConstants.REDIRECT_LINK, requestUrl);
            RoutingUtils.forwardToPage(JspPageName.LOG_IN_PAGE, req, resp);
        }
    }
}
