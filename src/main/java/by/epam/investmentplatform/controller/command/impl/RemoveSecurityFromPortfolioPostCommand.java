package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.CommandsConstants;
import by.epam.investmentplatform.Constants;
import by.epam.investmentplatform.NamesConstants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoveSecurityFromPortfolioPostCommand extends AbstractCommand {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            String securitySymbol = req.getParameter(NamesConstants.SECURITY_SYMBOL);
            int portfolioId = Integer.parseInt(req.getParameter(NamesConstants.PORTFOLIO_ID));

            securityService.removeSecurityFromPortfolio(portfolioId, securitySymbol);
        } catch (NullPointerException e) {
            LOGGER.error("RemoveSecurityFromPortfolioPostCommand missing value error: ", e);
        } catch (ServiceException e) {
            LOGGER.error("RemoveSecurityFromPortfolioPostCommand error: ", e);
            throw new ServletException("Incorrect values");
        }
        req.setAttribute(NamesConstants.REDIRECT_LINK, CommandsConstants.GET_ALL_PORTFOLIO_SECURITIES);
        req.getSession().setAttribute(NamesConstants.REQUEST_METHOD, Constants.GET_METHOD);
        RoutingUtils.forwardToPage(JspPageName.REDIRECT_PAGE, req, resp);
    }
}