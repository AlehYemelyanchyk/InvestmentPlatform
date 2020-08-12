package by.epam.investmentplatform.dao.impl;

import by.epam.investmentplatform.Constants;
import by.epam.investmentplatform.dao.UserDAO;
import by.epam.investmentplatform.dao.exceptions.DAOException;
import by.epam.investmentplatform.db.impl.DefaultConnectionPool;
import by.epam.investmentplatform.entity.BalanceTransaction;
import by.epam.investmentplatform.entity.User;
import by.epam.investmentplatform.util.DAOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

class SqlUserDAO implements UserDAO {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final DefaultConnectionPool CONNECTION_POOL = DefaultConnectionPool.getConnectionPoolInstance();
    private static final String COUNTRIES_COLUMN_NAME = "name";

    @Override
    public List<User> getAllUsers() throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<User> users;
        try {
            connection = CONNECTION_POOL.takeConnection();
            String sqlQuery = "SELECT a.id, a.role, a.login, a.password, a.email, a.name, a.surname, b.name as country, a.banned, a.transactionBanned " +
                    "FROM invest.users as a " +
                    "JOIN invest.countries as b " +
                    "ON a.country = b.ISO_numeric " +
                    "ORDER BY a.id";
            statement = connection.prepareStatement(sqlQuery);
            resultSet = statement.executeQuery();
            connection.commit();
            users = DAOUtils.usersResultSetHandle(resultSet);
        } catch (Exception e) {
            LOGGER.error("getAllUsers error: " + e.getMessage());
            throw new DAOException(e);
        } finally {
            try {
                DAOUtils.closeResources(connection, statement, resultSet);
            } catch (SQLException e) {
                LOGGER.error("getAllUsers close resources error: " + e.getMessage());
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
            String sqlQuery = "SELECT a.id, a.role, a.login, a.password, a.email, a.name, a.surname, b.name as country, a.banned, a.transactionBanned " +
                    "FROM invest.users as a " +
                    "JOIN invest.countries as b " +
                    "ON a.country = b.ISO_numeric " +
                    "WHERE a.id = ?";
            statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, String.valueOf(id));
            resultSet = statement.executeQuery();
            connection.commit();
            user = DAOUtils.usersResultSetHandle(resultSet).get(Constants.ZERO_LIST_ELEMENT);
        } catch (Exception e) {
            LOGGER.error("getUser error: " + e.getMessage());
            throw new DAOException(e);
        } finally {
            try {
                DAOUtils.closeResources(connection, statement, resultSet);
            } catch (SQLException e) {
                LOGGER.error("getUser close resources error: " + e.getMessage());
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
            String sqlQuery = "SELECT a.id, a.role, a.login, a.password, a.email, a.name, a.surname, b.name as country, a.banned, a.transactionBanned " +
                    "FROM invest.users as a " +
                    "JOIN invest.countries as b " +
                    "ON a.country = b.ISO_numeric " +
                    "WHERE a.login = ?";
            statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, String.valueOf(login));
            resultSet = statement.executeQuery();
            connection.commit();
            user = DAOUtils.usersResultSetHandle(resultSet).get(Constants.ZERO_LIST_ELEMENT);
        } catch (Exception e) {
            LOGGER.error("getUser error: " + e.getMessage());
            throw new DAOException(e);
        } finally {
            try {
                DAOUtils.closeResources(connection, statement, resultSet);
            } catch (SQLException e) {
                LOGGER.error("getUser close resources error: " + e.getMessage());
                throw new DAOException(e);
            }
        }
        return user;
    }

    @Override
    public List<Integer> getBannedUsersIdList() throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Integer> bannedUsersIdList;
        try {
            connection = CONNECTION_POOL.takeConnection();
            String sqlQuery = "SELECT id " +
                    "FROM invest.users " +
                    "WHERE banned = 1";
            statement = connection.prepareStatement(sqlQuery);
            resultSet = statement.executeQuery();
            connection.commit();
            bannedUsersIdList = DAOUtils.bannedUsersResultSetHandle(resultSet);
        } catch (Exception e) {
            LOGGER.error("getBannedUsersIdList error: " + e.getMessage());
            throw new DAOException(e);
        } finally {
            try {
                DAOUtils.closeResources(connection, statement, resultSet);
            } catch (SQLException e) {
                LOGGER.error("getBannedUsersIdList close resources error: " + e.getMessage());
                throw new DAOException(e);
            }
        }
        return bannedUsersIdList;
    }

    @Override
    public List<Integer> getBannedTransactionsUsersIdList() throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Integer> bannedUsersIdList;
        try {
            connection = CONNECTION_POOL.takeConnection();
            String sqlQuery = "SELECT id " +
                    "FROM invest.users " +
                    "WHERE transactionBanned = 1";
            statement = connection.prepareStatement(sqlQuery);
            resultSet = statement.executeQuery();
            connection.commit();
            bannedUsersIdList = DAOUtils.bannedUsersResultSetHandle(resultSet);
        } catch (Exception e) {
            LOGGER.error("getBannedTransactionsUsersIdList error: " + e.getMessage());
            throw new DAOException(e);
        } finally {
            try {
                DAOUtils.closeResources(connection, statement, resultSet);
            } catch (SQLException e) {
                LOGGER.error("getBannedTransactionsUsersIdList close resources error: " + e.getMessage());
                throw new DAOException(e);
            }
        }
        return bannedUsersIdList;
    }

    @Override
    public void saveUser(User user) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = CONNECTION_POOL.takeConnection();
            String country = getCountry(user.getCountry());
            String sqlQuery = "INSERT INTO invest.users (role, login, password, email, name, surname, country, banned, transactionBanned) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, user.getRole());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getName());
            statement.setString(6, user.getSurname());
            statement.setString(7, country);
            statement.setString(8, user.getBanned());
            statement.setString(9, user.getTransactionBanned());
            statement.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            LOGGER.error("saveUser error: " + e.getMessage());
            throw new DAOException(e);
        } finally {
            try {
                DAOUtils.closeResources(connection, statement);
            } catch (SQLException e) {
                LOGGER.error("saveUser close resources error: " + e.getMessage());
                throw new DAOException(e);
            }
        }
    }

    @Override
    public void updateUserPassword(int id, String password) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = CONNECTION_POOL.takeConnection();
            String sqlQuery = "UPDATE invest.users SET password = ? WHERE id = ?";
            statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, password);
            statement.setInt(2, id);
            statement.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            LOGGER.error("updateUser error: " + e.getMessage());
            throw new DAOException(e);
        } finally {
            try {
                DAOUtils.closeResources(connection, statement);
            } catch (SQLException e) {
                LOGGER.error("updateUser close resources error: " + e.getMessage());
                throw new DAOException(e);
            }
        }
    }

    @Override
    public void updateUser(String[] params) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        String countryCode = params[6];
        String country = getCountry(countryCode);
        try {
            connection = CONNECTION_POOL.takeConnection();
            String sqlQuery = "UPDATE invest.users SET email = ?, name = ?, surname = ?, country = ? WHERE id = ?";
            statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, params[3]);
            statement.setString(2, params[4]);
            statement.setString(3, params[5]);
            statement.setString(4, country);
            statement.setString(5, params[0]);
            statement.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            LOGGER.error("updateUser error: " + e.getMessage());
            throw new DAOException(e);
        } finally {
            try {
                DAOUtils.closeResources(connection, statement);
            } catch (SQLException e) {
                LOGGER.error("updateUser close resources error: " + e.getMessage());
                throw new DAOException(e);
            }
        }
    }

    @Override
    public void updateUser(User user, String[] params) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        String country = getCountry(user.getCountry());
        try {
            connection = CONNECTION_POOL.takeConnection();
            String sqlQuery = "UPDATE invest.users SET password = ?, email = ?, name = ?, surname = ?, country = ? WHERE id = ?";
            statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, user.getPassword());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getName());
            statement.setString(4, user.getSurname());
            statement.setString(5, country);
            statement.setInt(6, user.getId());
            statement.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            LOGGER.error("updateUser error: " + e.getMessage());
            throw new DAOException(e);
        } finally {
            try {
                DAOUtils.closeResources(connection, statement);
            } catch (SQLException e) {
                LOGGER.error("updateUser close resources error: " + e.getMessage());
                throw new DAOException(e);
            }
        }
    }

    @Override
    public void updateUserBanStatus(int userId, String[] params) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = CONNECTION_POOL.takeConnection();
            String sqlQuery = "UPDATE invest.users SET banned = ? WHERE id = ?";
            statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, params[Constants.ZERO_LIST_ELEMENT]);
            statement.setInt(2, userId);
            statement.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            LOGGER.error("updateUserBanStatus error: " + e.getMessage());
            throw new DAOException(e);
        } finally {
            try {
                DAOUtils.closeResources(connection, statement);
            } catch (SQLException e) {
                LOGGER.error("updateUserBanStatus close resources error: " + e.getMessage());
                throw new DAOException(e);
            }
        }
    }

    @Override
    public void updateUserTransactionBanStatus(int userId, String[] params) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = CONNECTION_POOL.takeConnection();
            String sqlQuery = "UPDATE invest.users SET transactionBanned = ? WHERE id = ?";
            statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, params[Constants.ZERO_LIST_ELEMENT]);
            statement.setInt(2, userId);
            statement.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            LOGGER.error("updateUserTransactionBanStatus error: " + e.getMessage());
            throw new DAOException(e);
        } finally {
            try {
                DAOUtils.closeResources(connection, statement);
            } catch (SQLException e) {
                LOGGER.error("updateUserTransactionBanStatus close resources error: " + e.getMessage());
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
            connection.commit();
        } catch (Exception e) {
            LOGGER.error("deleteUser error: " + e.getMessage());
            throw new DAOException(e);
        } finally {
            try {
                DAOUtils.closeResources(connection, statement);
            } catch (SQLException e) {
                LOGGER.error("deleteUser close resources error: " + e.getMessage());
                throw new DAOException(e);
            }
        }
    }

    @Override
    public List<BalanceTransaction> getUserBalanceTransactions(int id) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<BalanceTransaction> balanceTransactions;
        try {
            connection = CONNECTION_POOL.takeConnection();
            String sqlQuery = "SELECT b.id, a.user_id, b.transaction_type as type, b.amount * b.price as amount, b.date " +
                    "FROM invest.portfolios as a " +
                    "JOIN invest.transactions as b " +
                    "ON a.id = b.portfolio_id " +
                    "WHERE a.user_id = ? " +
                    "UNION " +
                    "SELECT b.id, b.user_id, b.type, b.amount, b.date " +
                    "FROM invest.portfolios as a " +
                    "JOIN invest.balance_transactions as b " +
                    "ON a.user_id = b.user_id " +
                    "WHERE a.user_id = ?";
            statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, id);
            statement.setInt(2, id);
            resultSet = statement.executeQuery();
            connection.commit();
            balanceTransactions = DAOUtils.balanceResultSetHandle(resultSet);
        } catch (Exception e) {
            LOGGER.error("getUserBalanceTransactions error: " + e.getMessage());
            throw new DAOException(e);
        } finally {
            try {
                DAOUtils.closeResources(connection, statement, resultSet);
            } catch (SQLException e) {
                LOGGER.error("getUserBalanceTransactions close resources error: " + e.getMessage());
                throw new DAOException(e);
            }
        }
        return balanceTransactions;
    }

    @Override
    public void addBalanceTransaction(int id, BalanceTransaction balanceTransaction) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = CONNECTION_POOL.takeConnection();
            String sqlQuery = "INSERT INTO invest.balance_transactions (user_id, type, amount, date) " +
                    "VALUES (?, ?, ?, ?)";

            statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, id);
            statement.setInt(2, balanceTransaction.getType());
            statement.setDouble(3, balanceTransaction.getAmount());
            statement.setObject(4, LocalDate.now());
            statement.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            LOGGER.error("addBalanceTransaction error: " + e.getMessage());
            throw new DAOException(e);
        } finally {
            try {
                DAOUtils.closeResources(connection, statement);
            } catch (SQLException e) {
                LOGGER.error("addBalanceTransaction close resources error: " + e.getMessage());
                throw new DAOException(e);
            }
        }
    }

    @Override
    public List<String> getAllCountries() throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<String> countries;
        try {
            connection = CONNECTION_POOL.takeConnection();
            String sqlQuery = "SELECT name FROM invest.countries";
            statement = connection.prepareStatement(sqlQuery);
            resultSet = statement.executeQuery();
            connection.commit();
            countries = DAOUtils.stringsResultSetHandle(resultSet, COUNTRIES_COLUMN_NAME);
        } catch (Exception e) {
            LOGGER.error("getAllCountries error: " + e.getMessage());
            throw new DAOException(e);
        } finally {
            try {
                DAOUtils.closeResources(connection, statement, resultSet);
            } catch (SQLException e) {
                LOGGER.error("getAllCountries close resources error: " + e.getMessage());
                throw new DAOException(e);
            }
        }
        return countries;
    }

    private String getCountry(String countryName) throws DAOException {
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
            connection.commit();
            while (resultSet.next()) {
                country = resultSet.getString("ISO_numeric");
            }
        } catch (Exception e) {
            LOGGER.error("getCountry error: " + e.getMessage());
            throw new DAOException(e);
        } finally {
            try {
                DAOUtils.closeResources(connection, statement, resultSet);
            } catch (SQLException e) {
                LOGGER.error("getCountry close resources error: " + e.getMessage());
                throw new DAOException(e);
            }

        }
        return country;
    }
}
