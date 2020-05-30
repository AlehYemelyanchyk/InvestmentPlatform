package by.epam.investmentplatform.controller.command.impl;

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
    public final Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    public static final UserService USER_SERVICE = ServiceFactory.getInstance().getUserService();
    public static final PortfolioService PORTFOLIO_SERVICE = ServiceFactory.getInstance().getPortfolioService();
    public static final SecurityService SECURITY_SERVICE = ServiceFactory.getInstance().getSecurityService();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forwardToPage(req, resp);
    }

    protected abstract void forwardToPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

    protected final int getPagesAmount(int totalItemsAmount, int itemsPerPage) {
        double result = (double) totalItemsAmount / itemsPerPage;
        return (int) Math.ceil(result);
    }

    protected String preventXSSAttach (String str){
        String newStr;
        if (str.contains("<")) {
            return newStr = str.replace("<", "&lt");
        }
        return str;
    }
}
