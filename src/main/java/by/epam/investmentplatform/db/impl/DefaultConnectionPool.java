package by.epam.investmentplatform.db.impl;

import by.epam.investmentplatform.config.ApplicationConfiguration;
import by.epam.investmentplatform.db.ConnectionPool;
import by.epam.investmentplatform.db.exceptions.ConnectionPoolException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class DefaultConnectionPool implements ConnectionPool {

    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final Logger LOGGER = LogManager.getLogger();
    private static final DefaultConnectionPool instance = new DefaultConnectionPool();
    private final ApplicationConfiguration applicationConfiguration = ApplicationConfiguration.getInstance();
    private final int connectionsAmount = applicationConfiguration.getInitPoolSize();

    private BlockingQueue<Connection> availableConnections = new LinkedBlockingQueue<>(connectionsAmount);
    private BlockingQueue<Connection> takenConnections = new LinkedBlockingQueue<>(connectionsAmount);

    private DefaultConnectionPool() {
        getConnections();
    }

    private void getConnections() {
        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            LOGGER.error("JDBC Driver loading error: " + e.getMessage());
        }
        for (int i = 0; i < connectionsAmount; i++) {
            try {
                Connection connection = new DefaultConnectionPool$Proxy(DriverManager.getConnection(
                        applicationConfiguration.getDbUrl(),
                        applicationConfiguration.getDbUser(),
                        applicationConfiguration.getDbPassword()));
                connection.setAutoCommit(false);
                availableConnections.add(connection);
            } catch (SQLException e) {
                LOGGER.error("getConnection error: " + e);
            }
        }
    }

    @Override
    public Connection takeConnection() throws ConnectionPoolException {
        Connection connection;
        try {
            connection = availableConnections.take();
            takenConnections.put(connection);
        } catch (InterruptedException e) {
            LOGGER.error("takeConnection error: " + e);
            throw new ConnectionPoolException(e);
        }
        return connection;
    }

    @Override
    public boolean releaseConnection(Connection connection) throws ConnectionPoolException {
        try {
            takenConnections.remove(connection);
            availableConnections.put(connection);
        } catch (InterruptedException e) {
            LOGGER.error("releaseConnection error: " + e);
            throw new ConnectionPoolException(e);
        }
        return true;
    }

    public static DefaultConnectionPool getConnectionPoolInstance() {
        return instance;
    }
}
