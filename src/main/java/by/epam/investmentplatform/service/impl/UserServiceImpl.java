package by.epam.investmentplatform.service.impl;

import by.epam.investmentplatform.dao.UserDAO;
import by.epam.investmentplatform.dao.exceptions.DAOException;
import by.epam.investmentplatform.dao.impl.DAOFactory;
import by.epam.investmentplatform.entity.BalanceTransaction;
import by.epam.investmentplatform.entity.User;
import by.epam.investmentplatform.service.UserService;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.util.UserValidationUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final DAOFactory DAO_FACTORY = DAOFactory.getInstance();

    @Override
    public List<User> getAllUsers() throws ServiceException {
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
            if (newUser != null && hashPassword(password).equals(newUser.getPassword())) {
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
        return Integer.toString(password.hashCode());
    }
}
