package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.Constants;
import by.epam.investmentplatform.NamesConstants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BanUserTransactionsPostCommand extends AbstractCommandExecutor {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String banStatus;
        try {
            int userId = (int) req.getSession().getAttribute(NamesConstants.USER_ID);
            banStatus = req.getParameter(NamesConstants.TRANSACTIONS_BAN_STATUS);
            if (Constants.BAN_STATUS_ACTIVE.equals(banStatus)) {
                banStatus = Constants.BAN_STATUS_ACTIVE;
            } else {
                banStatus = Constants.BAN_STATUS_INACTIVE;
            }
            String[] params = {banStatus};
            userService.updateUserTransactionBanStatus(userId, params);
            req.getSession().setAttribute(NamesConstants.TRANSACTIONS_BAN_STATUS, banStatus);
        } catch (ServiceException e) {
            LOGGER.error("BanUserTransactionsPostCommand error: ", e);
            throw new ServletException("Incorrect values.");
        }
        RoutingUtils.forwardToPage(JspPageName.USER_SETTINGS_ADMIN_PAGE, req, resp);
    }
}