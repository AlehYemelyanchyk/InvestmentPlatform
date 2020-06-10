package by.epam.investmentplatform.service.impl;

import by.epam.investmentplatform.dao.SecurityDAO;
import by.epam.investmentplatform.dao.exceptions.DAOException;
import by.epam.investmentplatform.entity.Security;
import by.epam.investmentplatform.entity.Transaction;
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
import java.util.Date;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class DefaultSecurityServiceTest {

    private static final Security SECURITY = new Security("AAA", "Triple A", "2", 5.55, 2.34, 0.18, "1");
    private static final Transaction TRANSACTION = new Transaction(1, "AAA", 1, 20, 10.5, new Date(12, 12, 2020));
    private static final Transaction EXPECTED_TRANSACTION = new Transaction(1, "AAA", 1, 20, 10.5, new Date(12, 12, 2020));
    private static final DAOException EXPECTED_EXCEPTION = new DAOException("Test message", new Exception());
    private static final String SECURITY_SYMBOL = "AAA";
    private static final int USER_ID = 1;
    private static final int TRANSACTION_ID = 1;
    private static final int PORTFOLIO_ID = 1;

    @Spy
    private DefaultSecurityService securityService;

    @Mock
    private SecurityDAO securityDAO;

    @Before
    public void setUp() {
        Mockito.when(securityService.getSecurityDAO()).thenReturn(securityDAO);
    }

    @Test
    public void getAllSecuritiesReturnCollectionTest() {
        List<Security> expectedList = new ArrayList<>();
        expectedList.add(SECURITY);

        Mockito.when(securityDAO.getAllSecurities()).thenReturn(expectedList);
        List<Security> actualList = securityService.getAllSecurities();
        Assert.assertEquals(expectedList, actualList);
    }

    @Test
    public void getAllSecuritiesDAOExceptionTest() {
        Mockito.when(securityDAO.getAllSecurities()).thenThrow(EXPECTED_EXCEPTION);
        try {
            securityService.getAllSecurities();
        } catch (ServiceException e) {
            Assert.assertEquals(EXPECTED_EXCEPTION, e.getCause());
        }
    }

    @Test
    public void getAllUserSecuritiesReturnCollectionTest() {
        List<Security> expectedList = new ArrayList<>();
        expectedList.add(SECURITY);

        Mockito.when(securityDAO.getAllUserSecurities(USER_ID)).thenReturn(expectedList);
        List<Security> actualList = securityService.getAllUserSecurities(USER_ID);
        Assert.assertEquals(expectedList, actualList);
    }

    @Test
    public void getAllUserSecuritiesDAOExceptionTest() {
        Mockito.when(securityDAO.getAllUserSecurities(USER_ID)).thenThrow(EXPECTED_EXCEPTION);
        try {
            securityService.getAllUserSecurities(USER_ID);
        } catch (ServiceException e) {
            Assert.assertEquals(EXPECTED_EXCEPTION, e.getCause());
        }
    }

    @Test
    public void getAllPortfolioSecuritiesReturnCollectionTest() {
        List<Security> expectedList = new ArrayList<>();
        expectedList.add(SECURITY);

        Mockito.when(securityDAO.getAllPortfolioSecurities(PORTFOLIO_ID)).thenReturn(expectedList);
        List<Security> actualList = securityService.getAllPortfolioSecurities(PORTFOLIO_ID);
        Assert.assertEquals(expectedList, actualList);
    }

    @Test
    public void getAllPortfolioSecuritiesDAOExceptionTest() {
        Mockito.when(securityDAO.getAllPortfolioSecurities(PORTFOLIO_ID)).thenThrow(EXPECTED_EXCEPTION);
        try {
            securityService.getAllPortfolioSecurities(PORTFOLIO_ID);
        } catch (ServiceException e) {
            Assert.assertEquals(EXPECTED_EXCEPTION, e.getCause());
        }
    }

    @Test
    public void getAllTransactionsReturnCollectionTest() {
        List<Transaction> expectedList = new ArrayList<>();
        expectedList.add(TRANSACTION);

        Mockito.when(securityDAO.getAllTransactions()).thenReturn(expectedList);
        List<Transaction> actualList = securityService.getAllTransactions();
        Assert.assertEquals(expectedList, actualList);
    }

    @Test
    public void getAllTransactionsDAOExceptionTest() {
        Mockito.when(securityDAO.getAllTransactions()).thenThrow(EXPECTED_EXCEPTION);
        try {
            securityService.getAllTransactions();
        } catch (ServiceException e) {
            Assert.assertEquals(EXPECTED_EXCEPTION, e.getCause());
        }
    }

    @Test
    public void getAllPortfolioTransactionsReturnCollectionTest() {
        List<Transaction> expectedList = new ArrayList<>();
        expectedList.add(TRANSACTION);

        Mockito.when(securityDAO.getAllPortfolioTransactions(PORTFOLIO_ID)).thenReturn(expectedList);
        List<Transaction> actualList = securityService.getAllPortfolioTransactions(PORTFOLIO_ID);
        Assert.assertEquals(expectedList, actualList);
    }


    @Test
    public void getAllPortfolioTransactionsDAOExceptionTest() {
        Mockito.when(securityDAO.getAllPortfolioTransactions(PORTFOLIO_ID)).thenThrow(EXPECTED_EXCEPTION);
        try {
            securityService.getAllPortfolioTransactions(PORTFOLIO_ID);
        } catch (ServiceException e) {
            Assert.assertEquals(EXPECTED_EXCEPTION, e.getCause());
        }
    }

    @Test
    public void getAllUserTransactionsReturnCollectionList() {
        List<Transaction> expectedList = new ArrayList<>();
        expectedList.add(TRANSACTION);

        Mockito.when(securityDAO.getAllUserTransactions(USER_ID)).thenReturn(expectedList);
        List<Transaction> actualList = securityService.getAllUserTransactions(USER_ID);
        Assert.assertEquals(expectedList, actualList);
    }

    @Test
    public void getAllUserTransactionsDAOExceptionTest() {
        Mockito.when(securityDAO.getAllUserTransactions(USER_ID)).thenThrow(EXPECTED_EXCEPTION);
        try {
            securityService.getAllUserTransactions(USER_ID);
        } catch (ServiceException e) {
            Assert.assertEquals(EXPECTED_EXCEPTION, e.getCause());
        }
    }

    @Test
    public void getSecurity() {
    }

    @Test
    public void getTransactionReturnTransaction() {
        Mockito.when(securityDAO.getTransaction(TRANSACTION_ID)).thenReturn(EXPECTED_TRANSACTION);
        Transaction actualTransaction = securityService.getTransaction(TRANSACTION_ID);
        Assert.assertEquals(EXPECTED_TRANSACTION, actualTransaction);
    }

    @Test
    public void getPortfolioIndexOutOfBoundsExceptionTest() {
        RuntimeException testException = new IndexOutOfBoundsException("Test message");

        try {
            securityService.getTransaction(TRANSACTION_ID);
        } catch (ServiceException e) {
            Assert.assertEquals(testException.getClass(), e.getCause().getCause().getClass());
        }
    }

    @Test
    public void getTransactionDAOExceptionTest() {
        Mockito.when(securityDAO.getTransaction(TRANSACTION_ID)).thenThrow(EXPECTED_EXCEPTION);
        try {
            securityService.getTransaction(TRANSACTION_ID);
        } catch (ServiceException e) {
            Assert.assertEquals(EXPECTED_EXCEPTION, e.getCause());
        }
    }

    @Test
    public void saveSecurityInvocationTest() {
        securityService.saveSecurity(SECURITY);
        Mockito.verify(securityDAO).saveSecurity(SECURITY);
    }

    @Test
    public void saveSecurityDAOExceptionTest() {
        Mockito.doThrow(EXPECTED_EXCEPTION).when(securityDAO).saveSecurity(SECURITY);
        try {
            securityService.saveSecurity(SECURITY);
        } catch (ServiceException e) {
            Assert.assertEquals(EXPECTED_EXCEPTION, e.getCause());
        }
    }

    @Test
    public void saveTransactionInvocationTest() {
        securityService.saveTransaction(TRANSACTION);
        Mockito.verify(securityDAO).saveTransaction(TRANSACTION);
    }

    @Test
    public void saveTransactionDAOExceptionTest() {
        Mockito.doThrow(EXPECTED_EXCEPTION).when(securityDAO).saveTransaction(TRANSACTION);
        try {
            securityService.saveTransaction(TRANSACTION);
        } catch (ServiceException e) {
            Assert.assertEquals(EXPECTED_EXCEPTION, e.getCause());
        }
    }

    @Test
    public void removeSecurityInvocationTest() {
        String securitySymbol = "AAA";
        securityService.removeSecurity(securitySymbol);
        Mockito.verify(securityDAO).removeSecurity(securitySymbol);
    }

    @Test
    public void removeSecurityDAOExceptionTest() {
        Mockito.doThrow(EXPECTED_EXCEPTION).when(securityDAO).removeSecurity(SECURITY_SYMBOL);
        try {
            securityService.removeSecurity(SECURITY_SYMBOL);
        } catch (ServiceException e) {
            Assert.assertEquals(EXPECTED_EXCEPTION, e.getCause());
        }
    }

    @Test
    public void removeSecurityFromPortfolioInvocationTest() {
        securityService.removeSecurityFromPortfolio(PORTFOLIO_ID, SECURITY_SYMBOL);
        Mockito.verify(securityDAO).removeSecurityFromPortfolio(PORTFOLIO_ID, SECURITY_SYMBOL);
    }

    @Test
    public void removeSecurityFromPortfolioDAOExceptionTest() {
        Mockito.doThrow(EXPECTED_EXCEPTION).when(securityDAO).removeSecurityFromPortfolio(PORTFOLIO_ID, SECURITY_SYMBOL);
        try {
            securityService.removeSecurityFromPortfolio(PORTFOLIO_ID, SECURITY_SYMBOL);
        } catch (ServiceException e) {
            Assert.assertEquals(EXPECTED_EXCEPTION, e.getCause());
        }
    }

    @Test
    public void updateSecurity() {
    }

    @Test
    public void updateTransactionInvocationTest() {
        String[] parameters = {"a", "b", "c"};

        securityService.updateTransaction(TRANSACTION, parameters);
        Mockito.verify(securityDAO).updateTransaction(TRANSACTION, parameters);
    }

    @Test
    public void updateTransactionDAOExceptionTest() {
        String[] parameters = {"a", "b", "c"};

        Mockito.doThrow(EXPECTED_EXCEPTION).when(securityDAO).updateTransaction(TRANSACTION, parameters);
        try {
            securityService.updateTransaction(TRANSACTION, parameters);
        } catch (ServiceException e) {
            Assert.assertEquals(EXPECTED_EXCEPTION, e.getCause());
        }
    }

    @Test
    public void removeTransactionInvocationTest() {
        securityService.removeTransaction(TRANSACTION_ID);
        Mockito.verify(securityDAO).removeTransaction(TRANSACTION_ID);
    }

    @Test
    public void removeTransactionDAOExceptionTest() {
        Mockito.doThrow(EXPECTED_EXCEPTION).when(securityDAO).removeTransaction(TRANSACTION_ID);
        try {
            securityService.removeTransaction(TRANSACTION_ID);
        } catch (ServiceException e) {
            Assert.assertEquals(EXPECTED_EXCEPTION, e.getCause());
        }
    }
}