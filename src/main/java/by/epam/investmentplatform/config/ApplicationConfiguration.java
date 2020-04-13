package by.epam.investmentplatform.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ApplicationConfiguration {
    private static final ApplicationConfiguration INSTANCE = new ApplicationConfiguration();
    private static final Logger LOGGER = LogManager.getLogger(ApplicationConfiguration.class);

    private String dbUrl;
    private String dbUser;
    private String dbPassword;
    private int initPoolSize;
    private int maxPoolSize;
    private int poolIncreaseStep;
    private int maxWaitTime;

    private ApplicationConfiguration() {
        initProperties();
    }

    public static ApplicationConfiguration getInstance() {
        return INSTANCE;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public String getDbUser() {
        return dbUser;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public int getInitPoolSize() {
        return initPoolSize;
    }

    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    @Override
    public String toString() {
        return getClass().getName() +
                "dbUrl='" + dbUrl + '\'' +
                ", dbUser='" + dbUser + '\'' +
                ", dbPassword='" + dbPassword + '\'' +
                ", initPoolSize=" + initPoolSize +
                '}';
    }

    private void initProperties() {
        try (InputStream inputStream = new FileInputStream("C:/Java/_workspace/_projects/InvestmentPlatform/src/main/resources/application.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);
            dbUrl = properties.getProperty("dbUrl");
            dbUser = properties.getProperty("dbUser");
            dbPassword = properties.getProperty("dbPassword");
            initPoolSize = Integer.parseInt(properties.getProperty("initPoolSize"));
            maxPoolSize = Integer.parseInt(properties.getProperty("maxPoolSize"));
            poolIncreaseStep = Integer.parseInt(properties.getProperty("poolIncreaseStep"));
            maxWaitTime = Integer.parseInt(properties.getProperty("maxWaitTime"));
        } catch (IOException e) {
            LOGGER.error("Properties has not been loaded: " + e.getMessage());
            throw new Error("Properties has not been loaded", e);
        }
    }
}
