package by.epam.investmentplatform.controller.command.impl;

import by.epam.investmentplatform.Constants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.entity.Security;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetAllPortfolioSecuritiesGetCommandImpl extends AbstractCommandExecutor {

    @Override
    protected void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int portfolioId = Integer.parseInt(req.getParameter(Constants.THE_PORTFOLIO_ID));
        String portfolioName = req.getParameter(Constants.THE_PORTFOLIO_NAME);
        List<Security> allPortfolioSecurities = SECURITY_SERVICE.getAllPortfolioSecurities(portfolioId);
        req.setAttribute(Constants.THE_PORTFOLIO_ID, portfolioId);
        req.setAttribute(Constants.THE_PORTFOLIO_NAME, portfolioName);
        req.setAttribute(Constants.PORTFOLIO_SECURITIES, allPortfolioSecurities);
        RoutingUtils.forwardToPage(JspPageName.GET_ALL_PORTFOLIO_SECURITIES, req, resp);
    }
}