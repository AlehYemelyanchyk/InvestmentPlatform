package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.Constants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.controller.command.RequestParameterName;
import by.epam.investmentplatform.entity.Portfolio;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdatePortfolioPostCommandImpl extends AbstractCommandExecutor {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String newName = req.getParameter(RequestParameterName.REQUEST_PORTFOLIO_PARAM_NAME);
        Portfolio portfolio = new Portfolio(
                Integer.parseInt(req.getParameter(Constants.THE_PORTFOLIO_ID)),
                Integer.parseInt(req.getParameter(Constants.THE_PORTFOLIO_USER_ID)),
                req.getParameter(Constants.THE_PORTFOLIO_NAME));
        String[] parameters = {newName};
        try {
            PORTFOLIO_SERVICE.updatePortfolio(portfolio, parameters);
        } catch (ServiceException e) {
            LOGGER.error("Update portfolio error: ", e);
            throw new ServiceException("Incorrect values");
        }
        RoutingUtils.forwardToPage(JspPageName.GET_ALL_USER_PORTFOLIOS_PAGE, req, resp);
    }
}