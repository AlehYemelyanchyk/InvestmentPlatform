package by.epam.investmentplatform.controller.exception;

import javax.servlet.http.HttpServletResponse;

public class AccessDeniedException extends AbstractApplicationException {

    public AccessDeniedException(String message) {
        super(message, HttpServletResponse.SC_FORBIDDEN);
    }
}
