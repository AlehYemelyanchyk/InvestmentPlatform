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

public class AddSecurityToPortfolioGetCommand extends AbstractCommandExecutor {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String securitySymbol;
        if (req.getParameter(Constants.SECURITY_SYMBOL) != null) {
            securitySymbol = req.getParameter(Constants.SECURITY_SYMBOL);
        } else {
            securitySymbol = (String) req.getSession().getAttribute(Constants.SECURITY_SYMBOL);
        }
        double securityPrice;
        if (req.getParameter(Constants.SECURITY_PRICE) != null) {
            securityPrice = Double.parseDouble(req.getParameter(Constants.SECURITY_PRICE));
        } else {
            securityPrice = (double) req.getSession().getAttribute(Constants.SECURITY_PRICE);
        }
        int userId = (int) req.getSession().getAttribute(Constants.CURRENT_USER_ID);
        try {
            List<Portfolio> portfolios = portfolioService.getAllUserPortfolios(userId);
            req.setAttribute(Constants.PORTFOLIOS_LIST, portfolios);
        } catch (ServiceException e) {
            LOGGER.error("AddSecurityToPortfolioGetCommand error: ", e);
            throw new ServiceException("Incorrect values.");
        }

        req.getSession().setAttribute(Constants.SECURITY_SYMBOL, securitySymbol);
        req.getSession().setAttribute(Constants.SECURITY_PRICE, securityPrice);

        req.setAttribute(Constants.SECURITY_SYMBOL, securitySymbol);
        req.setAttribute(Constants.SECURITY_PRICE, securityPrice);
        RoutingUtils.forwardToPage(JspPageName.ADD_SECURITY_TO_PORTFOLIO_PAGE, req, resp);
    }
}