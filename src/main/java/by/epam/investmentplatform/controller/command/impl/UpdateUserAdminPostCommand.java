package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.CommandsConstants;
import by.epam.investmentplatform.Constants;
import by.epam.investmentplatform.NamesConstants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateUserAdminPostCommand extends AbstractCommand {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            String id = req.getParameter(NamesConstants.REQUEST_USER_PARAM_ID);
            String role = req.getParameter(NamesConstants.REQUEST_USER_PARAM_ROLE);
            String login = req.getParameter(NamesConstants.REQUEST_USER_PARAM_LOGIN);
            String email = req.getParameter(NamesConstants.REQUEST_USER_PARAM_EMAIL);
            String name = req.getParameter(NamesConstants.REQUEST_PORTFOLIO_PARAM_NAME);
            String surname = req.getParameter(NamesConstants.REQUEST_USER_PARAM_SURNAME);
            String country = req.getParameter(NamesConstants.REQUEST_USER_PARAM_COUNTRY);
            String[] params = {id, role, login, email, name, surname, country};

            userService.updateUser(params);
        } catch (NullPointerException e) {
            LOGGER.error("UpdateUserAdminPostCommand missing value error: ", e);
        } catch (ServiceException e) {
            LOGGER.error("UpdateUserAdminPostCommand error: ", e);
            throw new ServletException("Incorrect values.");
        }
        req.setAttribute(NamesConstants.REDIRECT_LINK, CommandsConstants.GET_ALL_USERS);
        req.getSession().setAttribute(NamesConstants.REQUEST_METHOD, Constants.GET_METHOD);
        RoutingUtils.forwardToPage(JspPageName.REDIRECT_PAGE, req, resp);
    }
}