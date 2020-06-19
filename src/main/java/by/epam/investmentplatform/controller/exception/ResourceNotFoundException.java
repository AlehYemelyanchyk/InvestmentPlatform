package by.epam.investmentplatform.controller.exception;

import javax.servlet.http.HttpServletResponse;

public class ResourceNotFoundException extends AbstractApplicationException {

    public ResourceNotFoundException(String message) {
        super(message, HttpServletResponse.SC_NOT_FOUND);
    }
}
