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
import java.util.List;

public class GetAllUserPortfoliosAdminGetCommand extends AbstractCommandExecutor {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int userId;
        try {
            if (req.getParameter(Constants.PORTFOLIO_USER_ID) != null) {
                userId = Integer.parseInt(req.getParameter(Constants.PORTFOLIO_USER_ID));
            } else {
                userId = (int) (req.getSession().getAttribute(Constants.PORTFOLIO_USER_ID));
            }
            List<Portfolio> allPortfolios = portfolioService.getAllUserPortfolios(userId);
            req.getSession().setAttribute(Constants.PORTFOLIO_USER_ID, userId);
            req.setAttribute(Constants.PORTFOLIOS_LIST, allPortfolios);
        } catch (ServiceException e) {
            LOGGER.error("GetAllUserPortfoliosGetCommand error: ", e);
            throw new ServiceException("Incorrect values.");
        }
        RoutingUtils.forwardToPage(JspPageName.GET_ALL_USER_PORTFOLIOS_PAGE, req, resp);
    }
}
