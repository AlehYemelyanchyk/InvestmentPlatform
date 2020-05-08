package by.epam.investmentplatform.controller;

import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/errorServlet")
public class ErrorController extends HttpServlet {
    private static final long serialVersionUID = -31640364473886345L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        RoutingUtils.forwardToPage(JspPageName.ERROR_PAGE, req, resp);
    }
}
