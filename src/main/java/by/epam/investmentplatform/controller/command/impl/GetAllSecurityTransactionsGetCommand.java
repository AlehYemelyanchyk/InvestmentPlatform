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

public class GetAllSecurityTransactionsGetCommand extends AbstractCommandExecutor {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int portfolioId;
        if (req.getParameter(Constants.PORTFOLIO_ID) != null) {
            portfolioId = Integer.parseInt(req.getParameter(Constants.PORTFOLIO_ID));
        } else {
            portfolioId = (int) req.getSession().getAttribute(Constants.PORTFOLIO_ID);
        }

        String securityName;
        if (req.getParameter(Constants.SECURITY_NAME) != null) {
            securityName = req.getParameter(Constants.SECURITY_NAME);
        } else {
            securityName = (String) req.getSession().getAttribute(Constants.SECURITY_NAME);
        }

        String securitySymbol;
        if (req.getParameter(Constants.SECURITY_SYMBOL) != null) {
            securitySymbol = req.getParameter(Constants.SECURITY_SYMBOL);
        } else {
            securitySymbol = (String) req.getSession().getAttribute(Constants.SECURITY_SYMBOL);
        }

        List<Transaction> allPortfolioTransactions = SECURITY_SERVICE.getAllPortfolioTransactions(portfolioId);
        List<Transaction> filteredTransactions = filterTransactionsBySecurity(allPortfolioTransactions, securitySymbol);

        req.setAttribute(Constants.SECURITY_SYMBOL, securitySymbol);
        req.setAttribute(Constants.SECURITY_NAME, securityName);
        req.setAttribute(Constants.SECURITY_TRANSACTIONS, filteredTransactions);

        req.getSession().setAttribute(Constants.SECURITY_NAME, securityName);
        req.getSession().setAttribute(Constants.SECURITY_SYMBOL, securitySymbol);

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