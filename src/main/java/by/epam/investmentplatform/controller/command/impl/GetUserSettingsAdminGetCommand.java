package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.NamesConstants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetUserSettingsAdminGetCommand extends AbstractCommand {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            int userId = Integer.parseInt(req.getParameter(NamesConstants.PORTFOLIO_USER_ID));
            String userBanStatus = req.getParameter(NamesConstants.USER_BAN_STATUS);
            String transactionBanStatus = req.getParameter(NamesConstants.TRANSACTIONS_BAN_STATUS);
            req.setAttribute(NamesConstants.USER_ID, userId);
            req.setAttribute(NamesConstants.USER_BAN_STATUS, userBanStatus);
            req.setAttribute(NamesConstants.TRANSACTIONS_BAN_STATUS, transactionBanStatus);
        } catch (NullPointerException e) {
            LOGGER.error("GetUserSettingsAdminGetCommand missing value error: ", e);
        }
        RoutingUtils.forwardToPage(JspPageName.USER_SETTINGS_ADMIN_PAGE, req, resp);
    }
}