package by.epam.investmentplatform.util;

import by.epam.investmentplatform.entity.User;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.service.validation.ServiceValidation;

public final class UserValidationUtils {

    private UserValidationUtils() {
        throw new UnsupportedOperationException();
    }

    public static void userValidation(User user) throws ServiceException {
        if (user == null) {
            throw new ServiceException("The information about the user is lost.");
        }
    }

    public static void loginValidation(String login) throws ServiceException {
        if (ServiceValidation.isLoginInvalid(login)) {
            throw new ServiceException("A login must contain at least 1 character.");
        }
    }

    public static void passwordValidation(String password) throws ServiceException {
        if (ServiceValidation.isPasswordInvalid(password)) {
            throw new ServiceException("A password must contain at least 1 alphabetical character " +
                    "and at least 1 numeric character. It also must be at least 8 characters long " +
                    "with no special symbols.");
        }
    }

    public static void emailValidation(String email) throws ServiceException {
        if (ServiceValidation.isEmailInvalid(email)) {
            throw new ServiceException("The e-mail address is not correct.");
        }
    }
}
