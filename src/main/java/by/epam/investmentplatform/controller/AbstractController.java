package by.epam.investmentplatform.controller;

import by.epam.investmentplatform.service.UserService;
import by.epam.investmentplatform.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AbstractController extends HttpServlet {
    private static final long serialVersionUID = 9139886125580045297L;
    public static final Logger LOGGER = LogManager.getLogger();
    private static ServiceFactory serviceFactory;
    private static UserService userService;

    // the init method is an equivalent of a constructor for servlets
    @Override
    public final void init() throws ServletException {
        try {
            serviceFactory = ServiceFactory.getInstance();
            userService = serviceFactory.getUserService();
        } catch (Exception e) {
            LOGGER.error("Servlet init error: " + e);
            throw new ServletException(e);
        }
    }

    @Override
    protected abstract void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException;

    public final UserService getUserService() {
        return userService;
    }
}
