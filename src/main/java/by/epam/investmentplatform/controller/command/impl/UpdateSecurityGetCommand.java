package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.NamesConstants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.entity.Security;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class UpdateSecurityGetCommand extends AbstractCommand {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String symbol = req.getParameter(NamesConstants.SECURITY_SYMBOL);
        try {
            Security security = securityService.getSecurity(symbol);
            Map<Integer, String> exchangesList = securityService.getExchanges();
            Map<Integer, String> securityTypesList = securityService.getSecurityTypes();
            req.setAttribute(NamesConstants.SECURITY, security);
            req.setAttribute(NamesConstants.EXCHANGES_LIST, exchangesList);
            req.setAttribute(NamesConstants.SECURITY_TYPES_LIST, securityTypesList);
        } catch (ServiceException e) {
            LOGGER.error("UpdateSecurityGetCommand error: ", e);
            throw new ServletException("Incorrect values.");
        }
        RoutingUtils.forwardToPage(JspPageName.UPDATE_SECURITY_PAGE, req, resp);
    }
}