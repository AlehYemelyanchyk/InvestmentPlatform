package by.epam.investmentplatform.db;

import by.epam.investmentplatform.db.exceptions.ConnectionPoolException;

import java.sql.Connection;

public interface ConnectionPool {
    Connection takeConnection() throws ConnectionPoolException;

    boolean releaseConnection(Connection connection) throws ConnectionPoolException;
}
