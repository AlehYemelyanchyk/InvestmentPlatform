package by.epam.investmentplatform.controller.filter;

import by.epam.investmentplatform.CommandsConstants;
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

@WebFilter(filterName = "UrlFilter")
public class UrlFilter extends AbstractFilter {

    private static final Set<String> BUSINESS_URIS = new HashSet<>();

    @Override
    public void init(FilterConfig filterConfig) {
        BUSINESS_URIS.add(CommandsConstants.ADD_PORTFOLIO_COMMAND);
        BUSINESS_URIS.add(CommandsConstants.ADD_SECURITY_COMMAND);
        BUSINESS_URIS.add(CommandsConstants.ADD_SECURITY_TO_PORTFOLIO_COMMAND);
        BUSINESS_URIS.add(CommandsConstants.ADD_USER_ADMIN_COMMAND);
        BUSINESS_URIS.add(CommandsConstants.ADMIN_SETTINGS_COMMAND);
        BUSINESS_URIS.add(CommandsConstants.ARCHIVE_SECURITY);
        BUSINESS_URIS.add(CommandsConstants.DEPOSIT_COMMAND);
        BUSINESS_URIS.add(CommandsConstants.GET_ALL_PORTFOLIO_SECURITIES_COMMAND);
        BUSINESS_URIS.add(CommandsConstants.GET_ALL_SECURITIES_COMMAND);
        BUSINESS_URIS.add(CommandsConstants.GET_ALL_SECURITIES_ADMIN_COMMAND);
        BUSINESS_URIS.add(CommandsConstants.GET_ALL_SECURITY_TRANSACTIONS_COMMAND);
        BUSINESS_URIS.add(CommandsConstants.GET_ALL_USER_PORTFOLIOS_COMMAND);
        BUSINESS_URIS.add(CommandsConstants.GET_ALL_USER_PORTFOLIOS_ADMIN_COMMAND);
        BUSINESS_URIS.add(CommandsConstants.GET_ALL_USERS_COMMAND);
        BUSINESS_URIS.add(CommandsConstants.GET_BALANCE_COMMAND);
        BUSINESS_URIS.add(CommandsConstants.GET_SECURITY_COMMAND);
        BUSINESS_URIS.add(CommandsConstants.GET_USER_SETTINGS_ADMIN_COMMAND);
        BUSINESS_URIS.add(CommandsConstants.LOAN_COMMAND);
        BUSINESS_URIS.add(CommandsConstants.LOGIN_COMMAND);
        BUSINESS_URIS.add(CommandsConstants.LOGOUT_COMMAND);
        BUSINESS_URIS.add(CommandsConstants.MAIN_COMMAND);
        BUSINESS_URIS.add(CommandsConstants.REMOVE_PORTFOLIO_COMMAND);
        BUSINESS_URIS.add(CommandsConstants.REMOVE_SECURITY_FROM_PORTFOLIO_COMMAND);
        BUSINESS_URIS.add(CommandsConstants.REMOVE_TRANSACTION_COMMAND);
        BUSINESS_URIS.add(CommandsConstants.REMOVE_USER_ADMIN_COMMAND);
        BUSINESS_URIS.add(CommandsConstants.SIGNUP_COMMAND);
        BUSINESS_URIS.add(CommandsConstants.UPDATE_PORTFOLIO_COMMAND);
        BUSINESS_URIS.add(CommandsConstants.UPDATE_TRANSACTION_COMMAND);
        BUSINESS_URIS.add(CommandsConstants.UPDATE_USER_COMMAND);
        BUSINESS_URIS.add(CommandsConstants.UPDATE_USER_ADMIN_COMMAND);
        BUSINESS_URIS.add(CommandsConstants.USER_SETTINGS_COMMAND);
        BUSINESS_URIS.add(CommandsConstants.WITHDRAW_COMMAND);
    }

    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        // saving url of the initial request, because we override it on the line 29 with "/app".
        String requestStr = req.getRequestURI();
        String[] splitRequest = requestStr.split("/");
        String commandName = splitRequest[splitRequest.length - 1];
        req.setAttribute(Constants.COMMAND_ATTRIBUTE, commandName);
        if (BUSINESS_URIS.contains(commandName)) {
            req.getRequestDispatcher(Constants.COMMON_SERVLET_PATH).forward(req, resp);
        } else {
            LOGGER.error("Command \"" + commandName + "\" does not exist");
            filterChain.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {

    }
}
