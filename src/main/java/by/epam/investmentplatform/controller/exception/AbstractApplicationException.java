package by.epam.investmentplatform.controller.exception;

public class AbstractApplicationException extends RuntimeException {
    private static final long serialVersionUID = -202417051159971577L;
    private final int code;

    public AbstractApplicationException(String message, int code) {
        super(message);
        this.code = code;
    }

    public AbstractApplicationException(Throwable cause, int code) {
        super(cause);
        this.code = code;
    }

    public AbstractApplicationException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
