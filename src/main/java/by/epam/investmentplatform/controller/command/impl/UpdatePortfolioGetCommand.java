package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.Constants;
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
        int portfolioId = Integer.parseInt(req.getParameter(Constants.PORTFOLIO_ID));
        try {
            Portfolio portfolio = PORTFOLIO_SERVICE.getPortfolio(portfolioId);
            req.setAttribute(Constants.PORTFOLIO, portfolio);
        } catch (ServiceException e) {
            LOGGER.error("Get portfolio error: ", e);
            throw new ServiceException("Incorrect values");
        }
        req.setAttribute(Constants.PORTFOLIO_ID, portfolioId);
        RoutingUtils.forwardToPage(JspPageName.UPDATE_PORTFOLIO_PAGE, req, resp);
    }
}
