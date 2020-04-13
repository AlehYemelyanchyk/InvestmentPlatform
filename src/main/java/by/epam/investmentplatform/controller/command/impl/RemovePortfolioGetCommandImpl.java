package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.service.exceptions.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

public class RemovePortfolioGetCommandImpl extends AbstractCommandExecutor {

    @Override
    protected RequestDispatcher getDispatcher(HttpServletRequest request) throws ServiceException {
        int portfolioId = Integer.parseInt(request.getParameter("portfolioId"));
        try {
            PORTFOLIO_SERVICE.removePortfolio(portfolioId);
        } catch (ServiceException e) {
            LOGGER.error("Remove portfolio error: ", e);
            throw new ServiceException("Incorrect values");
        }
        return request.getRequestDispatcher("/getAllUserPortfolios");
    }
}
