package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.controller.command.Command;
import by.epam.investmentplatform.service.PortfolioService;
import by.epam.investmentplatform.service.UserService;
import by.epam.investmentplatform.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AbstractCommandExecutor implements Command {
    public final Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    public static final UserService USER_SERVICE = ServiceFactory.getInstance().getUserService();
    public static final PortfolioService PORTFOLIO_SERVICE = ServiceFactory.getInstance().getPortfolioService();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forwardToPage(req, resp);
//        dispatcher.forward(request, response);
//        String
//        RoutingUtils.forwardToPage("login.jsp", request, response);
//        RoutingUtils.forwardDispatcherToPage(dispatcher, request, response);
    }

    protected abstract void forwardToPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
