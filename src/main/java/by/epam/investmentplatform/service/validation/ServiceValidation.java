package by.epam.investmentplatform.service.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ServiceValidation {
    private static final String PASSWORD_REGEX = "^(?=.*[A-Za-z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9.!#$%&'*+" +
            "/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:" +
            "\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";

    private ServiceValidation() {
        throw new UnsupportedOperationException();
    }

    public static boolean isLoginInvalid(String login) {
        return login == null || login.isEmpty();
    }

    public static boolean isPasswordInvalid(String password) {
        if (password == null) {
            return true;
        }
        Pattern pattern = Pattern.compile(PASSWORD_REGEX);
        Matcher matcher = pattern.matcher(password);
        return !matcher.matches();
    }

    public static boolean isEmailInvalid(String email) {
        if (email == null) {
            return true;
        }
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return !matcher.matches();
    }
}
