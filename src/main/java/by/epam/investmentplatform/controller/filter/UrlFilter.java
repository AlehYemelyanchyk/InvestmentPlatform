package by.epam.investmentplatform.controller.filter;

import by.epam.investmentplatform.CommandsConstants;
import by.epam.investmentplatform.Constants;
import by.epam.investmentplatform.NamesConstants;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebFilter(filterName = "UrlFilter")
public class UrlFilter extends AbstractFilter {

    private static final Set<String> BUSINESS_URIS = new HashSet<>();

    @Override
    public void init(FilterConfig filterConfig) {
        BUSINESS_URIS.add(CommandsConstants.ADD_PORTFOLIO);
        BUSINESS_URIS.add(CommandsConstants.ADD_SECURITY_ADMIN);
        BUSINESS_URIS.add(CommandsConstants.ADD_SECURITY_TO_PORTFOLIO);
        BUSINESS_URIS.add(CommandsConstants.ADD_USER_ADMIN);
        BUSINESS_URIS.add(CommandsConstants.ADMIN_SETTINGS);
        BUSINESS_URIS.add(CommandsConstants.ARCHIVE_SECURITY);
        BUSINESS_URIS.add(CommandsConstants.BAN_USER);
        BUSINESS_URIS.add(CommandsConstants.BAN_USER_TRANSACTIONS);
        BUSINESS_URIS.add(CommandsConstants.DEPOSIT);
        BUSINESS_URIS.add(CommandsConstants.GET_ALL_PORTFOLIO_SECURITIES);
        BUSINESS_URIS.add(CommandsConstants.GET_ALL_SECURITIES);
        BUSINESS_URIS.add(CommandsConstants.GET_ALL_SECURITIES_ADMIN);
        BUSINESS_URIS.add(CommandsConstants.GET_ALL_SECURITY_TRANSACTIONS);
        BUSINESS_URIS.add(CommandsConstants.GET_ALL_USER_PORTFOLIOS);
        BUSINESS_URIS.add(CommandsConstants.GET_ALL_USER_PORTFOLIOS_ADMIN);
        BUSINESS_URIS.add(CommandsConstants.GET_ALL_USERS);
        BUSINESS_URIS.add(CommandsConstants.GET_BALANCE);
        BUSINESS_URIS.add(CommandsConstants.GET_SECURITY);
        BUSINESS_URIS.add(CommandsConstants.GET_USER_SETTINGS_ADMIN);
        BUSINESS_URIS.add(CommandsConstants.LOAN);
        BUSINESS_URIS.add(CommandsConstants.LOGIN);
        BUSINESS_URIS.add(CommandsConstants.LOGOUT);
        BUSINESS_URIS.add(CommandsConstants.MAIN);
        BUSINESS_URIS.add(CommandsConstants.REMOVE_PORTFOLIO);
        BUSINESS_URIS.add(CommandsConstants.REMOVE_SECURITY_FROM_PORTFOLIO);
        BUSINESS_URIS.add(CommandsConstants.REMOVE_TRANSACTION);
        BUSINESS_URIS.add(CommandsConstants.REMOVE_USER_ADMIN);
        BUSINESS_URIS.add(CommandsConstants.SIGNUP);
        BUSINESS_URIS.add(CommandsConstants.SELL_SECURITY_FROM_PORTFOLIO);
        BUSINESS_URIS.add(CommandsConstants.UPDATE_PORTFOLIO);
        BUSINESS_URIS.add(CommandsConstants.UPDATE_SECURITY);
        BUSINESS_URIS.add(CommandsConstants.UPDATE_TRANSACTION);
        BUSINESS_URIS.add(CommandsConstants.UPDATE_USER);
        BUSINESS_URIS.add(CommandsConstants.UPDATE_USER_ADMIN);
        BUSINESS_URIS.add(CommandsConstants.USER_SETTINGS);
        BUSINESS_URIS.add(CommandsConstants.WITHDRAW);
    }

    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        // saving url of the initial request, because we override it on the line 29 with "/app".
        String requestStr = req.getRequestURI();
        String[] splitRequest = requestStr.split(Constants.URL_DELIMITER);
        String commandName = splitRequest[splitRequest.length - 1];
        req.setAttribute(NamesConstants.COMMAND_ATTRIBUTE, commandName);
        if (BUSINESS_URIS.contains(commandName)) {
            req.getRequestDispatcher(NamesConstants.COMMON_SERVLET_PATH).forward(req, resp);
        } else {
            LOGGER.error("Command \"" + commandName + "\" does not exist");
            filterChain.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {

    }
}
