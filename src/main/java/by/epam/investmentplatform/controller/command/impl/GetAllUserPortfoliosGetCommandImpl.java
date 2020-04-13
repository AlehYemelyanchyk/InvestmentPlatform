package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.Constants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.entity.Portfolio;
import by.epam.investmentplatform.service.exceptions.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GetAllUserPortfoliosGetCommandImpl extends AbstractCommandExecutor {

    @Override
    protected RequestDispatcher getDispatcher(HttpServletRequest request) throws ServiceException {
        try {
            int userId = (int) (request.getSession().getAttribute("id"));
            List<Portfolio> allPortfolios = PORTFOLIO_SERVICE.getAllUserPortfolios(userId);
            request.setAttribute(Constants.PORTFOLIOS_LIST, allPortfolios);
        } catch (ServiceException e) {
            LOGGER.error("Get all portfolios error", e);
        }
        return request.getRequestDispatcher(JspPageName.GET_ALL_USER_PORTFOLIOS_PAGE);
    }
}
