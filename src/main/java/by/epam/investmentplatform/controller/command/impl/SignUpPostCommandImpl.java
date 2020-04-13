package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.controller.command.RequestParameterName;
import by.epam.investmentplatform.entity.User;
import by.epam.investmentplatform.service.exceptions.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SignUpPostCommandImpl extends AbstractCommandExecutor {

    @Override
    protected RequestDispatcher getDispatcher(HttpServletRequest request) throws ServiceException {
        User user = new User(
                request.getParameter(RequestParameterName.REQUEST_USER_PARAM_ROLE),
                request.getParameter(RequestParameterName.REQUEST_USER_PARAM_LOGIN),
                request.getParameter(RequestParameterName.REQUEST_USER_PARAM_PASSWORD),
                request.getParameter(RequestParameterName.REQUEST_USER_PARAM_EMAIL),
                request.getParameter(RequestParameterName.REQUEST_USER_PARAM_NAME),
                request.getParameter(RequestParameterName.REQUEST_USER_PARAM_SURNAME),
                request.getParameter(RequestParameterName.REQUEST_USER_PARAM_COUNTRY));
        try {
            USER_SERVICE.signUp(user);
            HttpSession session = request.getSession(true);
            session.setAttribute("id", user.getId());
            session.setAttribute("login", user.getLogin());
            session.setAttribute("role", user.getRole());
        } catch (ServiceException e) {
            LOGGER.error("Sign up error: ", e);
            throw new ServiceException("Incorrect registration values");
        }
        return request.getRequestDispatcher(JspPageName.MENU_PAGE);
    }
}
