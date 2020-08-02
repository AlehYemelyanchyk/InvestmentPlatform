package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.NamesConstants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.entity.Transaction;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateTransactionWindowPostCommand extends AbstractCommand {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter(NamesConstants.TRANSACTION_ID));
            String portfolioName = req.getParameter(NamesConstants.PORTFOLIO_NAME);
            Transaction transaction = securityService.getTransaction(id);
            req.setAttribute(NamesConstants.TRANSACTION, transaction);
            req.setAttribute(NamesConstants.PORTFOLIO_NAME, portfolioName);
        } catch (NullPointerException e) {
            LOGGER.error("UpdateTransactionWindowPostCommand missing value error: ", e);
        } catch (ServiceException e) {
            LOGGER.error("UpdateTransactionWindowPostCommand error: ", e);
            throw new ServletException("Incorrect values.");
        }
        RoutingUtils.forwardToPage(JspPageName.UPDATE_TRANSACTION_PAGE, req, resp);
    }
}
