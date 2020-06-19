package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.Constants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.entity.Security;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class GetAllSecuritiesGetCommand extends AbstractCommandExecutor {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Security> securities;

        try {
            securities = securityService.getAllSecurities();
        }  catch (ServiceException e) {
            LOGGER.error("GetAllSecuritiesGetCommand error: ", e);
            throw new ServletException("Incorrect values.");
        }
        List<String> types = listOfTypes(securities);
        Map<String, List<Security>> securitiesByType = getSecuritiesByType(securities, types);
        for (Map.Entry<String, List<Security>> entry : securitiesByType.entrySet()) {
            String type = entry.getKey();
            List<Security> securityList = entry.getValue();
            req.setAttribute(type, securityList);
            int pagesAmount = getPagesAmount(securityList.size());
            req.setAttribute(type + "_" + Constants.PAGES_AMOUNT, pagesAmount);
        }
        req.setAttribute(Constants.SECURITIES_LIST, securitiesByType);
        req.setAttribute(Constants.MAX_ITEMS_PER_PAGE, Constants.ITEMS_PER_PAGE);
        RoutingUtils.forwardToPage(JspPageName.GET_ALL_SECURITIES_PAGE, req, resp);
    }

    private List<String> listOfTypes(List<Security> securities) {
        Set<String> types = new HashSet<>();
        for (Security security : securities) {
            types.add(security.getSecurityType());
        }
        return new ArrayList<>(types);
    }

    private Map<String, List<Security>> getSecuritiesByType(List<Security> securities, List<String> types) {
        Map<String, List<Security>> securitiesByType = new HashMap<>();
        for (String type : types) {
            List<Security> newSecurityList = new ArrayList<>();
            for (Security security : securities) {
                if (security.getSecurityType().equals(type)) {
                    newSecurityList.add(security);
                }
            }
            securitiesByType.put(type, newSecurityList);
        }
        return securitiesByType;
    }
}