package by.epam.investmentplatform.controller.command;

import by.epam.investmentplatform.CommandsConstants;
import by.epam.investmentplatform.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {
    private static final CommandProvider instance = new CommandProvider();

    private final Map<String, Command> repository = new HashMap<>();
    private final String GET_METHOD = "GET";
    private final String POST_METHOD = "POST";

    private CommandProvider() {
        repository.put(CommandsConstants.ADD_PORTFOLIO_COMMAND + GET_METHOD, new AddPortfolioGetCommandImpl());
        repository.put(CommandsConstants.ADD_PORTFOLIO_COMMAND + POST_METHOD, new AddPortfolioPostCommandImpl());
        repository.put(CommandsConstants.ADD_SECURITY_COMMAND + GET_METHOD, new AddSecurityGetCommandImpl());
        repository.put(CommandsConstants.ADD_SECURITY_TO_PORTFOLIO_COMMAND + GET_METHOD, new AddSecurityToPortfolioGetCommandImpl());
        repository.put(CommandsConstants.ADD_SECURITY_TO_PORTFOLIO_COMMAND + POST_METHOD, new AddSecurityToPortfolioPostCommandImpl());
        repository.put(CommandsConstants.DEPOSIT_COMMAND + GET_METHOD, new DepositGetCommandImpl());
        repository.put(CommandsConstants.DEPOSIT_COMMAND + POST_METHOD, new DepositPostCommandImpl());
        repository.put(CommandsConstants.GET_ALL_PORTFOLIO_SECURITIES_COMMAND + GET_METHOD, new GetAllPortfolioSecuritiesGetCommandImpl());
        repository.put(CommandsConstants.GET_ALL_PORTFOLIO_TRANSACTIONS_COMMAND + GET_METHOD, new GetAllPortfolioTransactionsGetCommandImpl());
        repository.put(CommandsConstants.GET_ALL_SECURITIES_COMMAND + GET_METHOD, new GetAllSecuritiesGetCommandImpl());
        repository.put(CommandsConstants.GET_ALL_SECURITY_TRANSACTIONS_COMMAND + GET_METHOD, new GetAllSecurityTransactionsGetCommandImpl());
        repository.put(CommandsConstants.GET_ALL_USER_PORTFOLIOS_COMMAND + GET_METHOD, new GetAllUserPortfoliosGetCommandImpl());
        repository.put(CommandsConstants.GET_ALL_USERS_COMMAND + GET_METHOD, new GetAllUsersGetCommandImpl());
        repository.put(CommandsConstants.GET_BALANCE_COMMAND + GET_METHOD, new GetBalanceGetCommandImpl());
        repository.put(CommandsConstants.GET_SECURITY_COMMAND + GET_METHOD, new GetSecurityGetCommandImpl());
        repository.put(CommandsConstants.LOAN_COMMAND + GET_METHOD, new LoanGetCommandImpl());
        repository.put(CommandsConstants.LOAN_COMMAND + POST_METHOD, new LoanPostCommandImpl());
        repository.put(CommandsConstants.LOGIN_COMMAND + GET_METHOD, new LogInGetCommandImpl());
        repository.put(CommandsConstants.LOGIN_COMMAND + POST_METHOD, new LogInPostCommandImpl());
        repository.put(CommandsConstants.LOGOUT_COMMAND + GET_METHOD, new LogOutCommandImpl());
        repository.put(CommandsConstants.SIGNUP_COMMAND + GET_METHOD, new SignUpGetCommandImpl());
        repository.put(CommandsConstants.SIGNUP_COMMAND + POST_METHOD, new SignUpPostCommandImpl());
        repository.put(CommandsConstants.REMOVE_PORTFOLIO_COMMAND + GET_METHOD, new RemovePortfolioGetCommandImpl());
        repository.put(CommandsConstants.REMOVE_SECURITY_FROM_PORTFOLIO_COMMAND + POST_METHOD, new RemoveSecurityFromPortfolioPostCommandImpl());
        repository.put(CommandsConstants.REMOVE_TRANSACTION_COMMAND + POST_METHOD, new RemoveTransactionPostCommandImpl());
        repository.put(CommandsConstants.UPDATE_PORTFOLIO_COMMAND + GET_METHOD, new UpdatePortfolioGetCommandImpl());
        repository.put(CommandsConstants.UPDATE_PORTFOLIO_COMMAND + POST_METHOD, new UpdatePortfolioPostCommandImpl());
        repository.put(CommandsConstants.UPDATE_TRANSACTION_COMMAND + GET_METHOD, new UpdateTransactionGetCommandImpl());
        repository.put(CommandsConstants.UPDATE_TRANSACTION_COMMAND + POST_METHOD, new UpdateTransactionPostCommandImpl());
        repository.put(CommandsConstants.UPDATE_USER_COMMAND + GET_METHOD, new UpdateUserGetCommandImpl());
        repository.put(CommandsConstants.UPDATE_USER_COMMAND + POST_METHOD, new UpdateUserPostCommandImpl());
        repository.put(CommandsConstants.USER_SETTINGS_COMMAND + GET_METHOD, new UserSettingsGetCommandImpl());
        repository.put(CommandsConstants.WITHDRAW_COMMAND + GET_METHOD, new WithdrawGetCommandImpl());
        repository.put(CommandsConstants.WITHDRAW_COMMAND + POST_METHOD, new WithdrawPostCommandImpl());
        repository.put("", new NoSuchCommandImpl());
        repository.put(null, new NoSuchCommandImpl());
    }

    public Command getCommand(String commandName) {
        return repository.get(commandName);
    }

    public static CommandProvider getInstance() {
        return instance;
    }
}
