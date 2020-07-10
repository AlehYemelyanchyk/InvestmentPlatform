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
        int userId;
        if (req.getParameter(NamesConstants.PORTFOLIO_USER_ID) != null) {
            userId = Integer.parseInt(req.getParameter(NamesConstants.PORTFOLIO_USER_ID));
        } else {
            userId = (int) (req.getSession().getAttribute(NamesConstants.PORTFOLIO_USER_ID));
        }
        String userBanStatus;
        if (req.getParameter(NamesConstants.USER_BAN_STATUS) != null) {
            userBanStatus = req.getParameter(NamesConstants.USER_BAN_STATUS);
        } else {
            userBanStatus = (String) (req.getSession().getAttribute(NamesConstants.USER_BAN_STATUS));
        }
        String transactionBanStatus;
        if (req.getParameter(NamesConstants.TRANSACTIONS_BAN_STATUS) != null) {
            transactionBanStatus = req.getParameter(NamesConstants.TRANSACTIONS_BAN_STATUS);
        } else {
            transactionBanStatus = (String) (req.getSession().getAttribute(NamesConstants.TRANSACTIONS_BAN_STATUS));
        }
        req.getSession().setAttribute(NamesConstants.USER_ID, userId);
        req.getSession().setAttribute(NamesConstants.USER_BAN_STATUS, userBanStatus);
        req.getSession().setAttribute(NamesConstants.TRANSACTIONS_BAN_STATUS, transactionBanStatus);
        RoutingUtils.forwardToPage(JspPageName.USER_SETTINGS_ADMIN_PAGE, req, resp);
    }
}