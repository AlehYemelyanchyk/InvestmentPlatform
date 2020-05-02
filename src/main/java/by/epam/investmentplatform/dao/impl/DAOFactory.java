package by.epam.investmentplatform.dao.impl;

import by.epam.investmentplatform.dao.PortfolioDAO;
import by.epam.investmentplatform.dao.SecurityDAO;
import by.epam.investmentplatform.dao.UserDAO;

public final class DAOFactory {
    private static final DAOFactory INSTANCE = new DAOFactory();

    private UserDAO userDAO = new SqlUserDAOImpl();
    private PortfolioDAO portfolioDAO = new SqlPortfolioDAOImpl();
    private SecurityDAO securityDAO = new SqlSecurityDAOImpl();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return INSTANCE;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public PortfolioDAO getPortfolioDAO() {
        return portfolioDAO;
    }

    public SecurityDAO getSecurityDAO() {
        return securityDAO;
    }
}
