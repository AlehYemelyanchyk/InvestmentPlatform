package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.CommandsConstants;
import by.epam.investmentplatform.NamesConstants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.entity.User;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoveUserPostCommand extends AbstractCommand {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter(NamesConstants.USER_ID));
        try {
            User user = userService.getUser(userId);
            userService.deleteUser(user);
        } catch (ServiceException e) {
            LOGGER.error("RemoveUserPostCommand error: ", e);
            throw new ServletException("Incorrect values");
        }
        req.setAttribute(NamesConstants.REDIRECT_LINK, CommandsConstants.GET_ALL_USERS_COMMAND);
        RoutingUtils.forwardToPage(JspPageName.REDIRECT_PAGE, req, resp);
    }
}