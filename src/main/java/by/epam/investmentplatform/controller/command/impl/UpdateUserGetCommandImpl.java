package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.Constants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.entity.User;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.service.impl.ServiceFactory;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UpdateUserGetCommandImpl extends AbstractCommandExecutor {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            List<String> countries = ServiceFactory.getInstance().getUserService().getAllCountries();
            req.getSession().setAttribute(Constants.COUNTRIES_LIST, countries);

            int userId = (int) (req.getSession().getAttribute(Constants.CURRENT_USER_ID));
            User user = USER_SERVICE.getUser(userId);
            req.setAttribute(Constants.CURRENT_USER, user);
        } catch (ServiceException e) {
            LOGGER.error("Get portfolio error: ", e);
            throw new ServiceException("Incorrect values");
        }
        RoutingUtils.forwardToPage(JspPageName.UPDATE_USER_PAGE, req, resp);
    }
}