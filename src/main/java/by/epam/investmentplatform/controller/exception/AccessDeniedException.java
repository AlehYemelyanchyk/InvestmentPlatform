package by.epam.investmentplatform.controller.exception;

import javax.servlet.http.HttpServletResponse;

public class AccessDeniedException extends AbstractApplicationException {
    private static final long serialVersionUID = -933433158289244575L;

    public AccessDeniedException(String message) {
        super(message, HttpServletResponse.SC_FORBIDDEN);
    }
}
