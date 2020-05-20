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

public class AddPortfolioPostCommandImpl extends AbstractCommandExecutor {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int userId = (int) req.getSession().getAttribute(Constants.CURRENT_USER_ID);

        Portfolio portfolio = new Portfolio(
                userId,
                req.getParameter(RequestParameterName.REQUEST_PORTFOLIO_PARAM_NAME));
        try {
            PORTFOLIO_SERVICE.addPortfolio(portfolio);
        } catch (ServiceException e) {
            LOGGER.error("Add portfolio error: ", e);
            throw new ServiceException("Incorrect values");
        }
        req.setAttribute(Constants.REDIRECT_LINK, "getAllUserPortfolios");
        RoutingUtils.forwardToPage(JspPageName.REDIRECT_PAGE, req, resp);
    }
}
