package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.controller.command.Command;
import by.epam.investmentplatform.service.PortfolioService;
import by.epam.investmentplatform.service.UserService;
import by.epam.investmentplatform.service.factory.ServiceFactory;
import by.epam.investmentplatform.util.RoutingUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AbstractCommandExecutor implements Command {
    public final Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    public static final UserService USER_SERVICE = ServiceFactory.getInstance().getUserService();
    public static final PortfolioService PORTFOLIO_SERVICE = ServiceFactory.getInstance().getPortfolioService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            RequestDispatcher dispatcher = getDispatcher(request);
//            dispatcher.forward(request, response);
        RoutingUtils.forwardToPage("error.jsp", request, response);
    }

    protected abstract RequestDispatcher getDispatcher(HttpServletRequest request);
}
