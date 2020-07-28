package by.epam.investmentplatform.service;

import by.epam.investmentplatform.entity.Portfolio;
import by.epam.investmentplatform.service.exceptions.ServiceException;

import java.util.List;

/**
 * The interface provides methods to work with portfolios information in
 * a data source.
 *
 * @author Aleh Yemelyanchyk
 */
public interface PortfolioService {

    /**
     * Retrieves all user's portfolios stored in a data source based on the provided user's id.
     *
     * @return list of portfolios, which can't be null, but can be empty if there is no portfolios
     * in the data source.
     * @throws ServiceException if a DAOException is thrown from its invoked DAO level method.
     */
    List<Portfolio> getAllUserPortfolios(int userId) throws ServiceException;

    /**
     * Retrieves a specified portfolio from a data source based on its id.
     *
     * @param portfolioId is a portfolio's unique identifier in a data source.
     * @return a portfolio if there is an id match in a data source, null if there is no id match.
     * @throws ServiceException if a DAOException is thrown from its invoked DAO level method.
     */
    Portfolio getPortfolio(int portfolioId) throws ServiceException;

    /**
     * Stores a new portfolio in a data source.
     *
     * @param portfolio is a new portfolio object which should be stored in a date source.
     * @throws ServiceException if a DAOException is thrown from its invoked DAO level method.
     */
    void addPortfolio(Portfolio portfolio) throws ServiceException;

    /**
     * Updates the portfolio's parameters in a data source.
     *
     * @param portfolio is a portfolio object for which the parameters are have to be updated.
     * @param params an array of parameters with new values for the update.
     * @throws ServiceException if a DAOException is thrown from its invoked DAO level method.
     */
    void updatePortfolio(Portfolio portfolio, String[] params) throws ServiceException;

    /**
     * Removes the portfolio from a data source.
     *
     * @param portfolioId is a unique identifier of a portfolio which has to be deleted from
     *               a data source.
     * @throws ServiceException if a DAOException is thrown from its invoked DAO level method.
     */
    void removePortfolio(int portfolioId) throws ServiceException;
}
