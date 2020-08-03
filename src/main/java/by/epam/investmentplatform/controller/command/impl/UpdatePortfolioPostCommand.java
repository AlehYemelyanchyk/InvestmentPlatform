package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.CommandsConstants;
import by.epam.investmentplatform.Constants;
import by.epam.investmentplatform.NamesConstants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.entity.Portfolio;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdatePortfolioPostCommand extends AbstractCommand {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            String newName = req.getParameter(NamesConstants.REQUEST_PORTFOLIO_PARAM_NAME);
            int portfolioId = Integer.parseInt(req.getParameter(NamesConstants.PORTFOLIO_ID));
            int userId = Integer.parseInt(req.getParameter(NamesConstants.PORTFOLIO_USER_ID));
            String portfolioName = req.getParameter(NamesConstants.PORTFOLIO_NAME);
            Portfolio portfolio = new Portfolio(portfolioId, userId, portfolioName);
            String[] parameters = {newName};

            portfolioService.updatePortfolio(portfolio, parameters);
        } catch (NullPointerException e) {
            LOGGER.error("UpdatePortfolioPostCommand missing value error: ", e);
        } catch (ServiceException e) {
            LOGGER.error("UpdatePortfolioPostCommand error: ", e);
            throw new ServletException("Incorrect values.");
        }
        req.setAttribute(NamesConstants.REDIRECT_LINK, CommandsConstants.GET_ALL_USER_PORTFOLIOS);
        req.getSession().setAttribute(NamesConstants.REQUEST_METHOD, Constants.GET_METHOD);
        RoutingUtils.forwardToPage(JspPageName.REDIRECT_PAGE, req, resp);
    }
}