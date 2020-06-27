package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.NamesConstants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.entity.User;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UpdateUserGetCommand extends AbstractCommandExecutor {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            List<String> countries = userService.getAllCountries();
            req.getSession().setAttribute(NamesConstants.COUNTRIES_LIST, countries);

            int userId = (int) (req.getSession().getAttribute(NamesConstants.CURRENT_USER_ID));
            User user = userService.getUser(userId);
            req.setAttribute(NamesConstants.CURRENT_USER, user);
        } catch (ServiceException e) {
            LOGGER.error("UpdateUserGetCommand error: ", e);
            throw new ServletException("Incorrect values.");
        }
        RoutingUtils.forwardToPage(JspPageName.UPDATE_USER_PAGE, req, resp);
    }
}