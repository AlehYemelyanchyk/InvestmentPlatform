package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.CommandsConstants;
import by.epam.investmentplatform.Constants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.entity.Transaction;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

public class AddSecurityToPortfolioPostCommand extends AbstractCommandExecutor {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Transaction transaction = new Transaction(
                Integer.parseInt(req.getParameter(Constants.PORTFOLIO_ID)),
                req.getParameter(Constants.SECURITY_SYMBOL),
                Integer.parseInt(req.getParameter(Constants.TRANSACTION_TYPE)),
                Integer.parseInt(req.getParameter(Constants.AMOUNT)),
                Double.parseDouble(req.getParameter(Constants.PRICE)),
                Date.valueOf(req.getParameter(Constants.DATE)));
        try {
            SECURITY_SERVICE.saveTransaction(transaction);
        } catch (ServiceException e) {
            LOGGER.error(e.getMessage());
            throw new ServiceException("Incorrect values");
        }
        req.setAttribute(Constants.REDIRECT_LINK, CommandsConstants.GET_ALL_SECURITIES_COMMAND);
        RoutingUtils.forwardToPage(JspPageName.REDIRECT_PAGE, req, resp);
    }
}
