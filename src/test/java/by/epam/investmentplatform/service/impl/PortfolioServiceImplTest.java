package by.epam.investmentplatform.service.impl;

import by.epam.investmentplatform.dao.PortfolioDAO;
import by.epam.investmentplatform.dao.exceptions.DAOException;
import by.epam.investmentplatform.entity.Portfolio;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class PortfolioServiceImplTest {

    private static final int USER_ID = 1;
    private static final String PORTFOLIO_NAME = "Test portfolio";
    private static final int PORTFOLIO_ID = 1;
    private static final Portfolio PORTFOLIO_NEW = new Portfolio(USER_ID, PORTFOLIO_NAME);
    private static final DAOException EXCEPTION = new DAOException("Test message", new Exception());

    @Spy
    private PortfolioServiceImpl portfolioService;

    @Mock
    private PortfolioDAO portfolioDAO;

    @Before
    public void setUp() {
        Mockito.when(portfolioService.getPortfolioDAO()).thenReturn(portfolioDAO);
    }

    @Test
    public void getAllUserPortfoliosReturnCollectionTest() {
        List<Portfolio> expectedPortfolios = new ArrayList<>();
        expectedPortfolios.add(new Portfolio(USER_ID, PORTFOLIO_NAME));

        Mockito.when(portfolioDAO.getAllUserPortfolios(USER_ID)).thenReturn(expectedPortfolios);
        List<Portfolio> actualPortfolios = portfolioService.getAllUserPortfolios(USER_ID);
        Assert.assertEquals(expectedPortfolios, actualPortfolios);
    }

    @Test
    public void getAllUserPortfoliosDAOExceptionTest() {
        Mockito.when(portfolioDAO.getAllUserPortfolios(USER_ID)).thenThrow(EXCEPTION);
        try {
            portfolioService.getAllUserPortfolios(USER_ID);
        } catch (ServiceException e) {
            Assert.assertEquals(EXCEPTION, e.getCause());
        }
    }

    @Test
    public void getPortfolioReturnPortfolioTest() {
        Mockito.when(portfolioDAO.getPortfolio(PORTFOLIO_ID)).thenReturn(PORTFOLIO_NEW);
        Portfolio actualPortfolio = portfolioService.getPortfolio(PORTFOLIO_ID);
        Assert.assertEquals(PORTFOLIO_NEW, actualPortfolio);
    }

    @Test
    public void getPortfolioDAOExceptionTest() {
        Mockito.when(portfolioDAO.getPortfolio(PORTFOLIO_ID)).thenThrow(EXCEPTION);
        try {
            portfolioService.getPortfolio(PORTFOLIO_ID);
        } catch (ServiceException e) {
            Assert.assertEquals(EXCEPTION.getClass(), e.getCause().getClass());
        }
    }

    @Test
    public void getPortfolioIndexOutOfBoundsExceptionTest() {
        RuntimeException testException = new IndexOutOfBoundsException("Test message");

        try {
            portfolioService.getPortfolio(PORTFOLIO_ID);
        } catch (ServiceException e) {
            Assert.assertEquals(testException.getClass(), e.getCause().getCause().getClass());
        }
    }

    @Test
    public void addPortfolioInvocationTest() {
        portfolioService.addPortfolio(PORTFOLIO_NEW);
        Mockito.verify(portfolioDAO).savePortfolio(PORTFOLIO_NEW);
    }

    @Test
    public void addPortfolioDAOExceptionTest() {
        Mockito.doThrow(EXCEPTION).when(portfolioDAO).savePortfolio(PORTFOLIO_NEW);
        try {
            portfolioService.addPortfolio(PORTFOLIO_NEW);
        } catch (ServiceException e) {
            Assert.assertEquals(EXCEPTION, e.getCause());
        }
    }

    @Test
    public void updatePortfolioInvocationTest() {
        String [] parameters = {"a", "b", "c"};

        portfolioService.updatePortfolio(PORTFOLIO_NEW, parameters);
        Mockito.verify(portfolioDAO).updatePortfolio(PORTFOLIO_NEW, parameters);
    }

    @Test
    public void updatePortfolioDAOExceptionTest() {
        String [] parameters = {"a", "b", "c"};

        Mockito.doThrow(EXCEPTION).when(portfolioDAO).updatePortfolio(PORTFOLIO_NEW, parameters);
        try {
            portfolioService.updatePortfolio(PORTFOLIO_NEW, parameters);
        } catch (ServiceException e) {
            Assert.assertEquals(EXCEPTION, e.getCause());
        }
    }

    @Test
    public void removePortfolioInvocationTest() {
        portfolioService.removePortfolio(PORTFOLIO_ID);
        Mockito.verify(portfolioDAO).removePortfolio(PORTFOLIO_ID);
    }

    @Test
    public void removePortfolioDAOExceptionTest() {
        Mockito.doThrow(EXCEPTION).when(portfolioDAO).removePortfolio(PORTFOLIO_ID);
        try {
            portfolioService.removePortfolio(PORTFOLIO_ID);
        } catch (ServiceException e) {
            Assert.assertEquals(EXCEPTION, e.getCause());
        }
    }
}