package by.epam.investmentplatform.service;

import by.epam.investmentplatform.entity.Security;
import by.epam.investmentplatform.entity.Transaction;
import by.epam.investmentplatform.model.SecurityPrice;
import by.epam.investmentplatform.service.exceptions.ServiceException;

import java.util.List;
import java.util.Map;

/**
 * The interface provides methods to work with securities and transactions information in
 * a data source.
 *
 * @author Aleh Yemelyanchyk
 */
public interface SecurityService {

    /**
     * Retrieves all securities stored in a data source.
     *
     * @return list of securities, which can't be null, but can be empty if there is no securities
     * in the data source.
     * @throws ServiceException if a DAOException is thrown from its invoked DAO level method.
     */
    List<Security> getAllSecurities() throws ServiceException;

    /**
     * Retrieves all user's securities stored in a data source based on the provided user's id.
     *
     * @return list of securities, which can't be null, but can be empty if there is no securities
     * in the data source.
     * @throws ServiceException if a DAOException is thrown from its invoked DAO level method.
     */
    List<Security> getAllUserSecurities(int userId) throws ServiceException;

    /**
     * Retrieves all securities in a portfolio stored in a data source based on the provided portfolio's id.
     *
     * @return list of securities, which can't be null, but can be empty if there is no securities
     * in the data source.
     * @throws ServiceException if a DAOException is thrown from its invoked DAO level method.
     */
    List<Security> getAllPortfolioSecurities(int portfolioId) throws ServiceException;

    /**
     * Retrieves all transactions stored in a data source.
     *
     * @return list of transactions, which can't be null, but can be empty if there is no transactions
     * in the data source.
     * @throws ServiceException if a DAOException is thrown from its invoked DAO level method.
     */
    List<Transaction> getAllTransactions() throws ServiceException;

    /**
     * Retrieves all user's transactions stored in a data source based on the provided user's id.
     *
     * @return list of transactions, which can't be null, but can be empty if there is no transactions
     * in the data source.
     * @throws ServiceException if a DAOException is thrown from its invoked DAO level method.
     */
    List<Transaction> getAllUserTransactions(int userId) throws ServiceException;

    /**
     * Retrieves all transactions by portfolio stored in a data source based on the provided portfolio's id.
     *
     * @return list of transactions, which can't be null, but can be empty if there is no transactions
     * in the data source.
     * @throws ServiceException if a DAOException is thrown from its invoked DAO level method.
     */
    List<Transaction> getAllPortfolioTransactions(int portfolioId) throws ServiceException;

    /**
     * Retrieves a specified security from a data source based on its symbol.
     *
     * @param symbol is a security's unique identifier in a data source.
     * @return a security if there is a symbol match in a data source, null if there is no symbol match.
     * @throws ServiceException if a DAOException is thrown from its invoked DAO level method.
     */
    Security getSecurity(String symbol) throws ServiceException;

    /**
     * Retrieves all prices by security stored in a data source based on the provided security symbol.
     *
     * @return list of prices, which can't be null, but can be empty if there is no price history
     * in the data source.
     * @throws ServiceException if a DAOException is thrown from its invoked DAO level method.
     */
    List<SecurityPrice> getSecurityPrices(String symbol) throws ServiceException;

    /**
     * Retrieves a specified transaction from a data source based on its id.
     *
     * @param id is a transaction's unique identifier in a data source.
     * @return a transaction if there is an id match in a data source, null if there is no id match.
     * @throws ServiceException if a DAOException is thrown from its invoked DAO level method.
     */
    Transaction getTransaction(int id) throws ServiceException;

    /**
     * Stores a new security in a data source.
     *
     * @param security is a new transaction object which should be stored in a date source.
     * @throws ServiceException if a DAOException is thrown from its invoked DAO level method.
     */

    /**
     * Retrieves all exchange types stored in a data source.
     *
     * @return map of exchange types where key is id and value is name, which can't be null, but can be empty if there is no exchange types
     * in the data source.
     * @throws ServiceException if a DAOException is thrown from its invoked DAO level method.
     */
    Map<Integer, String> getExchanges() throws ServiceException;

    /**
     * Retrieves all security types stored in a data source.
     *
     * @return map of security types where key is id and value is type, which can't be null, but can be empty if there is no security types
     * in the data source.
     * @throws ServiceException if a DAOException is thrown from its invoked DAO level method.
     */
    Map<Integer, String> getSecurityTypes() throws ServiceException;

    void saveSecurity(Security security) throws ServiceException;

    /**
     * Stores a new transaction in a data source.
     *
     * @param transaction is a new transaction object which should be stored in a date source.
     * @throws ServiceException if a DAOException is thrown from its invoked DAO level method.
     */
    void saveTransaction(Transaction transaction) throws ServiceException;

    /**
     * Updates the security's parameters in a data source.
     *
     * @param security   is a security object for which the parameters are have to be updated.
     * @param parameters an array of parameters with new values for the update.
     * @throws ServiceException if a DAOException is thrown from its invoked DAO level method.
     */
    void updateSecurity(Security security, String[] parameters) throws ServiceException;

    /**
     * Updates the security's parameters in a data source.
     *
     * @param transaction is a transaction object for which the parameters are have to be updated.
     * @param params      an array of parameters with new values for the update.
     * @throws ServiceException if a DAOException is thrown from its invoked DAO level method.
     */
    void updateTransaction(Transaction transaction, String[] params) throws ServiceException;

    /**
     * Removes the security from a data source.
     *
     * @param symbol is a unique identifier of a security which has to be deleted from
     *               a data source.
     * @throws ServiceException if a DAOException is thrown from its invoked DAO level method.
     */
    void removeSecurity(String symbol) throws ServiceException;

    /**
     * Removes the security in a specified portfolio from a data source.
     *
     * @param portfolioId is a unique identifier of a portfolio.
     * @param symbol      is a unique identifier of a security which has to be deleted from
     *                    a data source.
     * @throws ServiceException if a DAOException is thrown from its invoked DAO level method.
     */
    void removeSecurityFromPortfolio(int portfolioId, String symbol) throws ServiceException;

    /**
     * Removes the transaction from a data source.
     *
     * @param id is a unique identifier of a transaction which has to be deleted from
     *           a data source.
     * @throws ServiceException if a DAOException is thrown from its invoked DAO level method.
     */
    void removeTransaction(int id) throws ServiceException;
}
