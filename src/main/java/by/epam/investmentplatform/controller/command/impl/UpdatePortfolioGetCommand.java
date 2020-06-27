package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.NamesConstants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.entity.Portfolio;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdatePortfolioGetCommand extends AbstractCommandExecutor {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int portfolioId = Integer.parseInt(req.getParameter(NamesConstants.PORTFOLIO_ID));
        try {
            Portfolio portfolio = portfolioService.getPortfolio(portfolioId);
            req.setAttribute(NamesConstants.PORTFOLIO, portfolio);
        } catch (ServiceException e) {
            LOGGER.error("UpdatePortfolioGetCommand error: ", e);
            throw new ServletException("Incorrect values.");
        }
        req.setAttribute(NamesConstants.PORTFOLIO_ID, portfolioId);
        RoutingUtils.forwardToPage(JspPageName.UPDATE_PORTFOLIO_PAGE, req, resp);
    }
}
