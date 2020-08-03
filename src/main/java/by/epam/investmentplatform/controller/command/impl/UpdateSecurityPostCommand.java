package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.CommandsConstants;
import by.epam.investmentplatform.Constants;
import by.epam.investmentplatform.NamesConstants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.entity.Security;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateSecurityPostCommand extends AbstractCommand {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            String symbol = req.getParameter(NamesConstants.SECURITY_SYMBOL);
            String name = req.getParameter(NamesConstants.SECURITY_NAME);
            String exchange = req.getParameter(NamesConstants.SECURITY_EXCHANGE);
            double price = Double.parseDouble(req.getParameter(NamesConstants.CURRENT_PRICE));
            double yearChange = Double.parseDouble(req.getParameter(NamesConstants.YEAR_CHANGE));
            double dividends = Double.parseDouble(req.getParameter(NamesConstants.DIVIDENDS));
            String type = req.getParameter(NamesConstants.SECURITY_TYPE);
            Security security = new Security(symbol, name, exchange, price, yearChange, dividends, type);
            String[] params = {};
            securityService.updateSecurity(security, params);
        } catch (NullPointerException e) {
            LOGGER.error("UpdateSecurityPostCommand missing value error: ", e);
        } catch (ServiceException e) {
            LOGGER.error("UpdateSecurityPostCommand error: ", e);
            throw new ServletException("Incorrect values.");
        }
        req.setAttribute(NamesConstants.REDIRECT_LINK, CommandsConstants.GET_ALL_SECURITIES_ADMIN);
        req.getSession().setAttribute(NamesConstants.REQUEST_METHOD, Constants.GET_METHOD);
        RoutingUtils.forwardToPage(JspPageName.REDIRECT_PAGE, req, resp);
    }
}