package by.epam.investmentplatform.service.impl;

import by.epam.investmentplatform.dao.SecurityDAO;
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
    private static final SecurityDAO SECURITY_DAO = DAOFactory.getInstance().getSecurityDAO();

    @Override
    public List<Security> getAllSecurities() throws ServiceException {
        try {
            return SECURITY_DAO.getAllSecurities();
        } catch (DAOException e) {
            LOGGER.error("Get all securities error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Security> getAllUserSecurities(int userId) throws ServiceException {
        try {
            return SECURITY_DAO.getAllUserSecurities(userId);
        } catch (DAOException e) {
            LOGGER.error("Get all user securities error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Security> getAllPortfolioSecurities(int portfolioId) throws ServiceException {
        try {
            return SECURITY_DAO.getAllPortfolioSecurities(portfolioId);
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
            return SECURITY_DAO.getAllTransactions();
        } catch (DAOException e) {
            LOGGER.error("Get all transactions error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Transaction> getAllPortfolioTransactions(int portfolioId) throws ServiceException {
        try {
            return SECURITY_DAO.getAllPortfolioTransactions(portfolioId);
        } catch (DAOException e) {
            LOGGER.error("Get all portfolio transactions error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Transaction> getAllUserTransactions(int userId) throws ServiceException {
        try {
            return SECURITY_DAO.getAllUserTransactions(userId);
        } catch (DAOException e) {
            LOGGER.error("Get all user transactions error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public void saveSecurity(Security security) throws ServiceException {
        try {
            SECURITY_DAO.saveSecurity(security);
        } catch (DAOException e) {
            LOGGER.error("Add security error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public void saveTransaction(Transaction transaction) throws ServiceException {
        try {
            SECURITY_DAO.saveTransaction(transaction);
        } catch (DAOException e) {
            LOGGER.error("Add transaction error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public void removeSecurity(String symbol) throws ServiceException {
        try {
            SECURITY_DAO.removeSecurity(symbol);
        } catch (DAOException e) {
            LOGGER.error("Remove security error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public void removeTransaction(int id) throws ServiceException {
        try {
            SECURITY_DAO.removeTransaction(id);
        } catch (DAOException e) {
            LOGGER.error("Remove transaction error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public void removeSecurityFromPortfolio(int portfolioId, String symbol) throws ServiceException {
        try {
            SECURITY_DAO.removeSecurityFromPortfolio(portfolioId, symbol);
        } catch (DAOException e) {
            LOGGER.error("Remove security from portfolio error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }
}
