package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.CommandsConstants;
import by.epam.investmentplatform.Constants;
import by.epam.investmentplatform.NamesConstants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.entity.Transaction;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

public class UpdateTransactionPostCommand extends AbstractCommand {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String[] parameters = {};
        try {
            Transaction transaction = new Transaction(
                    (Integer.parseInt(req.getParameter(NamesConstants.TRANSACTION_ID))),
                    (Integer.parseInt(req.getParameter(NamesConstants.PORTFOLIO_ID))),
                    (req.getParameter(NamesConstants.SECURITY_SYMBOL)),
                    (Integer.parseInt(req.getParameter(NamesConstants.TRANSACTION_TYPE))),
                    (Integer.parseInt(req.getParameter(NamesConstants.AMOUNT))),
                    (Double.parseDouble(req.getParameter(NamesConstants.PRICE))),
                    LocalDate.parse(req.getParameter(NamesConstants.DATE)));
            securityService.updateTransaction(transaction, parameters);
        } catch (ServiceException e) {
            LOGGER.error("UpdateTransactionPostCommand error: ", e);
            throw new ServletException("Incorrect values.");
        }
        req.setAttribute(NamesConstants.REDIRECT_LINK, CommandsConstants.GET_ALL_PORTFOLIO_SECURITIES);
        req.getSession().setAttribute(NamesConstants.REQUEST_METHOD, Constants.GET_METHOD);
        RoutingUtils.forwardToPage(JspPageName.REDIRECT_PAGE, req, resp);
    }
}