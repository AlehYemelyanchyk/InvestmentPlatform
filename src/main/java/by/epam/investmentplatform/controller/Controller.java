package by.epam.investmentplatform.controller;

import by.epam.investmentplatform.controller.command.Command;
import by.epam.investmentplatform.controller.command.CommandProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.epam.investmentplatform.Constants.COMMAND_ATTRIBUTE;

@WebServlet(urlPatterns = "/controller")
public class Controller extends AbstractController {
    private static final long serialVersionUID = 3164262627368034557L;
    private static final CommandProvider commandProvider = CommandProvider.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String commandName = req.getAttribute(COMMAND_ATTRIBUTE) + req.getMethod();
        Command command = commandProvider.getCommand(commandName);
        command.execute(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String commandName = req.getAttribute(COMMAND_ATTRIBUTE) + req.getMethod();
        Command command = commandProvider.getCommand(commandName);
        command.execute(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
