package by.epam.investmentplatform.controller.exception;

import javax.servlet.http.HttpServletResponse;

public class ValidationException extends AbstractApplicationException {

    public ValidationException(String message) {
        super(message, HttpServletResponse.SC_BAD_REQUEST);
    }
}
