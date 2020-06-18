package by.epam.investmentplatform.service.impl;

import by.epam.investmentplatform.dao.SecurityDAO;
import by.epam.investmentplatform.dao.exceptions.DAOException;
import by.epam.investmentplatform.dao.impl.DAOFactory;
import by.epam.investmentplatform.entity.Security;
import by.epam.investmentplatform.entity.Transaction;
import by.epam.investmentplatform.model.SecurityPrice;
import by.epam.investmentplatform.service.SecurityService;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

class DefaultSecurityService implements SecurityService {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final DAOFactory DAO_FACTORY = DAOFactory.getInstance();

    @Override
    public List<Security> getAllSecurities() throws ServiceException {
        try {
            return getSecurityDAO().getAllSecurities();
        } catch (DAOException e) {
            LOGGER.error("getAllSecurities error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Security> getAllUserSecurities(int userId) throws ServiceException {
        try {
            return getSecurityDAO().getAllUserSecurities(userId);
        } catch (DAOException e) {
            LOGGER.error("getAllUserSecurities error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Security> getAllPortfolioSecurities(int portfolioId) throws ServiceException {
        try {
            return getSecurityDAO().getAllPortfolioSecurities(portfolioId);
        } catch (DAOException e) {
            LOGGER.error("getAllPortfolioSecurities error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Transaction> getAllTransactions() throws ServiceException {
        try {
            return getSecurityDAO().getAllTransactions();
        } catch (DAOException e) {
            LOGGER.error("getAllTransactions error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Transaction> getAllUserTransactions(int userId) throws ServiceException {
        try {
            return getSecurityDAO().getAllUserTransactions(userId);
        } catch (DAOException e) {
            LOGGER.error("getAllUserTransactions error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Transaction> getAllPortfolioTransactions(int portfolioId) throws ServiceException {
        try {
            return getSecurityDAO().getAllPortfolioTransactions(portfolioId);
        } catch (DAOException e) {
            LOGGER.error("getAllPortfolioTransactions error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public Security getSecurity(String symbol) throws ServiceException {
        try {
            return getSecurityDAO().getSecurity(symbol);
        } catch (DAOException e) {
            LOGGER.error("getSecurity error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public List<SecurityPrice> getSecurityPrices(String symbol) throws ServiceException {
        try {
            return getSecurityDAO().getSecurityPrices(symbol);
        } catch (DAOException e) {
            LOGGER.error("getSecurityPrices error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public Transaction getTransaction(int id) throws ServiceException {
        try {
            return getSecurityDAO().getTransaction(id);
        } catch (DAOException e) {
            LOGGER.error("getTransaction error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public void saveSecurity(Security security) throws ServiceException {
        try {
            getSecurityDAO().saveSecurity(security);
        } catch (DAOException e) {
            LOGGER.error("saveSecurity error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public void saveTransaction(Transaction transaction) throws ServiceException {
        try {
            getSecurityDAO().saveTransaction(transaction);
        } catch (DAOException e) {
            LOGGER.error("saveTransaction error: " + e.getMessage());
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
            LOGGER.error("updateTransaction error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public void removeSecurity(String symbol) throws ServiceException {
        try {
            getSecurityDAO().removeSecurity(symbol);
        } catch (DAOException e) {
            LOGGER.error("removeSecurity error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public void removeSecurityFromPortfolio(int portfolioId, String symbol) throws ServiceException {
        try {
            getSecurityDAO().removeSecurityFromPortfolio(portfolioId, symbol);
        } catch (DAOException e) {
            LOGGER.error("removeSecurityFromPortfolio error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public void removeTransaction(int id) throws ServiceException {
        try {
            getSecurityDAO().removeTransaction(id);
        } catch (DAOException e) {
            LOGGER.error("removeTransaction error: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    SecurityDAO getSecurityDAO() {
        return DAO_FACTORY.getSecurityDAO();
    }
}
