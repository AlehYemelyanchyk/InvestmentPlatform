package by.epam.investmentplatform.service.impl;

import by.epam.investmentplatform.dao.UserDAO;
import by.epam.investmentplatform.dao.exceptions.DAOException;
import by.epam.investmentplatform.entity.BalanceTransaction;
import by.epam.investmentplatform.entity.User;
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
public class DefaultUserServiceTest {

    private static Exception actualException = null;
    private static final DAOException EXPECTED_DAO_EXCEPTION = new DAOException("Test message", new Exception());
    private static final ServiceException EXPECTED_SERVICE_EXCEPTION = new ServiceException(new Exception());
    private static final int USER_ID = 1;
    private static final String USER_LOGIN = "slon";
    private static final String[] PARAMS = {"param1", "param2", "param3"};
    private User user;
    private User expectedUser;
    private BalanceTransaction balanceTransaction;

    @Spy
    private DefaultUserService userService;


    @Mock
    private UserDAO userDAO;

    @Before
    public void setUp() {
        Mockito.when(userService.getUserDAO()).thenReturn(userDAO);
        user = new User("1", "user", Integer.toString("1234qwer".hashCode()), "email@mail", "name", "surname", "5");
        expectedUser = new User("1", "user", Integer.toString("1234qwer".hashCode()), "email@mail", "name", "surname", "5");
        user = new User("1", "user", Integer.toString("1234qwer".hashCode()), "email@mail", "name", "surname", "5");
        balanceTransaction = new BalanceTransaction(1,3,20.2,LocalDate.of(2020, 12, 12));
        actualException = null;
    }

    @Test
    public void getAllUsersReturnListTest() throws DAOException {
        List<User> expectedList = new ArrayList<>();
        expectedList.add(user);

        Mockito.when(userDAO.getAllUsers()).thenReturn(expectedList);
        List<User> actualList = userDAO.getAllUsers();
        Assert.assertEquals(expectedList, actualList);
    }

    @Test
    public void getAllUsersReturnEmptyListTest() throws DAOException {
        List<User> actualList = userDAO.getAllUsers();
        Assert.assertTrue(actualList.isEmpty());
    }

    @Test
    public void getAllUsersDAOExceptionTest() throws DAOException {
        int userRole = 1;
        Mockito.when(userDAO.getAllUsers()).thenThrow(EXPECTED_DAO_EXCEPTION);
        try {
            userService.getAllUsers(userRole);
        } catch (ServiceException e) {
            Assert.assertEquals(EXPECTED_DAO_EXCEPTION, e.getCause());
        }
    }

    @Test
    public void getUserByIdReturnUserTest() throws DAOException, ServiceException {
        Mockito.when(userDAO.getUser(USER_ID)).thenReturn(expectedUser);
        User actualUser = userService.getUser(USER_ID);
        Assert.assertEquals(expectedUser, actualUser);
    }

    @Test
    public void getUserByIdReturnNullUserTest() throws ServiceException {
        int wrongId = 45;
        User actualUser = userService.getUser(wrongId);
        Assert.assertNull(actualUser);
    }

    @Test
    public void getUserByLoginDAOExceptionTest() throws DAOException {
        Mockito.when(userDAO.getUser(USER_LOGIN)).thenThrow(EXPECTED_DAO_EXCEPTION);
        try {
            userService.getUser(USER_LOGIN);
        } catch (ServiceException e) {
            Assert.assertEquals(EXPECTED_DAO_EXCEPTION, e.getCause());
        }
    }

    @Test
    public void getUserByLoginReturnUserTest() throws DAOException, ServiceException {
        Mockito.when(userDAO.getUser(USER_LOGIN)).thenReturn(expectedUser);
        User actualUser = userService.getUser(USER_LOGIN);
        Assert.assertEquals(expectedUser, actualUser);
    }

    @Test
    public void getUserByLoginReturnNullUserTest() throws ServiceException {
        String wrongLogin = "wrongLogin";
        User actualUser = userService.getUser(wrongLogin);
        Assert.assertNull(actualUser);
    }

    @Test
    public void getUserByIdDAOExceptionTest() throws DAOException {
        Mockito.when(userDAO.getUser(USER_ID)).thenThrow(EXPECTED_DAO_EXCEPTION);
        try {
            userService.getUser(USER_ID);
        } catch (ServiceException e) {
            Assert.assertEquals(EXPECTED_DAO_EXCEPTION, e.getCause());
        }
    }

    @Test
    public void signUpInvocationTest() throws ServiceException, DAOException {
        userService.signUp(user);
        Mockito.verify(userDAO).saveUser(user);
    }

    @Test
    public void signUpWrongUserTest() throws DAOException {
        user = null;

        Mockito.doThrow(EXPECTED_SERVICE_EXCEPTION).when(userDAO).saveUser(user);
        try {
            userService.signUp(user);
        } catch (ServiceException e) {
            actualException = e;
        } finally {
            Assert.assertNotNull(actualException);
            Assert.assertEquals(EXPECTED_SERVICE_EXCEPTION.getClass(), actualException.getClass());
        }
    }

    @Test
    public void signUpWrongLoginTest() {
        user.setLogin("");
        try {
            userService.signUp(user);
        } catch (ServiceException e) {
            actualException = e;
        } finally {
            Assert.assertNotNull(actualException);
            Assert.assertEquals(EXPECTED_SERVICE_EXCEPTION.getClass(), actualException.getClass());
        }
    }

    @Test
    public void signUpWrongPasswordTest() {
        user.setPassword("wrong password");
        try {
            userService.signUp(user);
        } catch (ServiceException e) {
            actualException = e;
        } finally {
            Assert.assertNotNull(actualException);
            Assert.assertEquals(EXPECTED_SERVICE_EXCEPTION.getClass(), actualException.getClass());
        }
    }

    @Test
    public void signUpWrongEmailTest() {
        user.setEmail("wrong email");
        try {
            userService.signUp(user);
        } catch (ServiceException e) {
            actualException = e;
        } finally {
            Assert.assertNotNull(actualException);
            Assert.assertEquals(EXPECTED_SERVICE_EXCEPTION.getClass(), actualException.getClass());
        }
    }

    @Test
    public void singUpDAOExceptionTest() throws DAOException {
        Mockito.doThrow(EXPECTED_DAO_EXCEPTION).when(userDAO).saveUser(user);
        try {
            userService.signUp(user);
        } catch (ServiceException e) {
            actualException = e;
        } finally {
            Assert.assertNotNull(actualException);
            Assert.assertEquals(EXPECTED_DAO_EXCEPTION, actualException.getCause());
        }
    }

    @Test
    public void logInReturnUserTest() throws DAOException, ServiceException {
        String login = "login";
        String password = "1234qwer";
        Mockito.when(userDAO.getUser(login)).thenReturn(expectedUser);
        User actualUser = userService.logIn(login, password);
        Assert.assertEquals(expectedUser, actualUser);
    }

    @Test
    public void logInDAOExceptionTest() throws DAOException {
        String login = "login";
        String password = "1234qwer";
        Mockito.doThrow(EXPECTED_DAO_EXCEPTION).when(userDAO).getUser(login);
        try {
            userService.logIn(login, password);
        } catch (ServiceException e) {
            actualException = e;
        } finally {
            Assert.assertNotNull(actualException);
            Assert.assertEquals(EXPECTED_DAO_EXCEPTION, actualException.getCause());
        }
    }

    @Test
    public void logInWrongLoginTest() {
        String login = "";
        String password = "1234qwer";
        try {
            userService.logIn(login, password);
        } catch (ServiceException e) {
            actualException = e;
        } finally {
            Assert.assertNotNull(actualException);
            Assert.assertEquals(EXPECTED_SERVICE_EXCEPTION.getClass(), actualException.getClass());
        }
    }

    @Test
    public void logInWrongPasswordTest() {
        String login = "login";
        String password = "wrong password";
        try {
            userService.logIn(login, password);
        } catch (ServiceException e) {
            actualException = e;
        } finally {
            Assert.assertNotNull(actualException);
            Assert.assertEquals(EXPECTED_SERVICE_EXCEPTION.getClass(), actualException.getClass());
        }
    }

    @Test
    public void updateUserInvocationTest() throws ServiceException, DAOException {
        userService.updateUser(user, PARAMS);
        Mockito.verify(userDAO).updateUser(user, PARAMS);
    }

    @Test
    public void updateUserDAOExceptionTest() throws DAOException {
        Mockito.doThrow(EXPECTED_DAO_EXCEPTION).when(userDAO).updateUser(user, PARAMS);
        try {
            userService.updateUser(user, PARAMS);
        } catch (ServiceException e) {
            actualException = e;
        } finally {
            Assert.assertNotNull(actualException);
            Assert.assertEquals(EXPECTED_DAO_EXCEPTION, actualException.getCause());
        }
    }

    @Test
    public void updateUserWrongUserTest() {
        try {
            userService.updateUser(null, PARAMS);
        } catch (ServiceException e) {
            actualException = e;
        } finally {
            Assert.assertNotNull(actualException);
            Assert.assertEquals(EXPECTED_SERVICE_EXCEPTION.getClass(), actualException.getClass());
        }
    }

    @Test
    public void updateUserWrongLoginTest() {
        user.setLogin("");
        try {
            userService.updateUser(user, PARAMS);
        } catch (ServiceException e) {
            actualException = e;
        } finally {
            Assert.assertNotNull(actualException);
            Assert.assertEquals(EXPECTED_SERVICE_EXCEPTION.getClass(), actualException.getClass());
        }
    }

    @Test
    public void updateUserWrongPasswordTest() {
        user.setPassword("wrong password");
        try {
            userService.updateUser(user, PARAMS);
        } catch (ServiceException e) {
            actualException = e;
        } finally {
            Assert.assertNotNull(actualException);
            Assert.assertEquals(EXPECTED_SERVICE_EXCEPTION.getClass(), actualException.getClass());
        }
    }

    @Test
    public void deleteUserInvocationTest() throws ServiceException, DAOException {
        userService.deleteUser(user);
        Mockito.verify(userDAO).deleteUser(user);
    }

    @Test
    public void deleteUserDAOExceptionTest() throws DAOException {
        Mockito.doThrow(EXPECTED_DAO_EXCEPTION).when(userDAO).deleteUser(user);
        try {
            userService.deleteUser(user);
        } catch (ServiceException e) {
            actualException = e;
        } finally {
            Assert.assertNotNull(actualException);
            Assert.assertEquals(EXPECTED_DAO_EXCEPTION, actualException.getCause());
        }
    }

    @Test
    public void deleteUserWrongUserTest() {
        try {
            userService.deleteUser(null);
        } catch (ServiceException e) {
            actualException = e;
        } finally {
            Assert.assertNotNull(actualException);
            Assert.assertEquals(EXPECTED_SERVICE_EXCEPTION.getClass(), actualException.getClass());
        }
    }

    @Test
    public void deleteUserWrongLoginTest() {
        user.setLogin("");
        try {
            userService.updateUser(user, PARAMS);
        } catch (ServiceException e) {
            actualException = e;
        } finally {
            Assert.assertNotNull(actualException);
            Assert.assertEquals(EXPECTED_SERVICE_EXCEPTION.getClass(), actualException.getClass());
        }
    }

    @Test
    public void getUserBalanceTransactionsReturnListTest() throws DAOException, ServiceException {
        List<BalanceTransaction> expectedList = new ArrayList<>();
        expectedList.add(balanceTransaction);

        Mockito.when(userDAO.getUserBalanceTransactions(USER_ID)).thenReturn(expectedList);
        List<BalanceTransaction> actualList = userService.getUserBalanceTransactions(USER_ID);
        Assert.assertEquals(expectedList, actualList);
    }

    @Test
    public void getUserBalanceTransactionsReturnEmptyListTest() throws DAOException {
        List<BalanceTransaction> actualList = userDAO.getUserBalanceTransactions(USER_ID);
        Assert.assertTrue(actualList.isEmpty());
    }

    @Test
    public void getUserBalanceTransactionsDAOExceptionTest() throws DAOException {
        Mockito.doThrow(EXPECTED_DAO_EXCEPTION).when(userDAO).getUserBalanceTransactions(USER_ID);
        try {
            userService.getUserBalanceTransactions(USER_ID);
        } catch (ServiceException e) {
            actualException = e;
        } finally {
            Assert.assertNotNull(actualException);
            Assert.assertEquals(EXPECTED_DAO_EXCEPTION, actualException.getCause());
        }
    }

    @Test
    public void getAllCountriesReturnListTest() throws DAOException, ServiceException {
        List<String> expectedList = new ArrayList<>();
        expectedList.add("Country");

        Mockito.when(userDAO.getAllCountries()).thenReturn(expectedList);
        List<String> actualList = userService.getAllCountries();
        Assert.assertEquals(expectedList, actualList);
    }

    @Test
    public void getAllCountriesDAOExceptionTest() throws DAOException {
        Mockito.doThrow(EXPECTED_DAO_EXCEPTION).when(userDAO).getAllCountries();
        try {
            userService.getAllCountries();
        } catch (ServiceException e) {
            actualException = e;
        } finally {
            Assert.assertNotNull(actualException);
            Assert.assertEquals(EXPECTED_DAO_EXCEPTION, actualException.getCause());
        }
    }
}