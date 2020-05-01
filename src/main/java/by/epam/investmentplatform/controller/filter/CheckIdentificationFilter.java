package by.epam.investmentplatform.controller.filter;

import by.epam.investmentplatform.Constants;
import by.epam.investmentplatform.controller.command.JspPageName;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter(filterName = "CheckIdentificationFilter")
public class CheckIdentificationFilter extends AbstractFilter {

    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        if (req.getSession().getAttribute(Constants.CURRENT_USER_LOGIN) != null) {
            filterChain.doFilter(req, resp);
        } else if (req.getSession().getAttribute(Constants.REDIRECT_URL_AFTER_LOGIN) != null) {
            String requestUrl = req.getRequestURI();
            req.getSession().setAttribute(Constants.REDIRECT_URL_AFTER_LOGIN, requestUrl);
            req.getRequestDispatcher(JspPageName.MAIN_PAGE).forward(req, resp);
        } else {
            filterChain.doFilter(req, resp);
        }
    }
}
