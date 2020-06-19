package by.epam.investmentplatform.dao.impl;

import by.epam.investmentplatform.Constants;
import by.epam.investmentplatform.dao.SecurityDAO;
import by.epam.investmentplatform.dao.exceptions.DAOException;
import by.epam.investmentplatform.db.impl.DefaultConnectionPool;
import by.epam.investmentplatform.entity.Security;
import by.epam.investmentplatform.entity.Transaction;
import by.epam.investmentplatform.model.SecurityPrice;
import by.epam.investmentplatform.util.DAOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.List;

class SqlSecurityDAO implements SecurityDAO {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final DefaultConnectionPool CONNECTION_POOL = DefaultConnectionPool.getConnectionPoolInstance();

    @Override
    public List<Security> getAllSecurities() throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Security> securities;
        try {
            connection = CONNECTION_POOL.takeConnection();
            String sqlQuery = "SELECT a.symbol, a.name, b.name as exchange, a.current_price, a.year_change_percents, a.dividends, c.type as security_type " +
                    "FROM invest.securities as a " +
                    "JOIN invest.exchanges as b " +
                    "ON a.exchange = b.id " +
                    "JOIN invest.security_types as c " +
                    "ON a.security_type = c.id ";
            statement = connection.prepareStatement(sqlQuery);
            resultSet = statement.executeQuery();
            connection.commit();
            securities = DAOUtils.securitiesResultSetHandle(resultSet);
        } catch (Exception e) {
            LOGGER.error("getAllSecurities error: " + e.getMessage());
            throw new DAOException(e);
        } finally {
            try {
                DAOUtils.closeResources(connection, statement, resultSet);
            } catch (SQLException e) {
                LOGGER.error("getAllSecurities close resources error: " + e.getMessage());
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
            LOGGER.error("getAllUserSecurities error: " + e.getMessage());
            throw new DAOException(e);
        } finally {
            try {
                DAOUtils.closeResources(connection, statement, resultSet);
            } catch (SQLException e) {
                LOGGER.error("getAllUserSecurities close resources error: " + e.getMessage());
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
            String sqlQuery = "SELECT a.symbol, a.name, c.name as exchange, a.current_price, a.year_change_percents, a.dividends, d.type as security_type " +
                    "FROM invest.securities as a " +
                    "JOIN invest.transactions as b " +
                    "ON a.symbol = b.security_symbol " +
                    "JOIN invest.exchanges as c " +
                    "ON a.exchange = c.id " +
                    "JOIN invest.security_types as d " +
                    "ON a.security_type = d.id " +
                    "WHERE b.portfolio_id = ?";
            statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, portfolioId);
            resultSet = statement.executeQuery();
            connection.commit();
            securities = DAOUtils.securitiesResultSetHandle(resultSet);
        } catch (Exception e) {
            LOGGER.error("getAllPortfolioSecurities error: " + e.getMessage());
            throw new DAOException(e);
        } finally {
            try {
                DAOUtils.closeResources(connection, statement, resultSet);
            } catch (SQLException e) {
                LOGGER.error("getAllPortfolioSecurities close resources error: " + e.getMessage());
                throw new DAOException(e);
            }
        }
        return securities;
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
            LOGGER.error("getAllTransactions error: " + e.getMessage());
            throw new DAOException(e);
        } finally {
            try {
                DAOUtils.closeResources(connection, statement, resultSet);
            } catch (SQLException e) {
                LOGGER.error("getAllTransactions close resources error: " + e.getMessage());
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
            LOGGER.error("getAllUserTransactions error: " + e.getMessage());
            throw new DAOException(e);
        } finally {
            try {
                DAOUtils.closeResources(connection, statement, resultSet);
            } catch (SQLException e) {
                LOGGER.error("getAllUserTransactions close resources error: " + e.getMessage());
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
            LOGGER.error("getAllPortfolioTransactions error: " + e.getMessage());
            throw new DAOException(e);
        } finally {
            try {
                DAOUtils.closeResources(connection, statement, resultSet);
            } catch (SQLException e) {
                LOGGER.error("getAllPortfolioTransactions close resources error: " + e.getMessage());
                throw new DAOException(e);
            }
        }
        return transactions;
    }

    @Override
    public Security getSecurity(String symbol) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Security security;
        try {
            connection = CONNECTION_POOL.takeConnection();
            String sqlQuery = "SELECT a.symbol, a.name, c.name as exchange, a.current_price, a.year_change_percents, a.dividends, d.type as security_type " +
                    "FROM invest.securities as a " +
                    "JOIN invest.exchanges as c " +
                    "ON a.exchange = c.id " +
                    "JOIN invest.security_types as d " +
                    "ON a.security_type = d.id " +
                    "WHERE a.symbol = ?";
            statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, symbol);
            resultSet = statement.executeQuery();
            connection.commit();
            security = DAOUtils.securitiesResultSetHandle(resultSet).get(Constants.ZERO_LIST_ELEMENT);
        } catch (Exception e) {
            LOGGER.error("getSecurity error: " + e.getMessage());
            throw new DAOException(e);
        } finally {
            try {
                DAOUtils.closeResources(connection, statement, resultSet);
            } catch (SQLException e) {
                LOGGER.error("getSecurity close resources error: " + e.getMessage());
                throw new DAOException(e);
            }
        }
        return security;
    }

    @Override
    public List<SecurityPrice> getSecurityPrices(String symbol) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<SecurityPrice> prices;
        try {
            connection = CONNECTION_POOL.takeConnection();
            String sqlQuery = "SELECT * FROM invest.price_history " +
                    "WHERE symbol = ? " +
                    "ORDER BY date";
            statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, symbol);
            resultSet = statement.executeQuery();
            connection.commit();
            prices = DAOUtils.pricesResultSetHandle(resultSet);
        } catch (Exception e) {
            LOGGER.error("getSecurityPrices error: " + e.getMessage());
            throw new DAOException(e);
        } finally {
            try {
                DAOUtils.closeResources(connection, statement, resultSet);
            } catch (SQLException e) {
                LOGGER.error("getSecurityPrices close resources error: " + e.getMessage());
                throw new DAOException(e);
            }
        }
        return prices;
    }

    @Override
    public Transaction getTransaction(int id) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Transaction transaction;
        try {
            connection = CONNECTION_POOL.takeConnection();
            String sqlQuery = "SELECT * " +
                    "FROM invest.transactions " +
                    "WHERE id = ?";
            statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            connection.commit();
            transaction = DAOUtils.transactionsResultSetHandle(resultSet).get(Constants.ZERO_LIST_ELEMENT);
        } catch (Exception e) {
            LOGGER.error("getTransaction error: " + e.getMessage());
            throw new DAOException(e);
        } finally {
            try {
                DAOUtils.closeResources(connection, statement, resultSet);
            } catch (SQLException e) {
                LOGGER.error("getTransaction close resources error: " + e.getMessage());
                throw new DAOException(e);
            }
        }
        return transaction;
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
            LOGGER.error("saveSecurity error: " + e.getMessage());
            throw new DAOException(e);
        } finally {
            try {
                DAOUtils.closeResources(connection, statement);
            } catch (SQLException e) {
                LOGGER.error("saveSecurity close resources error: " + e.getMessage());
                throw new DAOException(e);
            }
        }
    }

    @Override
    public void saveTransaction(Transaction transaction) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        String sqlQuery;

        try {
            connection = CONNECTION_POOL.takeConnection();
            sqlQuery = "INSERT INTO invest.transactions (portfolio_id, security_symbol, transaction_type, amount, price, date) " +
                    "VALUES (?, ?, ?, ?, ?, ?);";

            statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, transaction.getPortfolioId());
            statement.setString(2, transaction.getSecuritySymbol());
            statement.setInt(3, transaction.getTransactionType());
            statement.setDouble(4, transaction.getAmount());
            statement.setDouble(5, transaction.getPrice());
            statement.setDate(6, (Date) transaction.getDate());
            statement.executeUpdate();
            connection.commit();

        } catch (Exception e) {
            LOGGER.error("saveTransaction error: " + e.getMessage());
            throw new DAOException(e);
        } finally {
            try {
                DAOUtils.closeResources(connection, statement);
            } catch (SQLException e) {
                LOGGER.error("saveTransaction close resources error: " + e.getMessage());
                throw new DAOException(e);
            }
        }
    }

    @Override
    public void updateSecurity(Security security, String[] params) throws DAOException {

    }

    @Override
    public void updateTransaction(Transaction transaction, String[] parameters) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = CONNECTION_POOL.takeConnection();
            String sqlQuery = "UPDATE invest.transactions " +
                    "SET transaction_type = ?, amount = ?, price = ?, date = ? " +
                    "WHERE id = ?";
            statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, transaction.getTransactionType());
            statement.setInt(2, transaction.getAmount());
            statement.setDouble(3, transaction.getPrice());
            statement.setString(4, parameters[Constants.ZERO_LIST_ELEMENT]);
            statement.setInt(5, transaction.getId());
            statement.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            LOGGER.error("updateSecurity error: " + e.getMessage());
            throw new DAOException(e);
        } finally {
            try {
                DAOUtils.closeResources(connection, statement);
            } catch (SQLException e) {
                LOGGER.error("updateSecurity close resources error: " + e.getMessage());
                throw new DAOException(e);
            }
        }
    }

    @Override
    public void removeSecurity(String symbol) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = CONNECTION_POOL.takeConnection();
            String sqlQuery = "DELETE FROM invest.securities WHERE symbol = ?;";
            statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, symbol);
            statement.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            LOGGER.error("removeSecurity error: " + e.getMessage());
            throw new DAOException(e);
        } finally {
            try {
                DAOUtils.closeResources(connection, statement);
            } catch (SQLException e) {
                LOGGER.error("removeSecurity close resources error: " + e.getMessage());
                throw new DAOException(e);
            }
        }
    }

    @Override
    public void removeSecurityFromPortfolio(int portfolioId, String symbol) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = CONNECTION_POOL.takeConnection();
            String sqlQuery = "DELETE FROM invest.transactions " +
                    "WHERE portfolio_id = ? AND security_symbol = ?";
            statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, portfolioId);
            statement.setString(2, symbol);
            statement.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            LOGGER.error("removeSecurityFromPortfolio error: " + e.getMessage());
            throw new DAOException(e);
        } finally {
            try {
                DAOUtils.closeResources(connection, statement);
            } catch (SQLException e) {
                LOGGER.error("removeSecurityFromPortfolio close resources error: " + e.getMessage());
                throw new DAOException(e);
            }
        }
    }

    @Override
    public void removeTransaction(int id) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = CONNECTION_POOL.takeConnection();
            String sqlQuery = "DELETE FROM invest.transactions WHERE id = ?;";
            statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, id);
            statement.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            LOGGER.error("removeTransaction error: " + e.getMessage());
            throw new DAOException(e);
        } finally {
            try {
                DAOUtils.closeResources(connection, statement);
            } catch (SQLException e) {
                LOGGER.error("removeTransaction close resources error: " + e.getMessage());
                throw new DAOException(e);
            }
        }
    }
}
