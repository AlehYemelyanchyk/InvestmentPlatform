package by.epam.investmentplatform.util;

import by.epam.investmentplatform.Constants;
import by.epam.investmentplatform.controller.command.JspPageName;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public final class RoutingUtils {
    public static void forwardToPage(String jspPage, HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute(Constants.CURRENT_PAGE, jspPage);
        req.getRequestDispatcher(JspPageName.PAGE_TEMPLATE_PAGE).forward(req, resp);
    }
}
