package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.Constants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.service.factory.ServiceFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class SignUpGetCommandImpl extends AbstractCommandExecutor {

    @Override
    protected RequestDispatcher getDispatcher(HttpServletRequest request) throws ServiceException {
        List<String> countries = ServiceFactory.getInstance().getUserService().getAllCountries();
        request.setAttribute(Constants.COUNTRIES_LIST, countries);
        return request.getRequestDispatcher(JspPageName.SIGN_UP_PAGE);
    }
}
