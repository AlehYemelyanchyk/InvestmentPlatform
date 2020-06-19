package by.epam.investmentplatform.dao.exceptions;

public class DAOException extends Exception {
    public DAOException(Throwable cause) {
        super(cause);
    }

    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }
}
