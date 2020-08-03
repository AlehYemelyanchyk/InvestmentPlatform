package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.CommandsConstants;
import by.epam.investmentplatform.Constants;
import by.epam.investmentplatform.NamesConstants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.entity.User;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddUserAdminPostCommand extends AbstractCommand {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            String role = req.getParameter(NamesConstants.REQUEST_USER_PARAM_ROLE);
            String login = req.getParameter(NamesConstants.REQUEST_USER_PARAM_LOGIN);
            String password = req.getParameter(NamesConstants.REQUEST_USER_PARAM_PASSWORD);
            String email = req.getParameter(NamesConstants.REQUEST_USER_PARAM_EMAIL);
            String name = req.getParameter(NamesConstants.REQUEST_USER_PARAM_NAME);
            String surname = req.getParameter(NamesConstants.REQUEST_USER_PARAM_SURNAME);
            String country = req.getParameter(NamesConstants.REQUEST_USER_PARAM_COUNTRY);
            User user = new User(role, login, password, email, name, surname, country);

            userService.signUp(user);
        } catch (NullPointerException e) {
            LOGGER.error("AddUserAdminPostCommand missing value error: ", e);
        } catch (ServiceException e) {
            LOGGER.error("AddUserAdminPostCommand error: ", e);
            throw new ServletException("Incorrect registration values.");
        }
        req.setAttribute(NamesConstants.REDIRECT_LINK, CommandsConstants.GET_ALL_USERS);
        req.getSession().setAttribute(NamesConstants.REQUEST_METHOD, Constants.GET_METHOD);
        RoutingUtils.forwardToPage(JspPageName.REDIRECT_PAGE, req, resp);
    }
}
