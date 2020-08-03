package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.NamesConstants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.entity.Transaction;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetAllSecurityTransactionsPostCommand extends AbstractCommand {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Transaction> allPortfolioTransactions = null;
        String securitySymbol = null;
        try {
            int portfolioId = Integer.parseInt(req.getParameter(NamesConstants.PORTFOLIO_ID));
            String securityName = req.getParameter(NamesConstants.SECURITY_NAME);
            securitySymbol = req.getParameter(NamesConstants.SECURITY_SYMBOL);
            allPortfolioTransactions = securityService.getAllPortfolioTransactions(portfolioId);
            req.getSession().setAttribute(NamesConstants.SECURITY_NAME, securityName);
            req.getSession().setAttribute(NamesConstants.SECURITY_SYMBOL, securitySymbol);
        } catch (NullPointerException e) {
            LOGGER.error("GetAllSecurityTransactionsPostCommand missing value error: ", e);
        } catch (ServiceException e) {
            LOGGER.error("GetAllSecurityTransactionsPostCommand error: ", e);
            throw new ServletException("Incorrect values.");
        }
        List<Transaction> filteredTransactions = filterTransactionsBySecurity(allPortfolioTransactions, securitySymbol);
        req.setAttribute(NamesConstants.SECURITY_TRANSACTIONS, filteredTransactions);
        RoutingUtils.forwardToPage(JspPageName.GET_ALL_SECURITY_TRANSACTIONS_PAGE, req, resp);
    }

    private List<Transaction> filterTransactionsBySecurity(List<Transaction> transactions, String securitySymbol) {
        List<Transaction> filteredTransactions = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getSecuritySymbol().equals(securitySymbol)) {
                filteredTransactions.add(transaction);
            }
        }
        return filteredTransactions;
    }
}