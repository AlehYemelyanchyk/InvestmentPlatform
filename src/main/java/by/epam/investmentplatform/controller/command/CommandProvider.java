package by.epam.investmentplatform.controller.command;

import by.epam.investmentplatform.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {
    private static final CommandProvider instance = new CommandProvider();

    private final Map<String, Command> repository = new HashMap<>();

    private CommandProvider() {
        repository.put("signupGET", new SignUpGetCommandImpl());
        repository.put("signupPOST", new SignUpPostCommandImpl());
        repository.put("getAllUsersGET", new GetAllUsersGetCommandImpl());
        repository.put("loginGET", new LogInGetCommandImpl());
        repository.put("loginPOST", new LogInPostCommandImpl());
        repository.put("logoutGET", new LogOutCommandImpl());
        repository.put("addPortfolioGET", new AddPortfolioGetCommandImpl());
        repository.put("addPortfolioPOST", new AddPortfolioPostCommandImpl());
        repository.put("updatePortfolio.jspGET", new UpdatePortfolioGetCommandImpl());
        repository.put("updatePortfolioPOST", new UpdatePortfolioPostCommandImpl());
        repository.put("removePortfolio.jspGET", new RemovePortfolioGetCommandImpl());
        repository.put("getAllUserPortfoliosGET", new GetAllUserPortfoliosGetCommandImpl());
        repository.put("", new NoSuchCommandImpl());
    }

    public Command getCommand(String commandName) {
        return repository.get(commandName);
    }

    public static CommandProvider getInstance() {
        return instance;
    }
}
