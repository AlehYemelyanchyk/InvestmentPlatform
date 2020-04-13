package by.epam.investmentplatform.dao.factory;

import by.epam.investmentplatform.dao.PortfolioDAO;
import by.epam.investmentplatform.dao.UserDAO;
import by.epam.investmentplatform.dao.impl.SqlPortfolioDAOImpl;
import by.epam.investmentplatform.dao.impl.SqlUserDAOImpl;

public final class DAOFactory {
    private static final DAOFactory INSTANCE = new DAOFactory();

    private UserDAO userDAO = new SqlUserDAOImpl();
    private PortfolioDAO portfolioDAO = new SqlPortfolioDAOImpl();

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
}
