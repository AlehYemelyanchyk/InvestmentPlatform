package by.epam.investmentplatform.controller.filter;

import by.epam.investmentplatform.Constants;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static by.epam.investmentplatform.Constants.COMMAND_ATTRIBUTE;
import static by.epam.investmentplatform.Constants.COMMON_SERVLET_PATH;

@WebFilter(filterName = "UrlFilter")
public class UrlFilter extends AbstractFilter {

    // need to protect this collection from modifications somehow
    private static final Set<String> BUSINESS_URIS = new HashSet<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        BUSINESS_URIS.add("signup");
        BUSINESS_URIS.add("login");
        BUSINESS_URIS.add("main");
        BUSINESS_URIS.add("getAllUsers");
        BUSINESS_URIS.add("getAllUserPortfolios");
        BUSINESS_URIS.add("addPortfolio");
        BUSINESS_URIS.add("updatePortfolio");
        BUSINESS_URIS.add("removePortfolio");
        BUSINESS_URIS.add("addSecurity");
        BUSINESS_URIS.add("getAllPortfolioSecurities");
        BUSINESS_URIS.add("logout");
    }

    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        // saving url of the initial request, because we override it on the line 29 with "/app".
        String requestStr = req.getRequestURI();
        String[] splitRequest = requestStr.split("/");
        String commandName = splitRequest[splitRequest.length - 1];
        req.setAttribute(COMMAND_ATTRIBUTE, commandName);
        if (BUSINESS_URIS.contains(commandName)) {
            req.getRequestDispatcher(COMMON_SERVLET_PATH).forward(req, resp);
        } else {
            req.setAttribute(Constants.ERROR_ATTRIBUTE, "Such command does not exist.");
            filterChain.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {

    }
}
