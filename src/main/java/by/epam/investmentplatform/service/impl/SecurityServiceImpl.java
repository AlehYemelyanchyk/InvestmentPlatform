package by.epam.investmentplatform.service.impl;

import by.epam.investmentplatform.dao.SecurityDAO;
import by.epam.investmentplatform.dao.exceptions.DAOException;
import by.epam.investmentplatform.dao.impl.DAOFactory;
import by.epam.investmentplatform.entity.Security;
import by.epam.investmentplatform.entity.Transaction;
import by.epam.investmentplatform.service.SecurityService;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

class SecurityServiceImpl implements SecurityService {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final DAOFactory DAO_FACTORY = DAOFactory.getInstance();

    @Override
    public List<Security> getAllSecurities() throws ServiceException {
        try {
            return getSecurityDAO().getAllSecurities();
        } catch (DAOException e) {
            LOGGER.error("Get all securities error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Security> getAllUserSecurities(int userId) throws ServiceException {
        try {
            return getSecurityDAO().getAllUserSecurities(userId);
        } catch (DAOException e) {
            LOGGER.error("Get all user securities error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Security> getAllPortfolioSecurities(int portfolioId) throws ServiceException {
        try {
            return getSecurityDAO().getAllPortfolioSecurities(portfolioId);
        } catch (DAOException e) {
            LOGGER.error("Get all portfolio securities error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Transaction> getAllTransactions() throws ServiceException {
        try {
            return getSecurityDAO().getAllTransactions();
        } catch (DAOException e) {
            LOGGER.error("Get all transactions error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Transaction> getAllUserTransactions(int userId) throws ServiceException {
        try {
            return getSecurityDAO().getAllUserTransactions(userId);
        } catch (DAOException e) {
            LOGGER.error("Get all user transactions error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Transaction> getAllPortfolioTransactions(int portfolioId) throws ServiceException {
        try {
            return getSecurityDAO().getAllPortfolioTransactions(portfolioId);
        } catch (DAOException e) {
            LOGGER.error("Get all portfolio transactions error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public Security getSecurity(String symbol) throws ServiceException {
        return null;
    }

    @Override
    public Transaction getTransaction(int id) throws ServiceException {
        try {
            return getSecurityDAO().getTransaction(id);
        } catch (DAOException e) {
            LOGGER.error("Get transaction error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public void saveSecurity(Security security) throws ServiceException {
        try {
            getSecurityDAO().saveSecurity(security);
        } catch (DAOException e) {
            LOGGER.error("Add security error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public void saveTransaction(Transaction transaction) throws ServiceException {
        try {
            getSecurityDAO().saveTransaction(transaction);
        } catch (DAOException e) {
            LOGGER.error("Add transaction error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public void updateSecurity(Security security, String[] parameters) throws ServiceException {
    }

    @Override
    public void updateTransaction(Transaction transaction, String[] parameters) throws ServiceException {
        try {
            getSecurityDAO().updateTransaction(transaction, parameters);
        } catch (DAOException e) {
            LOGGER.error("Update transaction error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public void removeSecurity(String symbol) throws ServiceException {
        try {
            getSecurityDAO().removeSecurity(symbol);
        } catch (DAOException e) {
            LOGGER.error("Remove security error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public void removeSecurityFromPortfolio(int portfolioId, String symbol) throws ServiceException {
        try {
            getSecurityDAO().removeSecurityFromPortfolio(portfolioId, symbol);
        } catch (DAOException e) {
            LOGGER.error("Remove security from portfolio error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public void removeTransaction(int id) throws ServiceException {
        try {
            getSecurityDAO().removeTransaction(id);
        } catch (DAOException e) {
            LOGGER.error("Remove transaction error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    SecurityDAO getSecurityDAO() {
        return DAO_FACTORY.getSecurityDAO();
    }
}
