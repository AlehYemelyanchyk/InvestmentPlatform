package by.epam.investmentplatform.dao.impl;

import by.epam.investmentplatform.dao.SecurityDAO;
import by.epam.investmentplatform.dao.exceptions.DAOException;
import by.epam.investmentplatform.db.impl.ConnectionPoolImpl;
import by.epam.investmentplatform.entity.Security;
import by.epam.investmentplatform.entity.Transaction;
import by.epam.investmentplatform.util.DAOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SqlSecurityDAOImpl implements SecurityDAO {
    private static final Logger LOGGER = LogManager.getLogger(SqlSecurityDAOImpl.class);
    private static final ConnectionPoolImpl CONNECTION_POOL = ConnectionPoolImpl.getConnectionPoolInstance();

    @Override
    public List<Security> getAllSecurities() throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Security> securities;
        try {
            connection = CONNECTION_POOL.takeConnection();
            String sqlQuery = "SELECT * FROM invest.securities";
            statement = connection.prepareStatement(sqlQuery);
            resultSet = statement.executeQuery();
            connection.commit();
            securities = DAOUtils.securitiesResultSetHandle(resultSet);
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
        return securities;
    }

    @Override
    public List<Security> getAllUserSecurities(int userId) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Security> securities;
        try {
            connection = CONNECTION_POOL.takeConnection();
            String sqlQuery = "SELECT a.symbol, a.name, a.exchange, a.current_price, a.year_change_percents, a.dividends, a.security_type, b.transaction_type " +
                    "FROM invest.securities " +
                    "JOIN invest.transactions as b " +
                    "ON a.symbol = b.security_symbol " +
                    "WHERE b.portfolio_id = ?";
            statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, userId);
            resultSet = statement.executeQuery();
            connection.commit();
            securities = DAOUtils.securitiesResultSetHandle(resultSet);
        } catch (Exception e) {
            LOGGER.error("DAO: Get all user securities SQL error: " + e.getMessage());
            throw new DAOException(e);
        } finally {
            try {
                DAOUtils.closeResources(connection, statement, resultSet);
            } catch (SQLException e) {
                LOGGER.error("SQL disconnection error: " + e.getMessage());
                throw new DAOException(e);
            }
        }
        return securities;
    }

    @Override
    public List<Security> getAllPortfolioSecurities(int portfolioId) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Security> securities;
        try {
            connection = CONNECTION_POOL.takeConnection();
            String sqlQuery = "SELECT a.symbol, a.name, a.exchange, a.current_price, a.year_change_percents, a.dividends, a.security_type, b.transaction_type " +
                    "FROM invest.securities as a " +
                    "JOIN invest.transactions as b " +
                    "ON a.symbol = b.security_symbol " +
                    "WHERE b.portfolio_id = ?";
            statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, portfolioId);
            resultSet = statement.executeQuery();
            connection.commit();
            securities = DAOUtils.securitiesResultSetHandle(resultSet);
        } catch (Exception e) {
            LOGGER.error("DAO: Get all user securities SQL error: " + e.getMessage());
            throw new DAOException(e);
        } finally {
            try {
                DAOUtils.closeResources(connection, statement, resultSet);
            } catch (SQLException e) {
                LOGGER.error("SQL disconnection error: " + e.getMessage());
                throw new DAOException(e);
            }
        }
        return securities;
    }

    @Override
    public List<Security> getAllSecuritiesByExchange(int exchange) throws DAOException {
        return null;
    }

    @Override
    public List<Security> getAllSecuritiesByType(int type) throws DAOException {
        return null;
    }

    @Override
    public List<Security> getAllSecuritiesWithDividends(int type) throws DAOException {
        return null;
    }

    @Override
    public List<Transaction> getAllTransactions() throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Transaction> transactions;
        try {
            connection = CONNECTION_POOL.takeConnection();
            String sqlQuery = "SELECT * FROM invest.transactions";
            statement = connection.prepareStatement(sqlQuery);
            resultSet = statement.executeQuery();
            connection.commit();
            transactions = DAOUtils.transactionsResultSetHandle(resultSet);
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
        return transactions;
    }

    @Override
    public List<Transaction> getAllPortfolioTransactions(int portfolioId) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Transaction> transactions;
        try {
            connection = CONNECTION_POOL.takeConnection();
            String sqlQuery = "SELECT * " +
                    "FROM invest.transactions " +
                    "WHERE portfolio_id = ?";
            statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, portfolioId);
            resultSet = statement.executeQuery();
            connection.commit();
            transactions = DAOUtils.transactionsResultSetHandle(resultSet);
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
        return transactions;
    }

    @Override
    public List<Transaction> getAllUserTransactions(int userId) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Transaction> transactions;
        try {
            connection = CONNECTION_POOL.takeConnection();
            String sqlQuery = "b.id, b.portfolio_id, b.security_symbol, b.transaction_type, b.amount, b.price, b.date " +
                    "FROM invest.portfolios as a " +
                    "JOIN invest.transactions as b " +
                    "ON a.id = b.portfolio_id " +
                    "WHERE a.user_id = ?";
            statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, userId);
            resultSet = statement.executeQuery();
            connection.commit();
            transactions = DAOUtils.transactionsResultSetHandle(resultSet);
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
        return transactions;
    }

    @Override
    public void saveSecurity(Security security) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        String sqlQuery;

        try {
            connection = CONNECTION_POOL.takeConnection();
            if (security.getDividends() == 0) {
                sqlQuery = "INSERT INTO invest.securities (symbol, name, exchange, current_price, year_change_percents, security_type) " +
                        "VALUES (?, ?, ?, ?, ?, ?);";
            } else {
                sqlQuery = "INSERT INTO invest.securities (symbol, name, exchange, current_price, year_change_percents, security_type, dividends) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?);";
            }

            statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, security.getSymbol());
            statement.setString(2, security.getName());
            statement.setString(3, security.getExchange());
            statement.setDouble(4, security.getCurrentPrice());
            statement.setDouble(5, security.getYearChangePercents());
            statement.setString(6, security.getSecurityType());
            if (security.getDividends() != 0) {
                statement.setDouble(7, security.getDividends());
            }
            statement.executeUpdate();
            connection.commit();

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
    public void updateSecurity(Security security, String[] params) throws DAOException {

    }

    @Override
    public void removeSecurity(String symbol) throws DAOException {

    }
}
