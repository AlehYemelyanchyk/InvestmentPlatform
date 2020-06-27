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
import java.util.List;

public class GetAllUserPortfoliosAdminGetCommand extends AbstractCommandExecutor {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int userId;
        try {
            if (req.getParameter(NamesConstants.USER_ID) != null) {
                userId = Integer.parseInt(req.getParameter(NamesConstants.USER_ID));
            } else {
                userId = (int) (req.getSession().getAttribute(NamesConstants.USER_ID));
            }
            List<Portfolio> allPortfolios = portfolioService.getAllUserPortfolios(userId);
            req.getSession().setAttribute(NamesConstants.USER_ID, userId);
            req.setAttribute(NamesConstants.PORTFOLIOS_LIST, allPortfolios);
        } catch (ServiceException e) {
            LOGGER.error("GetAllUserPortfoliosAdminGetCommand error: ", e);
            throw new ServletException("Incorrect values.");
        }
        RoutingUtils.forwardToPage(JspPageName.GET_ALL_USER_PORTFOLIOS_PAGE, req, resp);
    }
}
