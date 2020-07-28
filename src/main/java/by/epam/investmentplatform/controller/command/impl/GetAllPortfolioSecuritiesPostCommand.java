package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.NamesConstants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.entity.Security;
import by.epam.investmentplatform.entity.Transaction;
import by.epam.investmentplatform.model.PortfolioSecurity;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetAllPortfolioSecuritiesPostCommand extends AbstractCommand {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Map<String, PortfolioSecurity> securities = new HashMap<>();

        int portfolioId;
        if (req.getParameter(NamesConstants.PORTFOLIO_ID) != null) {
            portfolioId = Integer.parseInt(req.getParameter(NamesConstants.PORTFOLIO_ID));
        } else {
            portfolioId = (int) req.getSession().getAttribute(NamesConstants.PORTFOLIO_ID);
        }

        String portfolioName;
        if (req.getParameter(NamesConstants.PORTFOLIO_ID) != null) {
            portfolioName = req.getParameter(NamesConstants.PORTFOLIO_NAME);
        } else {
            portfolioName = (String) req.getSession().getAttribute(NamesConstants.PORTFOLIO_NAME);
        }

        req.getSession().setAttribute(NamesConstants.PORTFOLIO_ID, portfolioId);
        req.getSession().setAttribute(NamesConstants.PORTFOLIO_NAME, portfolioName);

        List<Security> allPortfolioSecurities;
        List<Transaction> allPortfolioTransactions;
        try {
            allPortfolioSecurities = securityService.getAllPortfolioSecurities(portfolioId);
            allPortfolioTransactions = securityService.getAllPortfolioTransactions(portfolioId);
        } catch (ServiceException e) {
            LOGGER.error("GetAllPortfolioSecuritiesPostCommand error: ", e);
            throw new ServletException("Incorrect values.");
        }

        fillPortfolioSecuritiesMap(securities, allPortfolioSecurities, allPortfolioTransactions);

        req.setAttribute(NamesConstants.PORTFOLIO_SECURITIES, securities);
        req.setAttribute(NamesConstants.PORTFOLIO_TRANSACTIONS, allPortfolioTransactions);
        RoutingUtils.forwardToPage(JspPageName.GET_ALL_PORTFOLIO_SECURITIES_PAGE, req, resp);
    }

    private void fillPortfolioSecuritiesMap(Map<String, PortfolioSecurity> securities, List<Security> allPortfolioSecurities, List<Transaction> allPortfolioTransactions) {
        allPortfolioSecurities.forEach(security -> {
            String symbol = security.getSymbol();
            String name = security.getName();
            String exchange = security.getExchange();
            int amount = countFullAmount(allPortfolioTransactions, symbol);
            double fullPrice = countFullPrice(allPortfolioTransactions, symbol);
            double averagePrice = fullPrice / amount;
            double yearChangePercents = security.getYearChangePercents();
            double dividends = security.getDividends();
            String securityType = security.getSecurityType();
            String stopTradeDate = security.getStopTradeDate();
            if (amount > 0) {
                securities.put(security.getSymbol(),
                        new PortfolioSecurity(symbol, name, exchange, amount, averagePrice, yearChangePercents, dividends, securityType, stopTradeDate));
            }
        });
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