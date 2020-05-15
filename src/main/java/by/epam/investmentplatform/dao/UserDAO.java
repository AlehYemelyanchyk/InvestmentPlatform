package by.epam.investmentplatform.dao;

import by.epam.investmentplatform.dao.exceptions.DAOException;
import by.epam.investmentplatform.entity.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers() throws DAOException;

    User getUser(int id) throws DAOException;

    User getUser(String login) throws DAOException;

    void saveUser(User user) throws DAOException;

    void updateUser(User user, String[] params) throws DAOException;

    void deleteUser(User user) throws DAOException;

    List<String> getAllCountries() throws DAOException;
}
