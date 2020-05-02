package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.Constants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.service.impl.ServiceFactory;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SignUpGetCommandImpl extends AbstractCommandExecutor {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<String> countries = ServiceFactory.getInstance().getUserService().getAllCountries();
        req.getSession().setAttribute(Constants.COUNTRIES_LIST, countries);
        RoutingUtils.forwardToPage(JspPageName.SIGN_UP_PAGE, req, resp);
    }
}
