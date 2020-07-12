package by.epam.investmentplatform.util;

import by.epam.investmentplatform.entity.*;
import by.epam.investmentplatform.model.SecurityPrice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public final class DAOUtils {

    public static List<User> usersResultSetHandle(ResultSet resultSet) throws SQLException {
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
                    resultSet.getString("country"),
                    resultSet.getString("banned"),
                    resultSet.getString("transactionBanned"));
            users.add(tempUser);
        }
        return users;
    }

    public static List<Integer> bannedUsersResultSetHandle(ResultSet resultSet) throws SQLException {
        List<Integer> bannedUsers = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            bannedUsers.add(id);
        }
        return bannedUsers;
    }

    public static List<Portfolio> portfoliosResultSetHandle(ResultSet resultSet) throws SQLException {
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

    public static List<Security> securitiesResultSetHandle(ResultSet resultSet) throws SQLException {
        List<Security> securities = new ArrayList<>();
        while (resultSet.next()) {
            Security tempSecurity = new Security(
                    resultSet.getString("symbol"),
                    resultSet.getString("name"),
                    resultSet.getString("exchange"),
                    resultSet.getDouble("current_price"),
                    resultSet.getDouble("year_change_percents"),
                    resultSet.getDouble("dividends"),
                    resultSet.getString("security_type"),
                    resultSet.getString("stop_trade_date"));
            securities.add(tempSecurity);
        }
        return securities;
    }

    public static List<SecurityPrice> pricesResultSetHandle(ResultSet resultSet) throws SQLException {
        List<SecurityPrice> prices = new ArrayList<>();
        while (resultSet.next()) {
            SecurityPrice tempSecurity = new SecurityPrice(
                    resultSet.getDate("date"),
                    resultSet.getString("symbol"),
                    resultSet.getDouble("price"));
            prices.add(tempSecurity);
        }
        return prices;
    }

    public static Map<Integer, String> exchangesResultSetHandle(ResultSet resultSet) throws SQLException {
        Map<Integer, String> exchangesList = new HashMap<>();
        while (resultSet.next()) {
            exchangesList.put(
                    resultSet.getInt("id"),
                    resultSet.getString("name"));
        }
        return exchangesList;
    }

    public static Map<Integer, String> typesResultSetHandle(ResultSet resultSet) throws SQLException {
        Map<Integer, String> typesList = new HashMap<>();
        while (resultSet.next()) {
            typesList.put(
                    resultSet.getInt("id"),
                    resultSet.getString("type"));
        }
        return typesList;
    }

    public static List<Transaction> transactionsResultSetHandle(ResultSet resultSet) throws SQLException {
        List<Transaction> transactions = new ArrayList<>();
        while (resultSet.next()) {
            Transaction tempTransaction = new Transaction(
                    resultSet.getInt("id"),
                    resultSet.getInt("portfolio_id"),
                    resultSet.getString("security_symbol"),
                    resultSet.getInt("transaction_type"),
                    resultSet.getInt("amount"),
                    resultSet.getDouble("price"),
                    resultSet.getDate("date"));
            transactions.add(tempTransaction);
        }
        return transactions;
    }

    public static List<String> stringsResultSetHandle(ResultSet resultSet, String column) throws SQLException {
        List<String> strings = new ArrayList<>();
        while (resultSet.next()) {
            String value = resultSet.getString(column);
            strings.add(value);
        }
        return strings;
    }

    public static List<BalanceTransaction> balanceResultSetHandle(ResultSet resultSet) throws SQLException {
        List<BalanceTransaction> balanceTransactions = new ArrayList<>();
        while (resultSet.next()) {
            BalanceTransaction tempTransaction = new BalanceTransaction(
                    resultSet.getInt("id"),
                    resultSet.getInt("user_id"),
                    resultSet.getInt("type"),
                    resultSet.getDouble("amount"),
                    resultSet.getDate("date"));
            balanceTransactions.add(tempTransaction);
        }
        return balanceTransactions;
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
