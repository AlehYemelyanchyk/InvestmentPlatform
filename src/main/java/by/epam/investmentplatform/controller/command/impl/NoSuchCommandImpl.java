package by.epam.investmentplatform.controller.command.impl;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

public class NoSuchCommandImpl extends AbstractCommandExecutor {
    private static final String JSP_PATH = "/WEB-INF/jsp/page/error.jsp";
    @Override
    protected RequestDispatcher getDispatcher(HttpServletRequest request) {
        return request.getRequestDispatcher(JSP_PATH);
    }
}
