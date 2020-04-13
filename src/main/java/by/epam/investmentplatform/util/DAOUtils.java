package by.epam.investmentplatform.util;

import by.epam.investmentplatform.entity.Portfolio;
import by.epam.investmentplatform.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class DAOUtils {

    public static List<User> usersResultSetHandler(ResultSet resultSet) throws SQLException {
        List<User> users = new ArrayList<>();
        while (resultSet.next()) {
            User tempUser = new User(
                    resultSet.getInt("id"),
                    resultSet.getString("role"),
                    resultSet.getString("login"),
                    resultSet.getString("password"),
                    resultSet.getString("email"),
                    resultSet.getString("name"),
                    resultSet.getString("surname"),
                    resultSet.getString("country"));
            users.add(tempUser);
        }
        return users;
    }

    public static List<Portfolio> portfoliosResultSetHandler(ResultSet resultSet) throws SQLException {
        List<Portfolio> portfolios = new ArrayList<>();
        while (resultSet.next()) {
            Portfolio tempPortfolio = new Portfolio(
                    resultSet.getInt("id"),
                    resultSet.getInt("user_id"),
                    resultSet.getString("name"));
            portfolios.add(tempPortfolio);
        }
        return portfolios;
    }

    public static List<String> stringsResultSetHandler(ResultSet resultSet, String column) throws SQLException {
        List<String> strings = new ArrayList<>();
        while (resultSet.next()) {
            String value = resultSet.getString(column);
            strings.add(value);
        }
        return strings;
    }

    public static void closeResources(Connection connection, PreparedStatement statement, ResultSet resultSet)
            throws SQLException {
        if (Objects.nonNull(resultSet)) {
            resultSet.close();
            statement.close();
            connection.close();
        }
    }

    public static void closeResources(Connection connection, PreparedStatement statement)
            throws SQLException {
        if (Objects.nonNull(statement)) {
            statement.close();
            connection.close();
        }
    }
}
