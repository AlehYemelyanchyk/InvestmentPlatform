package by.epam.investmentplatform.controller.exception;

import javax.servlet.http.HttpServletResponse;

public class ValidationException extends AbstractApplicationException {
    private static final long serialVersionUID = 3778778070001751815L;

    public ValidationException(String message) {
        super(message, HttpServletResponse.SC_BAD_REQUEST);
    }
}
