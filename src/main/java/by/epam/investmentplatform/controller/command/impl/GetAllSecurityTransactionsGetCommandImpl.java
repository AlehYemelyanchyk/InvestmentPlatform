package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.Constants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.entity.Transaction;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetAllSecurityTransactionsGetCommandImpl extends AbstractCommandExecutor {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int portfolioId = Integer.parseInt(req.getParameter(Constants.PORTFOLIO_ID));
        String securityName = req.getParameter(Constants.SECURITY_NAME);
        String securitySymbol = req.getParameter(Constants.SECURITY_SYMBOL);
        List<Transaction> allPortfolioTransactions = SECURITY_SERVICE.getAllPortfolioTransactions(portfolioId);
        List<Transaction> filteredTransactions = filterTransactionsBySecurity(allPortfolioTransactions, securitySymbol);
        req.setAttribute(Constants.SECURITY_SYMBOL, securitySymbol);
        req.setAttribute(Constants.SECURITY_NAME, securityName);
        req.setAttribute(Constants.SECURITY_TRANSACTIONS, filteredTransactions);
        RoutingUtils.forwardToPage(JspPageName.GET_ALL_SECURITY_TRANSACTIONS, req, resp);
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