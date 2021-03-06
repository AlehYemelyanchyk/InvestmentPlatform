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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class DefaultSecurityServiceTest {

    private static final Security SECURITY = new Security("AAA", "Triple A", "2", 5.55, 2.34, 0.18, "1");
    private static final Transaction TRANSACTION = new Transaction(1, "AAA", 1, 20, 10.5, LocalDate.of(2020, 12, 12));
    private static final Transaction EXPECTED_TRANSACTION = new Transaction(1, "AAA", 1, 20, 10.5, LocalDate.of(20, 12, 12));
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
    public void getAllSecuritiesReturnCollectionTest() throws DAOException, ServiceException {
        List<Security> expectedList = new ArrayList<>();
        expectedList.add(SECURITY);

        Mockito.when(securityDAO.getAllSecurities()).thenReturn(expectedList);
        List<Security> actualList = securityService.getAllSecurities();
        Assert.assertEquals(expectedList, actualList);
    }

    @Test
    public void getAllSecuritiesDAOExceptionTest() throws DAOException {
        Mockito.when(securityDAO.getAllSecurities()).thenThrow(EXPECTED_EXCEPTION);
        try {
            securityService.getAllSecurities();
        } catch (ServiceException e) {
            Assert.assertEquals(EXPECTED_EXCEPTION, e.getCause());
        }
    }

    @Test
    public void getAllUserSecuritiesReturnCollectionTest() throws DAOException, ServiceException {
        List<Security> expectedList = new ArrayList<>();
        expectedList.add(SECURITY);

        Mockito.when(securityDAO.getAllUserSecurities(USER_ID)).thenReturn(expectedList);
        List<Security> actualList = securityService.getAllUserSecurities(USER_ID);
        Assert.assertEquals(expectedList, actualList);
    }

    @Test
    public void getAllUserSecuritiesDAOExceptionTest() throws DAOException {
        Mockito.when(securityDAO.getAllUserSecurities(USER_ID)).thenThrow(EXPECTED_EXCEPTION);
        try {
            securityService.getAllUserSecurities(USER_ID);
        } catch (ServiceException e) {
            Assert.assertEquals(EXPECTED_EXCEPTION, e.getCause());
        }
    }

    @Test
    public void getAllPortfolioSecuritiesReturnCollectionTest() throws DAOException, ServiceException {
        List<Security> expectedList = new ArrayList<>();
        expectedList.add(SECURITY);

        Mockito.when(securityDAO.getAllPortfolioSecurities(PORTFOLIO_ID)).thenReturn(expectedList);
        List<Security> actualList = securityService.getAllPortfolioSecurities(PORTFOLIO_ID);
        Assert.assertEquals(expectedList, actualList);
    }

    @Test
    public void getAllPortfolioSecuritiesDAOExceptionTest() throws DAOException {
        Mockito.when(securityDAO.getAllPortfolioSecurities(PORTFOLIO_ID)).thenThrow(EXPECTED_EXCEPTION);
        try {
            securityService.getAllPortfolioSecurities(PORTFOLIO_ID);
        } catch (ServiceException e) {
            Assert.assertEquals(EXPECTED_EXCEPTION, e.getCause());
        }
    }

    @Test
    public void getAllTransactionsReturnCollectionTest() throws DAOException, ServiceException {
        List<Transaction> expectedList = new ArrayList<>();
        expectedList.add(TRANSACTION);

        Mockito.when(securityDAO.getAllTransactions()).thenReturn(expectedList);
        List<Transaction> actualList = securityService.getAllTransactions();
        Assert.assertEquals(expectedList, actualList);
    }

    @Test
    public void getAllTransactionsDAOExceptionTest() throws DAOException {
        Mockito.when(securityDAO.getAllTransactions()).thenThrow(EXPECTED_EXCEPTION);
        try {
            securityService.getAllTransactions();
        } catch (ServiceException e) {
            Assert.assertEquals(EXPECTED_EXCEPTION, e.getCause());
        }
    }

    @Test
    public void getAllPortfolioTransactionsReturnCollectionTest() throws DAOException, ServiceException {
        List<Transaction> expectedList = new ArrayList<>();
        expectedList.add(TRANSACTION);

        Mockito.when(securityDAO.getAllPortfolioTransactions(PORTFOLIO_ID)).thenReturn(expectedList);
        List<Transaction> actualList = securityService.getAllPortfolioTransactions(PORTFOLIO_ID);
        Assert.assertEquals(expectedList, actualList);
    }


    @Test
    public void getAllPortfolioTransactionsDAOExceptionTest() throws DAOException {
        Mockito.when(securityDAO.getAllPortfolioTransactions(PORTFOLIO_ID)).thenThrow(EXPECTED_EXCEPTION);
        try {
            securityService.getAllPortfolioTransactions(PORTFOLIO_ID);
        } catch (ServiceException e) {
            Assert.assertEquals(EXPECTED_EXCEPTION, e.getCause());
        }
    }

    @Test
    public void getAllUserTransactionsReturnCollectionList() throws DAOException, ServiceException {
        List<Transaction> expectedList = new ArrayList<>();
        expectedList.add(TRANSACTION);

        Mockito.when(securityDAO.getAllUserTransactions(USER_ID)).thenReturn(expectedList);
        List<Transaction> actualList = securityService.getAllUserTransactions(USER_ID);
        Assert.assertEquals(expectedList, actualList);
    }

    @Test
    public void getAllUserTransactionsDAOExceptionTest() throws DAOException {
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
    public void getTransactionReturnTransaction() throws DAOException, ServiceException {
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
    public void getTransactionDAOExceptionTest() throws DAOException {
        Mockito.when(securityDAO.getTransaction(TRANSACTION_ID)).thenThrow(EXPECTED_EXCEPTION);
        try {
            securityService.getTransaction(TRANSACTION_ID);
        } catch (ServiceException e) {
            Assert.assertEquals(EXPECTED_EXCEPTION, e.getCause());
        }
    }

    @Test
    public void saveSecurityInvocationTest() throws ServiceException, DAOException {
        securityService.saveSecurity(SECURITY);
        Mockito.verify(securityDAO).saveSecurity(SECURITY);
    }

    @Test
    public void saveSecurityDAOExceptionTest() throws DAOException {
        Mockito.doThrow(EXPECTED_EXCEPTION).when(securityDAO).saveSecurity(SECURITY);
        try {
            securityService.saveSecurity(SECURITY);
        } catch (ServiceException e) {
            Assert.assertEquals(EXPECTED_EXCEPTION, e.getCause());
        }
    }

    @Test
    public void saveTransactionInvocationTest() throws ServiceException, DAOException {
        securityService.saveTransaction(TRANSACTION);
        Mockito.verify(securityDAO).saveTransaction(TRANSACTION);
    }

    @Test
    public void saveTransactionDAOExceptionTest() throws DAOException {
        Mockito.doThrow(EXPECTED_EXCEPTION).when(securityDAO).saveTransaction(TRANSACTION);
        try {
            securityService.saveTransaction(TRANSACTION);
        } catch (ServiceException e) {
            Assert.assertEquals(EXPECTED_EXCEPTION, e.getCause());
        }
    }

    @Test
    public void removeSecurityInvocationTest() throws ServiceException, DAOException {
        String securitySymbol = "AAA";
        securityService.removeSecurity(securitySymbol);
        Mockito.verify(securityDAO).removeSecurity(securitySymbol);
    }

    @Test
    public void removeSecurityDAOExceptionTest() throws DAOException {
        Mockito.doThrow(EXPECTED_EXCEPTION).when(securityDAO).removeSecurity(SECURITY_SYMBOL);
        try {
            securityService.removeSecurity(SECURITY_SYMBOL);
        } catch (ServiceException e) {
            Assert.assertEquals(EXPECTED_EXCEPTION, e.getCause());
        }
    }

    @Test
    public void removeSecurityFromPortfolioInvocationTest() throws ServiceException, DAOException {
        securityService.removeSecurityFromPortfolio(PORTFOLIO_ID, SECURITY_SYMBOL);
        Mockito.verify(securityDAO).removeSecurityFromPortfolio(PORTFOLIO_ID, SECURITY_SYMBOL);
    }

    @Test
    public void removeSecurityFromPortfolioDAOExceptionTest() throws DAOException {
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
    public void updateTransactionInvocationTest() throws ServiceException, DAOException {
        String[] parameters = {"a", "b", "c"};

        securityService.updateTransaction(TRANSACTION, parameters);
        Mockito.verify(securityDAO).updateTransaction(TRANSACTION, parameters);
    }

    @Test
    public void updateTransactionDAOExceptionTest() throws DAOException {
        String[] parameters = {"a", "b", "c"};

        Mockito.doThrow(EXPECTED_EXCEPTION).when(securityDAO).updateTransaction(TRANSACTION, parameters);
        try {
            securityService.updateTransaction(TRANSACTION, parameters);
        } catch (ServiceException e) {
            Assert.assertEquals(EXPECTED_EXCEPTION, e.getCause());
        }
    }

    @Test
    public void removeTransactionInvocationTest() throws ServiceException, DAOException {
        securityService.removeTransaction(TRANSACTION_ID);
        Mockito.verify(securityDAO).removeTransaction(TRANSACTION_ID);
    }

    @Test
    public void removeTransactionDAOExceptionTest() throws DAOException {
        Mockito.doThrow(EXPECTED_EXCEPTION).when(securityDAO).removeTransaction(TRANSACTION_ID);
        try {
            securityService.removeTransaction(TRANSACTION_ID);
        } catch (ServiceException e) {
            Assert.assertEquals(EXPECTED_EXCEPTION, e.getCause());
        }
    }
}