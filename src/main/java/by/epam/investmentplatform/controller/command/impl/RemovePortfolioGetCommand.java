package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.CommandsConstants;
import by.epam.investmentplatform.NamesConstants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemovePortfolioGetCommand extends AbstractCommand {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int portfolioId = Integer.parseInt(req.getParameter(NamesConstants.PORTFOLIO_ID));
        try {
            portfolioService.removePortfolio(portfolioId);
        } catch (ServiceException e) {
            LOGGER.error("RemovePortfolioGetCommand error: ", e);
            throw new ServletException("Incorrect values");
        }
        req.setAttribute(NamesConstants.REDIRECT_LINK, CommandsConstants.GET_ALL_USER_PORTFOLIOS);
        RoutingUtils.forwardToPage(JspPageName.REDIRECT_PAGE, req, resp);
    }
}
