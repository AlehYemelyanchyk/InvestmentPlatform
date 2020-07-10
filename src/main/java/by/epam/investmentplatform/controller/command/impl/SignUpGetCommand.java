package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.NamesConstants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SignUpGetCommand extends AbstractCommand {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<String> countries;
        try {
            countries = userService.getAllCountries();
        } catch (ServiceException e) {
            LOGGER.error("SignUpGetCommand error: ", e);
            throw new ServletException("Incorrect values.");
        }
        req.getSession().setAttribute(NamesConstants.COUNTRIES_LIST, countries);
        RoutingUtils.forwardToPage(JspPageName.SIGN_UP_PAGE, req, resp);
    }
}
