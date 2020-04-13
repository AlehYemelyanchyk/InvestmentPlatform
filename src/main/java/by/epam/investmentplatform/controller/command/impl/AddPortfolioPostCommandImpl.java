package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.controller.command.RequestParameterName;
import by.epam.investmentplatform.entity.Portfolio;
import by.epam.investmentplatform.service.exceptions.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

public class AddPortfolioPostCommandImpl extends AbstractCommandExecutor {

    @Override
    protected RequestDispatcher getDispatcher(HttpServletRequest request) throws ServiceException {
        int userId = (int) request.getSession().getAttribute("id");

        Portfolio portfolio = new Portfolio(
                userId,
                request.getParameter(RequestParameterName.REQUEST_PORTFOLIO_PARAM_NAME));
        try {
            PORTFOLIO_SERVICE.addPortfolio(portfolio);
        } catch (ServiceException e) {
            LOGGER.error("Add portfolio error: ", e);
            throw new ServiceException("Incorrect values");
        }
        return request.getRequestDispatcher(JspPageName.GET_ALL_USER_PORTFOLIOS_PAGE);
    }
}
