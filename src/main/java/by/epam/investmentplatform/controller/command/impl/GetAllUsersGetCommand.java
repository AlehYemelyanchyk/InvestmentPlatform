package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.Constants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.entity.User;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetAllUsersGetCommand extends AbstractCommandExecutor {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            List<User> allUsers = USER_SERVICE.getAllUsers();
            req.setAttribute(Constants.USERS_LIST, allUsers);
        } catch (ServiceException e) {
            LOGGER.error("Get all users error", e);
        }
        RoutingUtils.forwardToPage(JspPageName.GET_ALL_USERS_PAGE, req, resp);
    }
}
