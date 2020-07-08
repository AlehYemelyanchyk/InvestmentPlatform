package by.epam.investmentplatform.controller.command;

import by.epam.investmentplatform.CommandsConstants;
import by.epam.investmentplatform.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {
    private static final CommandProvider INSTANCE = new CommandProvider();

    private final Map<String, Command> repository = new HashMap<>();
    private final String GET_METHOD = "GET";
    private final String POST_METHOD = "POST";

    private CommandProvider() {
        repository.put(CommandsConstants.ADD_PORTFOLIO_COMMAND + GET_METHOD, new AddPortfolioGetCommand());
        repository.put(CommandsConstants.ADD_PORTFOLIO_COMMAND + POST_METHOD, new AddPortfolioPostCommand());
        repository.put(CommandsConstants.ADD_SECURITY_ADMIN_COMMAND + GET_METHOD, new AddSecurityAdminGetCommand());
        repository.put(CommandsConstants.ADD_SECURITY_ADMIN_COMMAND + POST_METHOD, new AddSecurityAdminPostCommand());
        repository.put(CommandsConstants.ADD_SECURITY_TO_PORTFOLIO_COMMAND + GET_METHOD, new AddSecurityToPortfolioGetCommand());
        repository.put(CommandsConstants.ADD_SECURITY_TO_PORTFOLIO_COMMAND + POST_METHOD, new AddSecurityToPortfolioPostCommand());
        repository.put(CommandsConstants.ADD_USER_ADMIN_COMMAND + GET_METHOD, new AddUserAdminGetCommand());
        repository.put(CommandsConstants.ADD_USER_ADMIN_COMMAND + POST_METHOD, new AddUserAdminPostCommand());
        repository.put(CommandsConstants.ADMIN_SETTINGS_COMMAND + GET_METHOD, new AdminSettingsGetCommand());
        repository.put(CommandsConstants.BAN_USER_COMMAND + POST_METHOD, new BanUserPostCommand());
        repository.put(CommandsConstants.BAN_USER_TRANSACTIONS_COMMAND + POST_METHOD, new BanUserTransactionsPostCommand());
        repository.put(CommandsConstants.DEPOSIT_COMMAND + GET_METHOD, new DepositGetCommand());
        repository.put(CommandsConstants.DEPOSIT_COMMAND + POST_METHOD, new DepositPostCommand());
        repository.put(CommandsConstants.GET_ALL_PORTFOLIO_SECURITIES_COMMAND + GET_METHOD, new GetAllPortfolioSecuritiesGetCommand());
        repository.put(CommandsConstants.GET_ALL_PORTFOLIO_TRANSACTIONS_COMMAND + GET_METHOD, new GetAllPortfolioTransactionsGetCommand());
        repository.put(CommandsConstants.GET_ALL_SECURITIES_COMMAND + GET_METHOD, new GetAllSecuritiesGetCommand());
        repository.put(CommandsConstants.GET_ALL_SECURITIES_ADMIN_COMMAND + GET_METHOD, new GetAllSecuritiesAdminGetCommand());
        repository.put(CommandsConstants.GET_ALL_SECURITY_TRANSACTIONS_COMMAND + GET_METHOD, new GetAllSecurityTransactionsGetCommand());
        repository.put(CommandsConstants.GET_ALL_USER_PORTFOLIOS_COMMAND + GET_METHOD, new GetAllUserPortfoliosGetCommand());
        repository.put(CommandsConstants.GET_ALL_USER_PORTFOLIOS_ADMIN_COMMAND + GET_METHOD, new GetAllUserPortfoliosAdminGetCommand());
        repository.put(CommandsConstants.GET_ALL_USERS_COMMAND + GET_METHOD, new GetAllUsersGetCommand());
        repository.put(CommandsConstants.GET_BALANCE_COMMAND + GET_METHOD, new GetBalanceGetCommand());
        repository.put(CommandsConstants.GET_SECURITY_COMMAND + GET_METHOD, new GetSecurityGetCommand());
        repository.put(CommandsConstants.GET_USER_SETTINGS_ADMIN_COMMAND + GET_METHOD, new GetUserSettingsAdminGetCommand());
        repository.put(CommandsConstants.LOAN_COMMAND + GET_METHOD, new LoanGetCommand());
        repository.put(CommandsConstants.LOAN_COMMAND + POST_METHOD, new LoanPostCommand());
        repository.put(CommandsConstants.LOGIN_COMMAND + GET_METHOD, new LogInGetCommand());
        repository.put(CommandsConstants.LOGIN_COMMAND + POST_METHOD, new LogInPostCommand());
        repository.put(CommandsConstants.LOGOUT_COMMAND + GET_METHOD, new LogOutCommand());
        repository.put(CommandsConstants.SELL_SECURITY_FROM_PORTFOLIO_COMMAND + GET_METHOD, new SellSecurityFromPortfolioGetCommand());
        repository.put(CommandsConstants.SELL_SECURITY_FROM_PORTFOLIO_COMMAND + POST_METHOD, new SellSecurityFromPortfolioPostCommand());
        repository.put(CommandsConstants.SIGNUP_COMMAND + GET_METHOD, new SignUpGetCommand());
        repository.put(CommandsConstants.SIGNUP_COMMAND + POST_METHOD, new SignUpPostCommand());
        repository.put(CommandsConstants.REMOVE_PORTFOLIO_COMMAND + GET_METHOD, new RemovePortfolioGetCommand());
        repository.put(CommandsConstants.REMOVE_SECURITY_FROM_PORTFOLIO_COMMAND + POST_METHOD, new RemoveSecurityFromPortfolioPostCommand());
        repository.put(CommandsConstants.REMOVE_TRANSACTION_COMMAND + POST_METHOD, new RemoveTransactionPostCommand());
        repository.put(CommandsConstants.REMOVE_USER_ADMIN_COMMAND + POST_METHOD, new RemoveUserPostCommand());
        repository.put(CommandsConstants.UPDATE_PORTFOLIO_COMMAND + GET_METHOD, new UpdatePortfolioGetCommand());
        repository.put(CommandsConstants.UPDATE_PORTFOLIO_COMMAND + POST_METHOD, new UpdatePortfolioPostCommand());
        repository.put(CommandsConstants.UPDATE_SECURITY_COMMAND + GET_METHOD, new UpdateSecurityGetCommand());
        repository.put(CommandsConstants.UPDATE_SECURITY_COMMAND + POST_METHOD, new UpdateSecurityPostCommand());
        repository.put(CommandsConstants.UPDATE_TRANSACTION_COMMAND + GET_METHOD, new UpdateTransactionGetCommand());
        repository.put(CommandsConstants.UPDATE_TRANSACTION_COMMAND + POST_METHOD, new UpdateTransactionPostCommand());
        repository.put(CommandsConstants.UPDATE_USER_ADMIN_COMMAND + GET_METHOD, new UpdateUserAdminGetCommand());
        repository.put(CommandsConstants.UPDATE_USER_ADMIN_COMMAND + POST_METHOD, new UpdateUserAdminPostCommand());
        repository.put(CommandsConstants.UPDATE_USER_COMMAND + GET_METHOD, new UpdateUserGetCommand());
        repository.put(CommandsConstants.UPDATE_USER_COMMAND + POST_METHOD, new UpdateUserPostCommand());
        repository.put(CommandsConstants.USER_SETTINGS_COMMAND + GET_METHOD, new UserSettingsGetCommand());
        repository.put(CommandsConstants.WITHDRAW_COMMAND + GET_METHOD, new WithdrawGetCommand());
        repository.put(CommandsConstants.WITHDRAW_COMMAND + POST_METHOD, new WithdrawPostCommand());
        repository.put("", new NoSuchCommand());
        repository.put(null, new NoSuchCommand());
    }

    public Command getCommand(String commandName) {
        return repository.get(commandName);
    }

    public static CommandProvider getInstance() {
        return INSTANCE;
    }
}
