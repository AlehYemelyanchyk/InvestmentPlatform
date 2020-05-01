package by.epam.investmentplatform.dao;

import by.epam.investmentplatform.dao.exceptions.DAOException;
import by.epam.investmentplatform.entity.Security;
import by.epam.investmentplatform.entity.Transaction;

import java.util.List;

public interface SecurityDAO {

    List<Security> getAllSecurities() throws DAOException;

    List<Security> getAllUserSecurities(int userId) throws DAOException;

    List<Security> getAllPortfolioSecurities(int portfolioId) throws DAOException;

    List<Security> getAllSecuritiesByExchange(int exchange) throws DAOException;

    List<Security> getAllSecuritiesByType(int type) throws DAOException;

    List<Security> getAllSecuritiesWithDividends(int type) throws DAOException;

    void removeSecurityFromPortfolio(int portfolioId, String symbol);

    List<Transaction> getAllTransactions() throws DAOException;

    List<Transaction> getAllPortfolioTransactions(int portfolioId) throws DAOException;

    List<Transaction> getAllUserTransactions(int userId) throws DAOException;

    void saveSecurity(Security security) throws DAOException;

    void saveTransaction(Transaction transaction) throws DAOException;

    void updateSecurity(Security security, String[] params) throws DAOException;

    void removeSecurity(String symbol) throws DAOException;

    void removeTransaction(int id) throws DAOException;
}
