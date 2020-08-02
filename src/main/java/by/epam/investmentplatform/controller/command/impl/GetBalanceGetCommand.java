package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.NamesConstants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.entity.BalanceTransaction;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetBalanceGetCommand extends AbstractCommand {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            int userId = (int) (req.getSession().getAttribute(NamesConstants.CURRENT_USER_ID));

            List<BalanceTransaction> userBalanceTransactions = userService.getUserBalanceTransactions(userId);
            double balance = countBalance(userBalanceTransactions);
            req.setAttribute(NamesConstants.CURRENT_USER_BALANCE_TRANSACTIONS, userBalanceTransactions);
            req.getSession().setAttribute(NamesConstants.CURRENT_USER_BALANCE, balance);
        } catch (NullPointerException e) {
            LOGGER.error("GetBalanceGetCommand missing value error: ", e);
        } catch (ServiceException e) {
            LOGGER.error("GetBalanceGetCommand error: ", e);
            throw new ServletException("Incorrect values.");
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
