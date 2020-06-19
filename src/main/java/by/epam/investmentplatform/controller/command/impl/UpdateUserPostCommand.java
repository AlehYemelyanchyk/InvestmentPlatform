package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.CommandsConstants;
import by.epam.investmentplatform.Constants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.entity.User;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateUserPostCommand extends AbstractCommandExecutor {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        User user = new User(
                Integer.parseInt(req.getParameter(Constants.CURRENT_USER_ID)),
                req.getParameter(Constants.CURRENT_USER_ROLE),
                req.getParameter(Constants.CURRENT_USER_LOGIN),
                req.getParameter(Constants.REQUEST_USER_PARAM_PASSWORD),
                req.getParameter(Constants.REQUEST_USER_PARAM_EMAIL),
                req.getParameter(Constants.REQUEST_PORTFOLIO_PARAM_NAME),
                req.getParameter(Constants.REQUEST_USER_PARAM_SURNAME),
                req.getParameter(Constants.REQUEST_USER_PARAM_COUNTRY));
        String[] params = {};
        try {
            userService.updateUser(user, params);
        } catch (ServiceException e) {
            LOGGER.error("UpdateUserPostCommand error: ", e);
            throw new ServletException("Incorrect values.");
        }
        req.setAttribute(Constants.REDIRECT_LINK, CommandsConstants.USER_SETTINGS_COMMAND);
        RoutingUtils.forwardToPage(JspPageName.REDIRECT_PAGE, req, resp);
    }
}