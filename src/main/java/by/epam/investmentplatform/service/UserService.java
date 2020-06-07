package by.epam.investmentplatform.service;

import by.epam.investmentplatform.entity.BalanceTransaction;
import by.epam.investmentplatform.entity.User;
import by.epam.investmentplatform.service.exceptions.ServiceException;

import java.util.List;

/**
 * The interface provides methods to work with users' information in a data source.
 *
 * @author Aleh Yemelyanchyk
 */
public interface UserService {

    /**
     * Retrieves all users, registered in the system and stored in a data source.
     *
     * @return list of users, which can't be null, but can be empty if there is no users
     * in the data source.
     * @throws ServiceException if a DAOException is thrown from its invoked DAO level method.
     */
    List<User> getAllUsers() throws ServiceException;

    /**
     * Retrieves a specified used from a data source based on its id.
     *
     * @param id is a user's id in a data source.
     * @return a user if there is an id match in a data source, null if there is no id match.
     * @throws ServiceException if a DAOException is thrown from its invoked DAO level method.
     */
    User getUser(int id) throws ServiceException;

    /**
     * Creates a new user and stores it in a data source.
     *
     * @param user is a new user object created with provided parameters.
     * @throws ServiceException if a DAOException is thrown from its invoked DAO level method.
     */
    void signUp(User user) throws ServiceException;

    /**
     * Retrieves a user from a data source based on a provided login.
     *
     * @param login    is a String parameter used for a login match in a data source.
     * @param password is a String parameter used to compare if the provided password matches the
     *                 the retrieved user's password.
     * @return a user if the provided login and password matched with the existing in a data
     * source user's login and password, returns null if whether login or password doesn't match.
     * @throws ServiceException if a DAOException is thrown from its invoked DAO level method.
     */
    User logIn(String login, String password) throws ServiceException;

    /**
     * Updates the user's parameters in a data source.
     *
     * @param user   is a user for which the parameters are need to be updated.
     * @param params an array of parameters with new values for the update.
     * @throws ServiceException if a DAOException is thrown from its invoked DAO level method.
     */
    void updateUser(User user, String[] params) throws ServiceException;

    /**
     * Deletes the user from a data source.
     *
     * @param user is a user which has to be deleted from a data source.
     * @throws ServiceException if a DAOException is thrown from its invoked DAO level method.
     */
    void deleteUser(User user) throws ServiceException;

    /**
     * Retrieves from a data source all the transactions of a user based on the provided id.
     * These transactions are used to calculate a user's balance and to see a history of all
     * user's transactions.
     *
     * @param id is a user's id in a data source.
     * @return list of balance transactions.
     * @throws ServiceException if a DAOException is thrown from its invoked DAO level method.
     */
    List<BalanceTransaction> getUserBalanceTransactions(int id) throws ServiceException;

    /**
     * Adds a new transaction for the user.
     *
     * @param id is a user's id in a data source.
     * @param balanceTransaction a new transaction.
     */
    void addBalanceTransaction(int id, BalanceTransaction balanceTransaction) throws ServiceException;

    /**
     * Retrieves all countries from a data source.
     *
     * @return list of users, which can't be null, but can be empty if there is no countries
     * in the data source.
     * @throws ServiceException if a DAOException is thrown from its invoked DAO level method.
     */
    List<String> getAllCountries() throws ServiceException;
}
