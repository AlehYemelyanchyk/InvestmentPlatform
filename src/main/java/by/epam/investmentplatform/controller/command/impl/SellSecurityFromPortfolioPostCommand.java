package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.CommandsConstants;
import by.epam.investmentplatform.Constants;
import by.epam.investmentplatform.NamesConstants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.entity.Transaction;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

public class SellSecurityFromPortfolioPostCommand extends AbstractCommand {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter(NamesConstants.PORTFOLIO_ID));
            String symbol = req.getParameter(NamesConstants.SECURITY_SYMBOL);
            int type = Integer.parseInt(req.getParameter(NamesConstants.TRANSACTION_TYPE));
            int amount = Integer.parseInt(req.getParameter(NamesConstants.AMOUNT));
            double price = Double.parseDouble(req.getParameter(NamesConstants.PRICE));
            LocalDate date = LocalDate.parse(req.getParameter(NamesConstants.DATE));
            Transaction transaction = new Transaction(id, symbol, type, amount, price, date);

            securityService.saveTransaction(transaction);
        } catch (NullPointerException e) {
            LOGGER.error("SellSecurityFromPortfolioPostCommand missing value error: ", e);
        } catch (ServiceException e) {
            LOGGER.error("SellSecurityFromPortfolioPostCommand error", e);
            throw new ServletException("Incorrect values.");
        }
        req.setAttribute(NamesConstants.REDIRECT_LINK, CommandsConstants.GET_ALL_USER_PORTFOLIOS);
        req.getSession().setAttribute(NamesConstants.REQUEST_METHOD, Constants.GET_METHOD);
        RoutingUtils.forwardToPage(JspPageName.REDIRECT_PAGE, req, resp);
    }
}
