package by.epam.investmentplatform.controller.exception;

import javax.servlet.http.HttpServletResponse;

public class ResourceNotFoundException extends AbstractApplicationException {
    private static final long serialVersionUID = -5057067288864711563L;

    public ResourceNotFoundException(String message) {
        super(message, HttpServletResponse.SC_NOT_FOUND);
    }
}
