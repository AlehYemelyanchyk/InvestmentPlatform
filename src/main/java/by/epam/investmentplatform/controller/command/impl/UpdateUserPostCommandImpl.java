package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.Constants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.controller.command.RequestParameterName;
import by.epam.investmentplatform.entity.User;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateUserPostCommandImpl extends AbstractCommandExecutor {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String newName = req.getParameter(RequestParameterName.REQUEST_PORTFOLIO_PARAM_NAME);
        User user = new User(
                Integer.parseInt(req.getParameter(Constants.CURRENT_USER_ID)),
                req.getParameter(Constants.CURRENT_USER_ROLE),
                req.getParameter(Constants.CURRENT_USER_LOGIN),
                req.getParameter(Constants.CURRENT_USER_PASSWORD),
                req.getParameter(Constants.CURRENT_USER_EMAIL),
                req.getParameter(Constants.CURRENT_USER_NAME),
                req.getParameter(Constants.CURRENT_USER_SURNAME),
                req.getParameter(Constants.CURRENT_USER_COUNTRY));
        String[] params = {newName};
        try {
            USER_SERVICE.updateUser(user, params);
        } catch (ServiceException e) {
            LOGGER.error("Update portfolio error: ", e);
            throw new ServiceException("Incorrect values");
        }
        req.setAttribute(Constants.REDIRECT_LINK, "getAllUserPortfolios");
        RoutingUtils.forwardToPage(JspPageName.REDIRECT_PAGE, req, resp);
    }
}