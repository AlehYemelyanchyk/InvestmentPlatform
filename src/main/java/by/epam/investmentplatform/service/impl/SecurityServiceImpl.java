package by.epam.investmentplatform.service.impl;

import by.epam.investmentplatform.dao.exceptions.DAOException;
import by.epam.investmentplatform.dao.factory.DAOFactory;
import by.epam.investmentplatform.entity.Security;
import by.epam.investmentplatform.entity.Transaction;
import by.epam.investmentplatform.service.SecurityService;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class SecurityServiceImpl implements SecurityService {

    private static final Logger LOGGER = LogManager.getLogger();
    private DAOFactory daoFactory = DAOFactory.getInstance();

    @Override
    public List<Security> getAllSecurities() throws ServiceException {
        try {
            return daoFactory.getSecurityDAO().getAllSecurities();
        } catch (DAOException e) {
            LOGGER.error("Get all securities error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Security> getAllUserSecurities(int userId) throws ServiceException {
        try {
            return daoFactory.getSecurityDAO().getAllUserSecurities(userId);
        } catch (DAOException e) {
            LOGGER.error("Get all user securities error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Security> getAllPortfolioSecurities(int portfolioId) throws ServiceException {
        try {
            return daoFactory.getSecurityDAO().getAllPortfolioSecurities(portfolioId);
        } catch (DAOException e) {
            LOGGER.error("Get all portfolio securities error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Security> getSecuritiesByExchange() throws ServiceException {
        return null;
    }

    @Override
    public List<Security> getSecuritiesByType() throws ServiceException {
        return null;
    }

    @Override
    public List<Transaction> getAllTransactions() throws ServiceException {
        try {
            return daoFactory.getSecurityDAO().getAllTransactions();
        } catch (DAOException e) {
            LOGGER.error("Get all transactions error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Transaction> getAllPortfolioTransactions(int portfolioId) throws ServiceException {
        try {
            return daoFactory.getSecurityDAO().getAllPortfolioTransactions(portfolioId);
        } catch (DAOException e) {
            LOGGER.error("Get all portfolio transactions error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Transaction> getAllUserTransactions(int userId) throws ServiceException {
        try {
            return daoFactory.getSecurityDAO().getAllUserTransactions(userId);
        } catch (DAOException e) {
            LOGGER.error("Get all user transactions error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public void saveSecurity (Security security) throws ServiceException{
        try {
            daoFactory.getSecurityDAO().saveSecurity(security);
        } catch (DAOException e) {
            LOGGER.error("Add security error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }
}
