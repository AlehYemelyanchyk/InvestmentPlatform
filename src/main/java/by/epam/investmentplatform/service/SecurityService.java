package by.epam.investmentplatform.service;

import by.epam.investmentplatform.entity.Security;
import by.epam.investmentplatform.entity.Transaction;
import by.epam.investmentplatform.service.exceptions.ServiceException;

import java.util.List;

public interface SecurityService {
    List<Security> getAllSecurities() throws ServiceException;

    List<Security> getAllUserSecurities(int userId) throws ServiceException;

    List<Security> getAllPortfolioSecurities(int portfolioId) throws ServiceException;

    List<Security> getSecuritiesByExchange() throws ServiceException;

    List<Security> getSecuritiesByType() throws ServiceException;

    List<Transaction> getAllTransactions() throws ServiceException;

    List<Transaction> getAllPortfolioTransactions(int portfolioId) throws ServiceException;

    List<Transaction> getAllUserTransactions(int userId) throws ServiceException;

    void saveSecurity(Security security) throws ServiceException;

    void removeSecurity(String symbol) throws ServiceException;

    void removeSecurityFromPortfolio(int portfolioId, String symbol) throws ServiceException;
}
