package by.epam.investmentplatform.dao.impl;

import by.epam.investmentplatform.dao.PortfolioDAO;
import by.epam.investmentplatform.dao.SecurityDAO;
import by.epam.investmentplatform.dao.UserDAO;

public final class DAOFactory {
    private static final DAOFactory INSTANCE = new DAOFactory();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return INSTANCE;
    }

    public UserDAO getUserDAO() {
        return new SqlUserDAO();
    }

    public PortfolioDAO getPortfolioDAO() {
        return new SqlPortfolioDAO();
    }

    public SecurityDAO getSecurityDAO() {
        return new SqlSecurityDAO();
    }
}
