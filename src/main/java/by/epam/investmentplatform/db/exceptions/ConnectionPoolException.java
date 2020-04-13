package by.epam.investmentplatform.db.exceptions;

public class ConnectionPoolException extends RuntimeException{
    private static final long serialVersionUID = -7629971325690049598L;

    public ConnectionPoolException(Throwable cause) {
        super(cause);
    }
}
