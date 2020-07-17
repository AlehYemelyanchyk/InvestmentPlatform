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

public class AddSecurityToPortfolioWindowPostCommand extends AbstractCommand {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String securitySymbol;
        double securityPrice;
        try {
            if (req.getParameter(NamesConstants.SECURITY_SYMBOL) != null) {
                securitySymbol = req.getParameter(NamesConstants.SECURITY_SYMBOL);
            } else {
                securitySymbol = (String) req.getSession().getAttribute(NamesConstants.SECURITY_SYMBOL);
            }
            if (req.getParameter(NamesConstants.SECURITY_PRICE) != null) {
                securityPrice = Double.parseDouble(req.getParameter(NamesConstants.SECURITY_PRICE));
            } else {
                securityPrice = (double) req.getSession().getAttribute(NamesConstants.SECURITY_PRICE);
            }
            int userId = (int) req.getSession().getAttribute(NamesConstants.CURRENT_USER_ID);
            List<Portfolio> portfolios = portfolioService.getAllUserPortfolios(userId);
            req.setAttribute(NamesConstants.PORTFOLIOS_LIST, portfolios);
        } catch (NullPointerException e) {
            LOGGER.error("AddSecurityToPortfolioWindowPostCommand error: ", e);
            throw new ServletException("Missing values.");
        } catch (ServiceException e) {
            LOGGER.error("AddSecurityToPortfolioWindowPostCommand error: ", e);
            throw new ServletException("Incorrect values.");
        }
        req.getSession().setAttribute(NamesConstants.SECURITY_SYMBOL, securitySymbol);
        req.getSession().setAttribute(NamesConstants.SECURITY_PRICE, securityPrice);

        req.setAttribute(NamesConstants.SECURITY_SYMBOL, securitySymbol);
        req.setAttribute(NamesConstants.SECURITY_PRICE, securityPrice);
        RoutingUtils.forwardToPage(JspPageName.ADD_SECURITY_TO_PORTFOLIO_PAGE, req, resp);
    }
}