package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.Constants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetUserSettingsAdminGetCommand extends AbstractCommandExecutor {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int userId;
        if (req.getParameter(Constants.PORTFOLIO_USER_ID) != null) {
            userId = Integer.parseInt(req.getParameter(Constants.PORTFOLIO_USER_ID));
        } else {
            userId = (int) (req.getSession().getAttribute(Constants.PORTFOLIO_USER_ID));
        }
        req.setAttribute(Constants.USER_ID, userId);
        RoutingUtils.forwardToPage(JspPageName.USER_SETTINGS_ADMIN_PAGE, req, resp);
    }
}