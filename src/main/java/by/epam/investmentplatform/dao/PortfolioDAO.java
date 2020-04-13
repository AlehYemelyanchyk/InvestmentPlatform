package by.epam.investmentplatform.dao;

import by.epam.investmentplatform.dao.exceptions.DAOException;
import by.epam.investmentplatform.entity.Portfolio;

import java.util.List;

public interface PortfolioDAO {

    List<Portfolio> getAllUserPortfolios(int UserId) throws DAOException;

    Portfolio getPortfolio(int portfolioId) throws DAOException;

    void savePortfolio(Portfolio portfolio) throws DAOException;

    void updatePortfolio(Portfolio portfolio, String[] params) throws DAOException;

    void removePortfolio(int portfolioId) throws DAOException;

}
