package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.CommandsConstants;
import by.epam.investmentplatform.Constants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.entity.Portfolio;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdatePortfolioPostCommand extends AbstractCommandExecutor {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String newName = req.getParameter(Constants.REQUEST_PORTFOLIO_PARAM_NAME);
        Portfolio portfolio = new Portfolio(
                Integer.parseInt(req.getParameter(Constants.PORTFOLIO_ID)),
                Integer.parseInt(req.getParameter(Constants.PORTFOLIO_USER_ID)),
                req.getParameter(Constants.PORTFOLIO_NAME));
        String[] parameters = {newName};
        try {
            portfolioService.updatePortfolio(portfolio, parameters);
        } catch (ServiceException e) {
            LOGGER.error("UpdatePortfolioPostCommand error: ", e);
            throw new ServletException("Incorrect values.");
        }
        req.setAttribute(Constants.REDIRECT_LINK, CommandsConstants.GET_ALL_USER_PORTFOLIOS_COMMAND);
        RoutingUtils.forwardToPage(JspPageName.REDIRECT_PAGE, req, resp);
    }
}