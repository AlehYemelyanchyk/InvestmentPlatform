package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.CommandsConstants;
import by.epam.investmentplatform.NamesConstants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.entity.BalanceTransaction;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

public class LoanPostCommand extends AbstractCommand {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int userId = (int) req.getSession().getAttribute(NamesConstants.CURRENT_USER_ID);
        int type = Integer.parseInt(req.getParameter(NamesConstants.TRANSACTION_TYPE));
        double amount = Double.parseDouble(req.getParameter(NamesConstants.AMOUNT));
        LocalDate date = (LocalDate) req.getSession().getAttribute(NamesConstants.DATE);

        BalanceTransaction balanceTransaction = new BalanceTransaction(userId, type, amount, date);
        try {
            userService.addBalanceTransaction(userId, balanceTransaction);
        } catch (ServiceException e) {
            LOGGER.error("LoanPostCommand error: ", e);
            throw new ServletException("Incorrect values.");
        }
        req.getSession().setAttribute(NamesConstants.AMOUNT, amount);
        req.setAttribute(NamesConstants.REDIRECT_LINK, CommandsConstants.GET_BALANCE);
        RoutingUtils.forwardToPage(JspPageName.REDIRECT_PAGE, req, resp);
    }
}