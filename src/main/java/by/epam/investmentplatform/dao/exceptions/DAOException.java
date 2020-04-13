package by.epam.investmentplatform.dao.exceptions;

public class DAOException extends RuntimeException {
    public DAOException(Throwable cause) {
        super(cause);
    }

    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }
}
