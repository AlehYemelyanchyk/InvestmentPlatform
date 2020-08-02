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
        try {
            String securitySymbol = req.getParameter(NamesConstants.SECURITY_SYMBOL);
            double securityPrice = Double.parseDouble(req.getParameter(NamesConstants.SECURITY_PRICE));
            int userId = (int) req.getSession().getAttribute(NamesConstants.CURRENT_USER_ID);

            List<Portfolio> portfolios = portfolioService.getAllUserPortfolios(userId);
            req.setAttribute(NamesConstants.PORTFOLIOS_LIST, portfolios);
            req.setAttribute(NamesConstants.SECURITY_SYMBOL, securitySymbol);
            req.setAttribute(NamesConstants.SECURITY_PRICE, securityPrice);
        } catch (NullPointerException e) {
            LOGGER.error("AddSecurityToPortfolioWindowPostCommand missing value error: ", e);
        } catch (ServiceException e) {
            LOGGER.error("AddSecurityToPortfolioWindowPostCommand error: ", e);
            throw new ServletException("Incorrect values.");
        }
        RoutingUtils.forwardToPage(JspPageName.ADD_SECURITY_TO_PORTFOLIO_PAGE, req, resp);
    }
}