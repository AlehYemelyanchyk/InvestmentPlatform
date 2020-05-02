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

public class UpdateTransactionGetCommandImpl extends AbstractCommandExecutor {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter(Constants.TRANSACTION_ID));
        try {
            Transaction transaction = SECURITY_SERVICE.getTransaction(id);
            req.setAttribute(Constants.TRANSACTION, transaction);
        } catch (ServiceException e) {
            LOGGER.error("Get portfolio error: ", e);
            throw new ServiceException("Incorrect values");
        }
        RoutingUtils.forwardToPage(JspPageName.UPDATE_TRANSACTION_PAGE, req, resp);
    }
}
