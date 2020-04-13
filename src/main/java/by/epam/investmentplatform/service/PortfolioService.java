package by.epam.investmentplatform.service;

import by.epam.investmentplatform.entity.Portfolio;
import by.epam.investmentplatform.service.exceptions.ServiceException;

import java.util.List;

public interface PortfolioService {

    List<Portfolio> getAllUserPortfolios(int userId) throws ServiceException;

    Portfolio getPortfolio(int portfolioId) throws ServiceException;

    void addPortfolio(Portfolio portfolio) throws ServiceException;

    void updatePortfolio(Portfolio portfolio, String[] params) throws ServiceException;

    void removePortfolio(int portfolioId) throws ServiceException;
}
