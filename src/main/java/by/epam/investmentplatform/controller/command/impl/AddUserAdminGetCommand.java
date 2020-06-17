package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.Constants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AddUserAdminGetCommand extends AbstractCommandExecutor {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<String> countries;
        try {
            countries = userService.getAllCountries();
        } catch (ServiceException e) {
            LOGGER.error("AddUserAdminGetCommand error: ", e);
            throw new ServiceException("Incorrect values.");
        }
        req.getSession().setAttribute(Constants.COUNTRIES_LIST, countries);
        RoutingUtils.forwardToPage(JspPageName.ADD_USER_PAGE, req, resp);
    }
}
