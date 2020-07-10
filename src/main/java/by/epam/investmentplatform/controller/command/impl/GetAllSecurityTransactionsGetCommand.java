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

public class GetAllSecurityTransactionsGetCommand extends AbstractCommand {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int portfolioId;
        if (req.getParameter(NamesConstants.PORTFOLIO_ID) != null) {
            portfolioId = Integer.parseInt(req.getParameter(NamesConstants.PORTFOLIO_ID));
        } else {
            portfolioId = (int) req.getSession().getAttribute(NamesConstants.PORTFOLIO_ID);
        }

        String securityName;
        if (req.getParameter(NamesConstants.SECURITY_NAME) != null) {
            securityName = req.getParameter(NamesConstants.SECURITY_NAME);
        } else {
            securityName = (String) req.getSession().getAttribute(NamesConstants.SECURITY_NAME);
        }

        String securitySymbol;
        if (req.getParameter(NamesConstants.SECURITY_SYMBOL) != null) {
            securitySymbol = req.getParameter(NamesConstants.SECURITY_SYMBOL);
        } else {
            securitySymbol = (String) req.getSession().getAttribute(NamesConstants.SECURITY_SYMBOL);
        }

        List<Transaction> allPortfolioTransactions;
        try {
            allPortfolioTransactions = securityService.getAllPortfolioTransactions(portfolioId);
        } catch (ServiceException e) {
            LOGGER.error("GetAllSecurityTransactionsGetCommand error: ", e);
            throw new ServletException("Incorrect values.");
        }
        List<Transaction> filteredTransactions = filterTransactionsBySecurity(allPortfolioTransactions, securitySymbol);

        req.setAttribute(NamesConstants.SECURITY_SYMBOL, securitySymbol);
        req.setAttribute(NamesConstants.SECURITY_NAME, securityName);
        req.setAttribute(NamesConstants.SECURITY_TRANSACTIONS, filteredTransactions);

        req.getSession().setAttribute(NamesConstants.SECURITY_NAME, securityName);
        req.getSession().setAttribute(NamesConstants.SECURITY_SYMBOL, securitySymbol);

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