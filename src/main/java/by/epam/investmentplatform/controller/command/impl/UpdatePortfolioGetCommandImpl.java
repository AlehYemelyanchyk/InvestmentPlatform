package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.Constants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.entity.Portfolio;
import by.epam.investmentplatform.service.exceptions.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

public class UpdatePortfolioGetCommandImpl extends AbstractCommandExecutor {

    @Override
    protected RequestDispatcher getDispatcher(HttpServletRequest request) throws ServiceException {
        int portfolioId = Integer.parseInt(request.getParameter("portfolioId"));
        try {
            Portfolio portfolio = PORTFOLIO_SERVICE.getPortfolio(portfolioId);
            request.setAttribute(Constants.THE_PORTFOLIO, portfolio);
        } catch (ServiceException e) {
            LOGGER.error("Add portfolio error: ", e);
            throw new ServiceException("Incorrect values");
        }
        return request.getRequestDispatcher(JspPageName.UPDATE_PORTFOLIO_PAGE);
    }
}
