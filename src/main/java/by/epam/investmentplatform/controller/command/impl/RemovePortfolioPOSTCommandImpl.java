package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemovePortfolioPOSTCommandImpl extends AbstractCommandExecutor {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int portfolioId = Integer.parseInt(req.getParameter("portfolioId"));
        try {
            PORTFOLIO_SERVICE.removePortfolio(portfolioId);
        } catch (ServiceException e) {
            LOGGER.error("Remove portfolio error: ", e);
            throw new ServiceException("Incorrect values");
        }
        RoutingUtils.forwardToPage(JspPageName.GET_ALL_USER_PORTFOLIOS_PAGE, req, resp);
    }
}
