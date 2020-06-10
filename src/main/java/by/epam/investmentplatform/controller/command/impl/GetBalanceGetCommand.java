package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.Constants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.entity.BalanceTransaction;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetBalanceGetCommand extends AbstractCommandExecutor {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            int userId = (int) (req.getSession().getAttribute(Constants.CURRENT_USER_ID));
            List<BalanceTransaction> userBalanceTransactions = USER_SERVICE.getUserBalanceTransactions(userId);
            double balance = countBalance(userBalanceTransactions);
            req.setAttribute(Constants.CURRENT_USER_BALANCE_TRANSACTIONS, userBalanceTransactions);
            req.getSession().setAttribute(Constants.CURRENT_USER_BALANCE, balance);
        } catch (ServiceException e) {
            LOGGER.error("Get user's balance transactions error", e);
        }
        RoutingUtils.forwardToPage(JspPageName.GET_USER_BALANCE_PAGE, req, resp);
    }

    private double countBalance(List<BalanceTransaction> userBalanceTransactions) {
        double balance = 0.0;
        for (BalanceTransaction transaction : userBalanceTransactions) {
            int type = transaction.getType();
            if (type == 2 || type == 3 || type == 5) {
                balance += transaction.getAmount();
            } else balance -= transaction.getAmount();
        }
        return balance;
    }
}
