package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.controller.command.JspPageName;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

public class AddPortfolioGetCommandImpl extends AbstractCommandExecutor {

    @Override
    protected RequestDispatcher getDispatcher(HttpServletRequest request) {
        return request.getRequestDispatcher(JspPageName.ADD_PORTFOLIO_PAGE);
    }
}
