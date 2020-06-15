package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.Constants;
import by.epam.investmentplatform.controller.command.Command;
import by.epam.investmentplatform.service.PortfolioService;
import by.epam.investmentplatform.service.SecurityService;
import by.epam.investmentplatform.service.UserService;
import by.epam.investmentplatform.service.impl.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AbstractCommandExecutor implements Command {
    public static final Logger LOGGER = LogManager.getLogger();
    public final UserService userService = ServiceFactory.getInstance().getUserService();
    public final PortfolioService portfolioService = ServiceFactory.getInstance().getPortfolioService();
    public final SecurityService securityService = ServiceFactory.getInstance().getSecurityService();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forwardToPage(req, resp);
    }

    protected abstract void forwardToPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

    protected final int getPagesAmount(int totalItemsAmount) {
        double result = (double) totalItemsAmount / Constants.ITEMS_PER_PAGE;
        return (int) Math.ceil(result);
    }
}
