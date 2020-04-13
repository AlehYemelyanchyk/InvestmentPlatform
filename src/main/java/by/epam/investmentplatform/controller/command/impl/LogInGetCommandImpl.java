package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.controller.command.JspPageName;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

public class LogInGetCommandImpl extends AbstractCommandExecutor {

    @Override
    protected RequestDispatcher getDispatcher(HttpServletRequest request) {
        return request.getRequestDispatcher(JspPageName.LOG_IN_PAGE);
    }
}
