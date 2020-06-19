package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.Constants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.entity.Security;
import by.epam.investmentplatform.model.SecurityPrice;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GetSecurityGetCommand extends AbstractCommandExecutor {

    private final static String OLD_FORMAT = "yyyy-MM-dd";
    private final static String NEW_FORMAT = "MMM-YY";

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String securitySymbol = req.getParameter(Constants.SECURITY_SYMBOL);
        if (securitySymbol == null) {
            securitySymbol = (String) req.getSession().getAttribute(Constants.SECURITY_SYMBOL);
        }
        Security security;
        List<SecurityPrice> securityPrices;
        try {
            security = securityService.getSecurity(securitySymbol);
            securityPrices = securityService.getSecurityPrices(securitySymbol);
        } catch (ServiceException e) {
            LOGGER.error("GetSecurityGetCommand error: ", e);
            throw new ServletException("Incorrect values.");
        }

        List<String> datesList = getDates(securityPrices);
        List<Double> pricesList = getPrices(securityPrices);
        pricesList.add(security.getCurrentPrice());

        req.getSession().setAttribute("DATES", datesList);
        req.getSession().setAttribute("PRICES", pricesList);
        req.setAttribute(Constants.SECURITY, security);
        req.setAttribute(Constants.SECURITY_PRICES_LIST, securityPrices);
        RoutingUtils.forwardToPage(JspPageName.GET_SECURITY_PAGE, req, resp);
    }

    private List<String> getDates(List<SecurityPrice> prices){
        List<String> dates = new ArrayList<>();
        for (SecurityPrice securityPrice : prices) {
            String oldDateString = securityPrice.getDate().toString();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(OLD_FORMAT);
            Date date = null;
            try {
                date = simpleDateFormat.parse(oldDateString);
            } catch (ParseException e) {
                LOGGER.error("GetSecurityGetCommand error: Convert date problem.");
            }
            simpleDateFormat.applyPattern(NEW_FORMAT);
            dates.add(simpleDateFormat.format(date));
        }
        return dates;
    }

    private List<Double> getPrices(List<SecurityPrice> prices) {
        List<Double> pricesList = new ArrayList<>();
        for (SecurityPrice securityPrice : prices) {
            pricesList.add(securityPrice.getPrice());
        }
        return pricesList;
    }
}