package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.controller.command.RequestParameterName;
import by.epam.investmentplatform.entity.User;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignUpPostCommandImpl extends AbstractCommandExecutor {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        User user = new User(
                req.getParameter(RequestParameterName.REQUEST_USER_PARAM_ROLE),
                req.getParameter(RequestParameterName.REQUEST_USER_PARAM_LOGIN),
                req.getParameter(RequestParameterName.REQUEST_USER_PARAM_PASSWORD),
                req.getParameter(RequestParameterName.REQUEST_USER_PARAM_EMAIL),
                req.getParameter(RequestParameterName.REQUEST_USER_PARAM_NAME),
                req.getParameter(RequestParameterName.REQUEST_USER_PARAM_SURNAME),
                req.getParameter(RequestParameterName.REQUEST_USER_PARAM_COUNTRY));
        try {
            USER_SERVICE.signUp(user);
            HttpSession session = req.getSession(true);
            session.setAttribute("id", user.getId());
            session.setAttribute("login", user.getLogin());
            session.setAttribute("role", user.getRole());
        } catch (ServiceException e) {
            LOGGER.error("Sign up error: ", e);
            throw new ServiceException("Incorrect registration values");
        }
        RoutingUtils.forwardToPage(JspPageName.MENU_PAGE, req, resp);
    }
}
