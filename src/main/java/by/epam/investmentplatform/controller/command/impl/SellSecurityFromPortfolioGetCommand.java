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

public class SellSecurityFromPortfolioGetCommand extends AbstractCommand {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String securitySymbol;
        if (req.getParameter(NamesConstants.SECURITY_SYMBOL) != null) {
            securitySymbol = req.getParameter(NamesConstants.SECURITY_SYMBOL);
        } else {
            securitySymbol = (String) req.getSession().getAttribute(NamesConstants.SECURITY_SYMBOL);
        }
        double securityPrice;
        if (req.getParameter(NamesConstants.SECURITY_PRICE) != null) {
            securityPrice = Double.parseDouble(req.getParameter(NamesConstants.SECURITY_PRICE));
        } else {
            securityPrice = (double) req.getSession().getAttribute(NamesConstants.SECURITY_PRICE);
        }
        double amount;
        if (req.getParameter(NamesConstants.AMOUNT) != null) {
            amount = Double.parseDouble(req.getParameter(NamesConstants.AMOUNT));
        } else {
            amount = (Double) req.getSession().getAttribute(NamesConstants.AMOUNT);
        }
        int userId = (int) req.getSession().getAttribute(NamesConstants.CURRENT_USER_ID);
        try {
            List<Portfolio> portfolios = portfolioService.getAllUserPortfolios(userId);
            req.setAttribute(NamesConstants.PORTFOLIOS_LIST, portfolios);
        } catch (ServiceException e) {
            LOGGER.error("SellSecurityFromPortfolioGetCommand error: ", e);
            throw new ServletException("Incorrect values.");
        }

        req.getSession().setAttribute(NamesConstants.SECURITY_SYMBOL, securitySymbol);
        req.getSession().setAttribute(NamesConstants.SECURITY_PRICE, securityPrice);
        req.getSession().setAttribute(NamesConstants.AMOUNT, amount);

        req.setAttribute(NamesConstants.SECURITY_SYMBOL, securitySymbol);
        req.setAttribute(NamesConstants.SECURITY_PRICE, securityPrice);
        req.setAttribute(NamesConstants.AMOUNT, amount);
        RoutingUtils.forwardToPage(JspPageName.SELL_SECURITY_FROM_PORTFOLIO_PAGE, req, resp);
    }
}