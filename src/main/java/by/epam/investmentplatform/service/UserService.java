package by.epam.investmentplatform.service;

import by.epam.investmentplatform.entity.User;
import by.epam.investmentplatform.service.exceptions.ServiceException;

import java.util.List;

public interface UserService {

    List<User> getAllUsers() throws ServiceException;

    User getUser(int id) throws ServiceException;

    void signUp(User user) throws ServiceException;

    User logIn(String login, String password) throws ServiceException;

    void updateUser(User user, String[] params) throws ServiceException;

    void deleteUser(User user) throws ServiceException;

    List<String> getAllCountries() throws ServiceException;
}
