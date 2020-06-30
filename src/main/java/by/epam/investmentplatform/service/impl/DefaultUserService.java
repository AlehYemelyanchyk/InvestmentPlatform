package by.epam.investmentplatform.service.impl;

import by.epam.investmentplatform.dao.UserDAO;
import by.epam.investmentplatform.dao.exceptions.DAOException;
import by.epam.investmentplatform.dao.impl.DAOFactory;
import by.epam.investmentplatform.entity.BalanceTransaction;
import by.epam.investmentplatform.entity.User;
import by.epam.investmentplatform.service.UserService;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.util.UserValidationUtils;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static de.mkammerer.argon2.Argon2Factory.Argon2Types.ARGON2id;

class DefaultUserService implements UserService {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final DAOFactory DAO_FACTORY = DAOFactory.getInstance();

    private static final Argon2 ARGON_2 = Argon2Factory.create(ARGON2id);

    @Override
    public List<User> getAllUsers(int userRole) throws ServiceException {
        UserValidationUtils.adminValidation(userRole);
        try {
            return getUserDAO().getAllUsers();
        } catch (DAOException e) {
            LOGGER.error("getAllUsers error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public User getUser(int id) throws ServiceException {
        try {
            return getUserDAO().getUser(id);
        } catch (DAOException e) {
            LOGGER.error("getUser error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public User getUser(String login) throws ServiceException {
        try {
            return getUserDAO().getUser(login);
        } catch (DAOException e) {
            LOGGER.error("getUser error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Integer> getBannedUsersIdList() throws ServiceException {
        try {
            return getUserDAO().getBannedUsersIdList();
        } catch (DAOException e) {
            LOGGER.error("getBannedUsersIdList error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Integer> getBannedTransactionsUsersIdList() throws ServiceException {
        try {
            return getUserDAO().getBannedTransactionsUsersIdList();
        } catch (DAOException e) {
            LOGGER.error("getBannedTransactionsUsersIdList error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public void signUp(User user) throws ServiceException {
        UserValidationUtils.userValidation(user);
        UserValidationUtils.loginValidation(user.getLogin());
        UserValidationUtils.passwordValidation(user.getPassword());
        UserValidationUtils.emailValidation(user.getEmail());
        String hashedPassword = hashPassword(user.getPassword());
        user.setPassword(hashedPassword);
        try {
            getUserDAO().saveUser(user);
        } catch (DAOException e) {
            LOGGER.error("signUp error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public User logIn(String login, String password) throws ServiceException {
        UserValidationUtils.loginValidation(login);
        UserValidationUtils.passwordValidation(password);
        User user = null;
        try {
            User newUser = getUserDAO().getUser(login);
            if (newUser != null && verifyPassword(newUser.getPassword(), password)) {
                user = newUser;
            }
        } catch (DAOException e) {
            LOGGER.error("logIn error: " + e.getMessage());
            throw new ServiceException(e);
        }
        return user;
    }

    @Override
    public void updateUser(User user, String[] params) throws ServiceException {
        UserValidationUtils.userValidation(user);
        UserValidationUtils.loginValidation(user.getLogin());
        UserValidationUtils.passwordValidation(user.getPassword());

        String hashedPassword = hashPassword(user.getPassword());
        user.setPassword(hashedPassword);
        try {
            getUserDAO().updateUser(user, params);
        } catch (DAOException e) {
            LOGGER.error("updateUser error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public void updateUserBanStatus(int userId, String[] params) throws ServiceException {
        try {
            getUserDAO().updateUserBanStatus(userId, params);
        } catch (DAOException e) {
            LOGGER.error("updateUserBanStatus error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public void updateUserTransactionBanStatus(int userId, String[] params) throws ServiceException {
        try {
            getUserDAO().updateUserTransactionBanStatus(userId, params);
        } catch (DAOException e) {
            LOGGER.error("updateUserTransactionBanStatus error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteUser(User user) throws ServiceException {
        UserValidationUtils.userValidation(user);
        UserValidationUtils.loginValidation(user.getLogin());
        try {
            getUserDAO().deleteUser(user);
        } catch (DAOException e) {
            LOGGER.error("deleteUser error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public List<BalanceTransaction> getUserBalanceTransactions(int id) throws ServiceException {
        try {
            return getUserDAO().getUserBalanceTransactions(id);
        } catch (DAOException e) {
            LOGGER.error("getUserBalanceTransactions error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public void addBalanceTransaction(int id, BalanceTransaction balanceTransaction) throws ServiceException {
        try {
            getUserDAO().addBalanceTransaction(id, balanceTransaction);
        } catch (DAOException e) {
            LOGGER.error("addBalanceTransaction error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public List<String> getAllCountries() throws ServiceException {
        try {
            return getUserDAO().getAllCountries();
        } catch (DAOException e) {
            LOGGER.error("getAllCountries error: " + e.getMessage());
            throw new ServiceException("Data source connection error.", e);
        }
    }

    UserDAO getUserDAO() {
        return DAO_FACTORY.getUserDAO();
    }

    private String hashPassword(String password) {
        String hash = ARGON_2.hash(4, 1024 * 1024, 8, password.toCharArray());
        return hash;
    }

    private boolean verifyPassword(String hash, String password) {
        return ARGON_2.verify(hash, password.toCharArray());
    }
}
