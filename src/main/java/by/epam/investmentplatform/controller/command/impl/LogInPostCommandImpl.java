package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.Constants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.controller.command.RequestParameterName;
import by.epam.investmentplatform.controller.exception.AccessDeniedException;
import by.epam.investmentplatform.entity.User;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogInPostCommandImpl extends AbstractCommandExecutor {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            User user = USER_SERVICE.logIn(
                    req.getParameter(RequestParameterName.REQUEST_USER_PARAM_LOGIN),
                    req.getParameter(RequestParameterName.REQUEST_USER_PARAM_PASSWORD)
            );
            if (user == null) {
                RuntimeException e = new AccessDeniedException("Login or password is not correct.");
                LOGGER.error(e.getMessage());
                throw e;
            }
            HttpSession session = req.getSession(true);
            session.setAttribute(Constants.CURRENT_USER_ID, user.getId());
            session.setAttribute(Constants.CURRENT_USER_LOGIN, user.getLogin());
            session.setAttribute(Constants.CURRENT_USER_ROLE, user.getRole());
        } catch (ServiceException e) {
            LOGGER.error("Log in error: ", e);
            throw new AccessDeniedException(e.getMessage());
        }
        if (req.getSession().getAttribute(Constants.REDIRECT_LINK) != null) {
            RoutingUtils.forwardToPage(JspPageName.REDIRECT_PAGE, req, resp);
        } else {
            RoutingUtils.forwardToPage(JspPageName.NEWS_PAGE, req, resp);
        }
    }
}