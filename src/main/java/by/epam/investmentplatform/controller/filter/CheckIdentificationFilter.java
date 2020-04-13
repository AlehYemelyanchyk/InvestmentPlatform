package by.epam.investmentplatform.controller.filter;

import by.epam.investmentplatform.Constants;

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
        } else {
            String requestUrl = req.getRequestURI();
            req.getSession().setAttribute(Constants.REDIRECT_URL_AFTER_LOGIN, requestUrl);
            resp.sendRedirect("main.jsp");
        }
    }
}
