package by.epam.investmentplatform.service.impl;

import by.epam.investmentplatform.dao.PortfolioDAO;
import by.epam.investmentplatform.dao.exceptions.DAOException;
import by.epam.investmentplatform.dao.impl.DAOFactory;
import by.epam.investmentplatform.entity.Portfolio;
import by.epam.investmentplatform.service.PortfolioService;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

class PortfolioServiceImpl implements PortfolioService {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final DAOFactory DAO_FACTORY = DAOFactory.getInstance();

    @Override
    public List<Portfolio> getAllUserPortfolios(int userId) throws ServiceException {
        try {
            return getPortfolioDAO().getAllUserPortfolios(userId);
        } catch (IndexOutOfBoundsException e) {
            LOGGER.error("The portfolio does not found: " + e.getMessage());
            throw new ServiceException(e);
        } catch (DAOException e) {
            LOGGER.error("Get all user portfolios error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public Portfolio getPortfolio(int portfolioId) throws ServiceException {
        try {
            return getPortfolioDAO().getPortfolio(portfolioId);
        } catch (DAOException e) {
            LOGGER.error("Get portfolio error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public void addPortfolio(Portfolio portfolio) throws ServiceException {
        try {
            getPortfolioDAO().savePortfolio(portfolio);
        } catch (DAOException e) {
            LOGGER.error("Add portfolio error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public void updatePortfolio(Portfolio portfolio, String[] params) throws ServiceException {
        try {
            getPortfolioDAO().updatePortfolio(portfolio, params);
        } catch (DAOException e) {
            LOGGER.error("Update portfolio error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public void removePortfolio(int portfolioId) throws ServiceException {
        try {
            getPortfolioDAO().removePortfolio(portfolioId);
        } catch (DAOException e) {
            LOGGER.error("Remove portfolio error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    PortfolioDAO getPortfolioDAO() {
        return DAO_FACTORY.getPortfolioDAO();
    }
}
