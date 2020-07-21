package by.epam.investmentplatform.controller.filter;

import by.epam.investmentplatform.NamesConstants;
import by.epam.investmentplatform.entity.Security;
import by.epam.investmentplatform.entity.Transaction;
import by.epam.investmentplatform.service.SecurityService;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.service.impl.ServiceFactory;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter(filterName = "UpdateTransactionsFilter")
public class UpdateTransactionsFilter extends AbstractFilter {

    private final SecurityService securityService = ServiceFactory.getInstance().getSecurityService();

    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        List<Transaction> transactionsLastTenList = new ArrayList<>();
        List<Security> lastTenDelistedSecurities = new ArrayList<>();
        try {
            List<Transaction> transactionsList = securityService.getAllTransactions();
            List<Security> delistedSecuritiesList = securityService.getAllDelistedSecurities();
            lastTenDelistedSecurities = delistedSecuritiesList.subList(0, Math.min(delistedSecuritiesList.size(), 9));
            transactionsLastTenList = getLastTenSecurities(transactionsList);
        } catch (ServiceException e) {
            LOGGER.error("UpdateTransactionsFilter error: ", e);
        }
        req.setAttribute(NamesConstants.TRANSACTIONS_LIST, transactionsLastTenList);
        req.setAttribute(NamesConstants.SECURITIES_LIST, lastTenDelistedSecurities);
        filterChain.doFilter(req, resp);
    }

    private List<Transaction> getLastTenSecurities(List<Transaction> transactionsList) {
        List<Transaction> transactionsLastTenList = new ArrayList<>();
        for (Transaction transaction : transactionsList) {
            if (!hasSecurity(transactionsLastTenList, transaction)) {
                transactionsLastTenList.add(transaction);
            }
            if (transactionsLastTenList.size() >= 10) {
                break;
            }
        }
        return transactionsLastTenList;
    }

    private boolean hasSecurity(List<Transaction> transactions, Transaction transaction) {
        for (Transaction listedTransaction : transactions) {
            if (transaction.getSecuritySymbol().equals(listedTransaction.getSecuritySymbol())) {
                return true;
            }
        }
        return false;
    }
}
