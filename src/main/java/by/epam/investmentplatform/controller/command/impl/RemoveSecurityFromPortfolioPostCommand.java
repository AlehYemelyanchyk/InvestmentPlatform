package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.CommandsConstants;
import by.epam.investmentplatform.Constants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoveSecurityFromPortfolioPostCommand extends AbstractCommandExecutor {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String securitySymbol = req.getParameter(Constants.SECURITY_SYMBOL);
        int portfolioId = Integer.parseInt(req.getParameter(Constants.PORTFOLIO_ID));
        try {
            securityService.removeSecurityFromPortfolio(portfolioId, securitySymbol);
        } catch (ServiceException e) {
            LOGGER.error("RemoveSecurityFromPortfolioPostCommand error: ", e);
            throw new ServiceException("Incorrect values");
        }
        req.setAttribute(Constants.REDIRECT_LINK, CommandsConstants.GET_ALL_USER_PORTFOLIOS_COMMAND);
        RoutingUtils.forwardToPage(JspPageName.REDIRECT_PAGE, req, resp);
    }
}