package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.Constants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.controller.command.RequestParameterName;
import by.epam.investmentplatform.entity.User;
import by.epam.investmentplatform.service.exceptions.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogInPostCommandImpl extends AbstractCommandExecutor {

    @Override
    protected RequestDispatcher getDispatcher(HttpServletRequest request) throws ServiceException {
        try {
            User user = USER_SERVICE.logIn(
                    request.getParameter(RequestParameterName.REQUEST_USER_PARAM_LOGIN),
                    request.getParameter(RequestParameterName.REQUEST_USER_PARAM_PASSWORD)
            );
            if (user == null){
                request.setAttribute(Constants.ERROR_ATTRIBUTE, "Login or password is not correct.");
                return request.getRequestDispatcher(JspPageName.ERROR_PAGE);
            }
            HttpSession session = request.getSession(true);
            session.setAttribute(Constants.CURRENT_USER_ID, user.getId());
            session.setAttribute(Constants.CURRENT_USER_LOGIN, user.getLogin());
            session.setAttribute(Constants.CURRENT_USER_ROLE, user.getRole());
        } catch (ServiceException e) {
            LOGGER.error("Sign up error: ", e);
            throw e;
        }
        return request.getRequestDispatcher(JspPageName.MENU_PAGE);
    }
}