package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.Constants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.entity.Security;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetSecurityGetCommand extends AbstractCommandExecutor {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String securitySymbol = req.getParameter(Constants.SECURITY_SYMBOL);
        if (securitySymbol == null) {
            securitySymbol = (String) req.getSession().getAttribute(Constants.SECURITY_SYMBOL);
        }
        Security security;
        try {
            security = SECURITY_SERVICE.getSecurity(securitySymbol);
        } catch (ServiceException e) {
            LOGGER.error("Get security error: ", e);
            throw e;
        }
        req.getSession().setAttribute(Constants.SECURITY_SYMBOL, securitySymbol);
        req.setAttribute(Constants.SECURITY, security);
        RoutingUtils.forwardToPage(JspPageName.GET_SECURITY_PAGE, req, resp);
    }
}