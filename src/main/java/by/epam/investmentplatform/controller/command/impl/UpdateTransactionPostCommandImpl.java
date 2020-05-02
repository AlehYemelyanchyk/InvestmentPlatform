package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.Constants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.entity.Transaction;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class UpdateTransactionPostCommandImpl extends AbstractCommandExecutor {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String date = req.getParameter(Constants.DATE);
        Transaction transaction = new Transaction(
                (Integer.parseInt(req.getParameter(Constants.TRANSACTION_ID))),
                (Integer.parseInt(req.getParameter(Constants.PORTFOLIO_ID))),
                (req.getParameter(Constants.SECURITY_SYMBOL)),
                (Integer.parseInt(req.getParameter(Constants.TRANSACTION_TYPE))),
                (Integer.parseInt(req.getParameter(Constants.AMOUNT))),
                (Double.parseDouble(req.getParameter(Constants.PRICE))),
                new Date());
        String[] parameters = {date};
        try {
            SECURITY_SERVICE.updateTransaction(transaction, parameters);
        } catch (ServiceException e) {
            LOGGER.error("Update transaction error: ", e);
            throw new ServiceException("Incorrect values");
        }
        req.setAttribute(Constants.REDIRECT_LINK, "getAllUserPortfolios");
        RoutingUtils.forwardToPage(JspPageName.REDIRECT_PAGE, req, resp);
    }
}