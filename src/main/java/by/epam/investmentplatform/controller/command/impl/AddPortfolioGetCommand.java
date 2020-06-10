package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddPortfolioGetCommand extends AbstractCommandExecutor {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RoutingUtils.forwardToPage(JspPageName.ADD_PORTFOLIO_PAGE, req, resp);
    }
}
