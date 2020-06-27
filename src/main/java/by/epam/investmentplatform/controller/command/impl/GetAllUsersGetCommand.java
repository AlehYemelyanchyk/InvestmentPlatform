package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.NamesConstants;
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
        int userRole = Integer.parseInt((String) req.getSession().getAttribute(NamesConstants.CURRENT_USER_ROLE));
        try {
            List<User> allUsers = userService.getAllUsers(userRole);
            req.getSession().setAttribute(NamesConstants.USERS_LIST, allUsers);
        } catch (ServiceException e) {
            LOGGER.error("GetAllUsersGetCommand error: ", e);
            throw new ServletException("Access denied.");
        }
        RoutingUtils.forwardToPage(JspPageName.GET_ALL_USERS_PAGE, req, resp);
    }
}
