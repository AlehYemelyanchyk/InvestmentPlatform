package by.epam.investmentplatform.dao.impl;

import by.epam.investmentplatform.Constants;
import by.epam.investmentplatform.dao.PortfolioDAO;
import by.epam.investmentplatform.dao.exceptions.DAOException;
import by.epam.investmentplatform.db.impl.ConnectionPoolImpl;
import by.epam.investmentplatform.entity.Portfolio;
import by.epam.investmentplatform.util.DAOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SqlPortfolioDAOImpl implements PortfolioDAO {
    private static final Logger LOGGER = LogManager.getLogger(SqlPortfolioDAOImpl.class);
    private static final ConnectionPoolImpl CONNECTION_POOL = ConnectionPoolImpl.getConnectionPoolInstance();

    @Override
    public List<Portfolio> getAllUserPortfolios(int userId) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Portfolio> portfolios;
        try {
            connection = CONNECTION_POOL.takeConnection();
            String sqlQuery = "SELECT * FROM invest.portfolios WHERE user_id = ?";
            statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, userId);
            resultSet = statement.executeQuery();
            portfolios = DAOUtils.portfoliosResultSetHandler(resultSet);
        } catch (Exception e) {
            LOGGER.error("DAO: Get all portfolios SQL error: " + e.getMessage());
            throw new DAOException(e);
        } finally {
            try {
                DAOUtils.closeResources(connection, statement, resultSet);
            } catch (SQLException e) {
                LOGGER.error("SQL disconnection error: " + e.getMessage());
                throw new DAOException(e);
            }
        }
        return portfolios;
    }

    @Override
    public Portfolio getPortfolio(int portfolioId) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Portfolio portfolio = null;
        try {
            connection = CONNECTION_POOL.takeConnection();
            String sqlQuery = "SELECT * FROM invest.portfolios WHERE id = ?";
            statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, portfolioId);
            resultSet = statement.executeQuery();
            portfolio = DAOUtils.portfoliosResultSetHandler(resultSet).get(Constants.ZERO_LIST_ELEMENT);
        } catch (Exception e) {
            LOGGER.error("DAO: Get portfolio SQL error: " + e.getMessage());
            throw new DAOException(e);
        } finally {
            try {
                DAOUtils.closeResources(connection, statement, resultSet);
            } catch (SQLException e) {
                LOGGER.error("SQL disconnection error: " + e.getMessage());
                throw new DAOException(e);
            }
        }
        return portfolio;
    }

    @Override
    public void savePortfolio(Portfolio portfolio) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = CONNECTION_POOL.takeConnection();
            String sqlQuery = "INSERT INTO invest.portfolios (user_id, name) VALUES (?, ?);";
            statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, portfolio.getUser_id());
            statement.setString(2, portfolio.getName());
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
    public void updatePortfolio(Portfolio portfolio, String[] params) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = CONNECTION_POOL.takeConnection();
            String sqlQuery = "UPDATE invest.portfolios SET name = ? WHERE id = ?";
            statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, params[Constants.ZERO_LIST_ELEMENT]);
            statement.setString(2, String.valueOf(portfolio.getId()));
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
    public void removePortfolio(int portfolioId) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = CONNECTION_POOL.takeConnection();
            String sqlQuery = "DELETE FROM invest.portfolios WHERE id = ?;";
            statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, portfolioId);
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
}
