package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.Constants;
import by.epam.investmentplatform.NamesConstants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.controller.exception.AccessDeniedException;
import by.epam.investmentplatform.entity.User;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogInPostCommand extends AbstractCommand {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            User user = userService.logIn(
                    req.getParameter(NamesConstants.REQUEST_USER_PARAM_LOGIN),
                    req.getParameter(NamesConstants.REQUEST_USER_PARAM_PASSWORD)
            );
            if (user == null) {
                RuntimeException e = new AccessDeniedException("Login or password is not correct.");
                LOGGER.error(e.getMessage());
                throw e;
            }
            HttpSession session = req.getSession(true);
            session.setAttribute(NamesConstants.CURRENT_USER_ID, user.getId());
            session.setAttribute(NamesConstants.CURRENT_USER_LOGIN, user.getLogin());
            session.setAttribute(NamesConstants.CURRENT_USER_ROLE, user.getRole());
        } catch (ServiceException e) {
            LOGGER.error("LogInPostCommand error: ", e);
            throw new AccessDeniedException("Can not login. Wrong login or password.");
        }
        if (req.getSession().getAttribute(NamesConstants.REDIRECT_LINK) != null) {
            RoutingUtils.forwardToPage(JspPageName.REDIRECT_PAGE, req, resp);
        } else if (Constants.ROLE_ADMIN.equals(req.getSession().getAttribute(NamesConstants.CURRENT_USER_ROLE))) {
            RoutingUtils.forwardToPage(JspPageName.ADMIN_SETTINGS_PAGE, req, resp);
        } else {
            req.getSession().setAttribute(NamesConstants.REDIRECT_LINK, JspPageName.NEWS_PAGE);
            RoutingUtils.forwardToPage(JspPageName.REDIRECT_PAGE, req, resp);
        }
    }
}