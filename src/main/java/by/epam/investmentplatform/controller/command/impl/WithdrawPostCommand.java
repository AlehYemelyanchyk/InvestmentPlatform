package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.CommandsConstants;
import by.epam.investmentplatform.Constants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.entity.BalanceTransaction;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

public class WithdrawPostCommand extends AbstractCommandExecutor {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int userId = (int) req.getSession().getAttribute(Constants.CURRENT_USER_ID);
        int type = Integer.parseInt(req.getParameter(Constants.TRANSACTION_TYPE));
        double amount = Double.parseDouble(req.getParameter(Constants.AMOUNT));
        Date date = Date.valueOf(String.valueOf(req.getSession().getAttribute(Constants.DATE)));

        BalanceTransaction balanceTransaction = new BalanceTransaction(userId, type, amount, date);

        try {
            userService.addBalanceTransaction(userId, balanceTransaction);
        } catch (ServiceException e) {
            LOGGER.error("WithdrawPostCommand error: ", e);
            throw new ServletException("Withdraw payment error.");
        }
        req.getSession().setAttribute(Constants.AMOUNT, amount);
        req.setAttribute(Constants.REDIRECT_LINK, CommandsConstants.GET_BALANCE_COMMAND);
        RoutingUtils.forwardToPage(JspPageName.REDIRECT_PAGE, req, resp);
    }
}