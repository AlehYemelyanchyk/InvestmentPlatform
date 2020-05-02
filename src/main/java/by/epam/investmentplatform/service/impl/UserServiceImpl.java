package by.epam.investmentplatform.service.impl;

import by.epam.investmentplatform.dao.exceptions.DAOException;
import by.epam.investmentplatform.dao.impl.DAOFactory;
import by.epam.investmentplatform.entity.User;
import by.epam.investmentplatform.service.UserService;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.util.UserValidationUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LogManager.getLogger();
    private DAOFactory daoFactory = DAOFactory.getInstance();

    @Override
    public List<User> getAllUsers() throws ServiceException {
        try {
            return daoFactory.getUserDAO().getAllUsers();
        } catch (DAOException e) {
            LOGGER.error("Get all users error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public User getUser(int id) throws ServiceException {
        try {
            return daoFactory.getUserDAO().getUser(id);
        } catch (DAOException e) {
            LOGGER.error("Get user error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public void signUp(User user) throws ServiceException {
        UserValidationUtils.loginValidation(user.getLogin());
        UserValidationUtils.passwordValidation(user.getPassword());
        UserValidationUtils.emailValidation(user.getEmail());
        String hashedPassword = hashPassword(user.getPassword());
        user.setPassword(hashedPassword);
        try {
            daoFactory.getUserDAO().saveUser(user);
        } catch (DAOException e) {
            LOGGER.error("Create user error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public User logIn(String login, String password) throws ServiceException {
        UserValidationUtils.loginValidation(login);
        UserValidationUtils.passwordValidation(password);
        User user = null;
        try {
            User newUser = daoFactory.getUserDAO().getUser(login);
            if (newUser != null && hashPassword(password).equals(newUser.getPassword())) {
                user = newUser;
            }
        } catch (DAOException e) {
            LOGGER.error("Create user error: " + e.getMessage());
            throw new ServiceException(e);
        }
        return user;
    }

    @Override
    public void updateUser(User user, String[] params) throws ServiceException {
        UserValidationUtils.loginValidation(user.getLogin());
        UserValidationUtils.passwordValidation(user.getPassword());
        try {
            daoFactory.getUserDAO().updateUser(user, params);
        } catch (DAOException e) {
            LOGGER.error("Update user error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteUser(User user) throws ServiceException {
        UserValidationUtils.loginValidation(user.getLogin());
        try {
            daoFactory.getUserDAO().deleteUser(user);
        } catch (DAOException e) {
            LOGGER.error("Update user error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public List<String> getAllCountries() throws ServiceException {
        try {
            return daoFactory.getUserDAO().getAllCountries();
        } catch (DAOException e) {
            LOGGER.error("Service: " + e.getMessage());
            throw new ServiceException("Data source connection error.");
        }
    }

    private String hashPassword(String password) {
        return Integer.toString(password.hashCode());
    }
}
