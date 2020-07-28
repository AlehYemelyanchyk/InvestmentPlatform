package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.CommandsConstants;
import by.epam.investmentplatform.NamesConstants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.entity.Security;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddSecurityAdminPostCommand extends AbstractCommand {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("");
        try {
            Security security = new Security(
                    req.getParameter(NamesConstants.SECURITY_SYMBOL),
                    req.getParameter(NamesConstants.SECURITY_NAME),
                    req.getParameter(NamesConstants.SECURITY_EXCHANGE),
                    Double.parseDouble(req.getParameter(NamesConstants.SECURITY_PRICE)),
                    Double.parseDouble(req.getParameter(NamesConstants.SECURITY_YEAR_CHANGE)),
                    Double.parseDouble(req.getParameter(NamesConstants.SECURITY_DIVIDENDS)),
                    req.getParameter(NamesConstants.SECURITY_TYPE));
            securityService.saveSecurity(security);
        } catch (ServiceException e) {
            LOGGER.error("AddSecurityAdminPostCommand error: ", e);
            throw new ServletException("Incorrect values.");
        }
        req.setAttribute(NamesConstants.REDIRECT_LINK, CommandsConstants.GET_ALL_SECURITIES_ADMIN);
        RoutingUtils.forwardToPage(JspPageName.REDIRECT_PAGE, req, resp);
    }
}
