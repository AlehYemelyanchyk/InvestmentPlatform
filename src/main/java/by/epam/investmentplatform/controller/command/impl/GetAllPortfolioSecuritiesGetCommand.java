package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.Constants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.entity.Security;
import by.epam.investmentplatform.entity.Transaction;
import by.epam.investmentplatform.model.PortfolioSecurity;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetAllPortfolioSecuritiesGetCommand extends AbstractCommandExecutor {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Map<String, PortfolioSecurity> securities = new HashMap<>();

        int portfolioId;
        if(req.getParameter(Constants.PORTFOLIO_ID) != null) {
            portfolioId = Integer.parseInt(req.getParameter(Constants.PORTFOLIO_ID));
        } else {
            portfolioId = (int) req.getSession().getAttribute(Constants.PORTFOLIO_ID);
        }

        String portfolioName;
        if(req.getParameter(Constants.PORTFOLIO_ID) != null) {
            portfolioName = req.getParameter(Constants.PORTFOLIO_NAME);
        } else {
            portfolioName = (String) req.getSession().getAttribute(Constants.PORTFOLIO_NAME);
        }

        req.getSession().setAttribute(Constants.PORTFOLIO_ID, portfolioId);
        req.getSession().setAttribute(Constants.PORTFOLIO_NAME, portfolioName);
        List<Security> allPortfolioSecurities = SECURITY_SERVICE.getAllPortfolioSecurities(portfolioId);
        List<Transaction> allPortfolioTransactions = SECURITY_SERVICE.getAllPortfolioTransactions(portfolioId);

        fillPortfolioSecuritiesMap(securities, allPortfolioSecurities, allPortfolioTransactions);

        req.setAttribute(Constants.PORTFOLIO_SECURITIES, securities);
        req.setAttribute(Constants.PORTFOLIO_TRANSACTIONS, allPortfolioTransactions);
        RoutingUtils.forwardToPage(JspPageName.GET_ALL_PORTFOLIO_SECURITIES, req, resp);
    }

    private void fillPortfolioSecuritiesMap(Map<String, PortfolioSecurity> securities, List<Security> allPortfolioSecurities, List<Transaction> allPortfolioTransactions) {
        for (Security security : allPortfolioSecurities) {
            String symbol = security.getSymbol();
            String name = security.getName();
            String exchange = security.getExchange();
            int amount = countFullAmount(allPortfolioTransactions, symbol);
            double fullPrice = countFullPrice(allPortfolioTransactions, symbol);
            double averagePrice = fullPrice / amount;
            double yearChangePercents = security.getYearChangePercents();
            double dividends = security.getDividends();
            String securityType = security.getSecurityType();
            securities.put(security.getSymbol(),
                    new PortfolioSecurity(symbol, name, exchange, amount, averagePrice, yearChangePercents, dividends, securityType));
        }
    }

    private double countFullPrice(List<Transaction> allPortfolioTransactions, String symbol) {
        double fullPrice = 0.0;
        for (Transaction transaction : allPortfolioTransactions) {
            if (transaction.getSecuritySymbol().equals(symbol)) {
                fullPrice = (transaction.getTransactionType() == 1)
                        ? fullPrice + (transaction.getPrice() * transaction.getAmount())
                        : fullPrice - (transaction.getPrice() * transaction.getAmount());
            }
        }
        return fullPrice;
    }

    private int countFullAmount(List<Transaction> allPortfolioTransactions, String symbol) {
        int fullAmount = 0;
        for (Transaction transaction : allPortfolioTransactions) {
            if (transaction.getSecuritySymbol().equals(symbol)) {
                fullAmount = (transaction.getTransactionType() == 1)
                        ? fullAmount + transaction.getAmount() : fullAmount - transaction.getAmount();
            }
        }
        return fullAmount;
    }
}