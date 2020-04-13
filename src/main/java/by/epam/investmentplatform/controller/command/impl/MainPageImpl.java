package by.epam.investmentplatform.controller.command.impl;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

public class MainPageImpl extends AbstractCommandExecutor {
    private static final String JSP_PATH = "/WEB-INF/jsp/main.jsp";

    @Override
    protected RequestDispatcher getDispatcher(HttpServletRequest request) {
        return request.getRequestDispatcher(JSP_PATH);
    }
}
