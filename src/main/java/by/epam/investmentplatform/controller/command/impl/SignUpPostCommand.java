package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.Constants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.entity.User;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignUpPostCommand extends AbstractCommandExecutor {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        User user = new User(
                Constants.ROLE_USER,
                req.getParameter(Constants.REQUEST_USER_PARAM_LOGIN),
                req.getParameter(Constants.REQUEST_USER_PARAM_PASSWORD),
                req.getParameter(Constants.REQUEST_USER_PARAM_EMAIL),
                req.getParameter(Constants.REQUEST_USER_PARAM_NAME),
                req.getParameter(Constants.REQUEST_USER_PARAM_SURNAME),
                req.getParameter(Constants.REQUEST_USER_PARAM_COUNTRY));
        try {
            userService.signUp(user);
            HttpSession session = req.getSession(true);
            session.setAttribute(Constants.CURRENT_USER_ID, user.getId());
            session.setAttribute(Constants.CURRENT_USER_LOGIN, user.getLogin());
            session.setAttribute(Constants.CURRENT_USER_ROLE, user.getRole());
        } catch (ServiceException e) {
            LOGGER.error("SignUpPostCommand error: ", e);
            throw new ServiceException("Incorrect registration values.");
        }
        RoutingUtils.forwardToPage(JspPageName.GET_ALL_USER_PORTFOLIOS_PAGE, req, resp);
    }
}
