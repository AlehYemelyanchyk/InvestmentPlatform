package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.Constants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.entity.User;
import by.epam.investmentplatform.service.exceptions.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GetAllUsersGetCommandImpl extends AbstractCommandExecutor {

    @Override
    protected RequestDispatcher getDispatcher(HttpServletRequest request) throws ServiceException {
        try {
            List<User> allUsers = USER_SERVICE.getAllUsers();
            request.setAttribute(Constants.USERS_LIST, allUsers);
        } catch (ServiceException e) {
            LOGGER.error("Get all users error", e);
        }
        return request.getRequestDispatcher(JspPageName.GET_ALL_USERS_PAGE);
    }
}
