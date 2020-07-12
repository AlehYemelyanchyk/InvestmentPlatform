package by.epam.investmentplatform.dao;

import by.epam.investmentplatform.dao.exceptions.DAOException;
import by.epam.investmentplatform.entity.Security;
import by.epam.investmentplatform.entity.Transaction;
import by.epam.investmentplatform.model.SecurityPrice;

import java.util.List;
import java.util.Map;

public interface SecurityDAO {

    List<Security> getAllSecurities() throws DAOException;

    List<Security> getAllUserSecurities(int userId) throws DAOException;

    List<Security> getAllPortfolioSecurities(int portfolioId) throws DAOException;

    List<Transaction> getAllTransactions() throws DAOException;

    List<Transaction> getAllUserTransactions(int userId) throws DAOException;

    List<Transaction> getAllPortfolioTransactions(int portfolioId) throws DAOException;

    Security getSecurity(String symbol) throws DAOException;

    List<SecurityPrice> getSecurityPrices(String symbol) throws DAOException;

    Transaction getTransaction(int id) throws DAOException;

    Map<Integer, String> getExchanges() throws DAOException;

    Map<Integer, String> getSecurityTypes() throws DAOException;

    void saveSecurity(Security security) throws DAOException;

    void saveTransaction(Transaction transaction) throws DAOException;

    void updateSecurity(Security security, String[] params) throws DAOException;

    void updateTransaction(Transaction transaction, String[] parameters) throws DAOException;

    void archiveSecurity(String symbol, String date) throws DAOException;

    void removeSecurity(String symbol) throws DAOException;

    void removeSecurityFromPortfolio(int portfolioId, String symbol) throws DAOException;

    void removeTransaction(int id) throws DAOException;
}
