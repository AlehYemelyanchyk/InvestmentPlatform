package by.epam.investmentplatform.util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public final class RoutingUtils {
    public static void forwardToPage(String jspPage, HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("currentPage", "page/" + jspPage);
        req.getRequestDispatcher("/WEB-INF/JSP/page-template.jsp").forward(req, resp);
    }
}
