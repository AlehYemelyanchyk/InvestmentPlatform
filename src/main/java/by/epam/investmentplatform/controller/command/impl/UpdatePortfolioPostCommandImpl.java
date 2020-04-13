package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.controller.command.RequestParameterName;
import by.epam.investmentplatform.entity.Portfolio;
import by.epam.investmentplatform.service.exceptions.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

public class UpdatePortfolioPostCommandImpl extends AbstractCommandExecutor {

    @Override
    protected RequestDispatcher getDispatcher(HttpServletRequest request) throws ServiceException {
        String newName = request.getParameter(RequestParameterName.REQUEST_PORTFOLIO_PARAM_NAME);
        Portfolio portfolio = new Portfolio(
                Integer.parseInt(request.getParameter("THE_PORTFOLIO_ID")),
                Integer.parseInt(request.getParameter("THE_PORTFOLIO_USER_ID")),
                request.getParameter("THE_PORTFOLIO_NAME"));
        String[] parameters = {newName};
        try {
            PORTFOLIO_SERVICE.updatePortfolio(portfolio, parameters);
        } catch (ServiceException e) {
            LOGGER.error("Update portfolio error: ", e);
            throw new ServiceException("Incorrect values");
        }
        return request.getRequestDispatcher(JspPageName.GET_ALL_USER_PORTFOLIOS_PAGE);
    }
}