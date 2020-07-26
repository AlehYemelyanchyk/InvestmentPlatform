package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.Constants;
import by.epam.investmentplatform.NamesConstants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.entity.Portfolio;
import by.epam.investmentplatform.entity.User;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignUpPostCommand extends AbstractCommand {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        User user = new User(
                Constants.ROLE_USER,
                req.getParameter(NamesConstants.REQUEST_USER_PARAM_LOGIN),
                req.getParameter(NamesConstants.REQUEST_USER_PARAM_PASSWORD),
                req.getParameter(NamesConstants.REQUEST_USER_PARAM_EMAIL),
                req.getParameter(NamesConstants.REQUEST_USER_PARAM_NAME),
                req.getParameter(NamesConstants.REQUEST_USER_PARAM_SURNAME),
                req.getParameter(NamesConstants.REQUEST_USER_PARAM_COUNTRY));
        try {
            userService.signUp(user);
            user = userService.getUser(user.getLogin());
            HttpSession session = req.getSession(true);
            session.setAttribute(NamesConstants.CURRENT_USER_ID, user.getId());
            session.setAttribute(NamesConstants.CURRENT_USER_LOGIN, user.getLogin());
            session.setAttribute(NamesConstants.CURRENT_USER_ROLE, user.getRole());
        } catch (ServiceException e) {
            LOGGER.error("SignUpPostCommand error: ", e);
            throw new ServletException("Incorrect registration values.");
        }
        try {
            portfolioService.addPortfolio(new Portfolio(user.getId(), "First Portfolio"));
        } catch (ServiceException e) {
            LOGGER.error("SignUpPostCommand error: ", e);
            throw new ServletException("Portfolio creation problems.");
        }
        req.getSession().setAttribute(NamesConstants.REDIRECT_LINK, JspPageName.NEWS_PAGE);
        RoutingUtils.forwardToPage(JspPageName.REDIRECT_PAGE, req, resp);
    }
}
