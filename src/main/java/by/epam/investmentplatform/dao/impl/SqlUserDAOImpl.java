package by.epam.investmentplatform.dao.impl;

import by.epam.investmentplatform.Constants;
import by.epam.investmentplatform.dao.UserDAO;
import by.epam.investmentplatform.dao.exceptions.DAOException;
import by.epam.investmentplatform.db.impl.ConnectionPoolImpl;
import by.epam.investmentplatform.entity.User;
import by.epam.investmentplatform.util.DAOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SqlUserDAOImpl implements UserDAO {
    private static final Logger LOGGER = LogManager.getLogger(SqlUserDAOImpl.class);
    private static final ConnectionPoolImpl CONNECTION_POOL = ConnectionPoolImpl.getConnectionPoolInstance();
    private static final String COUNTRIES_COLUMN_NAME = "name";

    @Override
    public List<User> getAllUsers() throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<User> users;
        try {
            connection = CONNECTION_POOL.takeConnection();
            String sqlQuery = "SELECT * FROM invest.users ORDER BY invest.users.id";
            statement = connection.prepareStatement(sqlQuery);
            resultSet = statement.executeQuery();
            users = DAOUtils.usersResultSetHandler(resultSet);
        } catch (Exception e) {
            LOGGER.error("SQL connection error: " + e.getMessage());
            throw new DAOException(e);
        } finally {
            try {
                DAOUtils.closeResources(connection, statement, resultSet);
            } catch (SQLException e) {
                LOGGER.error("SQL disconnection error: " + e.getMessage());
                throw new DAOException(e);
            }
        }
        return users;
    }

    @Override
    public User getUser(int id) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user;
        try {
            connection = CONNECTION_POOL.takeConnection();
            String sqlQuery = "SELECT * FROM invest.users WHERE invest.users.id = ?";
            statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, String.valueOf(id));
            resultSet = statement.executeQuery();
            user = DAOUtils.usersResultSetHandler(resultSet).get(Constants.ZERO_LIST_ELEMENT);
        } catch (Exception e) {
            LOGGER.error("SQL connection error: " + e.getMessage());
            throw new DAOException(e);
        } finally {
            try {
                DAOUtils.closeResources(connection, statement, resultSet);
            } catch (SQLException e) {
                LOGGER.error("SQL disconnection error: " + e.getMessage());
                throw new DAOException(e);
            }
        }
        return user;
    }

    @Override
    public User getUser(String login) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user;
        try {
            connection = CONNECTION_POOL.takeConnection();
            String sqlQuery = "SELECT * FROM invest.users WHERE invest.users.login = ?";
            statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, String.valueOf(login));
            resultSet = statement.executeQuery();
            user = DAOUtils.usersResultSetHandler(resultSet).get(Constants.ZERO_LIST_ELEMENT);
        } catch (Exception e) {
            LOGGER.error("SQL connection error: " + e.getMessage());
            throw new DAOException(e);
        } finally {
            try {
                DAOUtils.closeResources(connection, statement, resultSet);
            } catch (SQLException e) {
                LOGGER.error("SQL disconnection error: " + e.getMessage());
                throw new DAOException(e);
            }
        }
        return user;
    }


    @Override
    public void saveUser(User user) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = CONNECTION_POOL.takeConnection();
            String country = getCountry(user.getCountry());
            String sqlQuery = "INSERT INTO invest.users (role, login, password, email, name, surname, country) VALUES (?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, user.getRole());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getName());
            statement.setString(6, user.getSurname());
            statement.setString(7, country);
            statement.executeUpdate();
        } catch (Exception e) {
            LOGGER.error("SQL connection error: " + e.getMessage());
            throw new DAOException(e);
        } finally {
            try {
                DAOUtils.closeResources(connection, statement);
            } catch (SQLException e) {
                LOGGER.error("SQL disconnection error: " + e.getMessage());
                throw new DAOException(e);
            }
        }
    }

    @Override
    public void updateUser(User user, String[] params) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = CONNECTION_POOL.takeConnection();
            String sqlQuery = "UPDATE invest.users SET ? = ? WHERE id = ?";
            statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, params[0]);
            statement.setString(2, params[1]);
            statement.setString(3, String.valueOf(user.getId()));
            statement.executeUpdate();
        } catch (Exception e) {
            LOGGER.error("SQL connection error: " + e.getMessage());
            throw new DAOException(e);
        } finally {
            try {
                DAOUtils.closeResources(connection, statement);
            } catch (SQLException e) {
                LOGGER.error("SQL disconnection error: " + e.getMessage());
                throw new DAOException(e);
            }
        }
    }

    @Override
    public void deleteUser(User user) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = CONNECTION_POOL.takeConnection();
            String sqlQuery = "DELETE FROM invest.users WHERE invest.users.id = ?";
            statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, String.valueOf(user.getId()));
            statement.executeUpdate();
        } catch (Exception e) {
            LOGGER.error("SQL connection error: " + e.getMessage());
            throw new DAOException(e);
        } finally {
            try {
                DAOUtils.closeResources(connection, statement);
            } catch (SQLException e) {
                LOGGER.error("SQL disconnection error: " + e.getMessage());
                throw new DAOException(e);
            }
        }
    }

    @Override
    public List<String> getAllCountries() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<String> countries;
        try {
            connection = CONNECTION_POOL.takeConnection();
            String sqlQuery = "SELECT name FROM invest.countries";
            statement = connection.prepareStatement(sqlQuery);
            resultSet = statement.executeQuery();
            countries = DAOUtils.stringsResultSetHandler(resultSet, COUNTRIES_COLUMN_NAME);
        } catch (Exception e) {
            LOGGER.error("DAO: Get all countries SQL error: " + e.getMessage());
            throw new DAOException(e);
        } finally {
            try {
                DAOUtils.closeResources(connection, statement, resultSet);
            } catch (SQLException e) {
                LOGGER.error("SQL disconnection error: " + e.getMessage());
                throw new DAOException(e);
            }
        }
        return countries;
    }

    private String getCountry(String countryName) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String country = null;
        try {
            connection = CONNECTION_POOL.takeConnection();
            String sqlQuery = "SELECT ISO_numeric FROM invest.countries WHERE name = ? ";
            statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, countryName);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                country = resultSet.getString("ISO_numeric");
            }
        } catch (Exception e) {
            LOGGER.error("DAO: Get country error: " + e.getMessage());
            throw new DAOException(e);
        } finally {
            try {
                DAOUtils.closeResources(connection, statement, resultSet);
            } catch (SQLException e) {
                LOGGER.error("SQL disconnection error: " + e.getMessage());
                throw new DAOException(e);
            }

        }
        return country;
    }
}
