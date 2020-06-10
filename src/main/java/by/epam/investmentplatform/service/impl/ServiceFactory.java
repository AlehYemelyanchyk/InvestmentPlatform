package by.epam.investmentplatform.service.impl;

import by.epam.investmentplatform.service.PortfolioService;
import by.epam.investmentplatform.service.SecurityService;
import by.epam.investmentplatform.service.UserService;

public final class ServiceFactory {
    private static final ServiceFactory INSTANCE = new ServiceFactory();

    private final UserService userService = new DefaultUserService();
    private final PortfolioService portfolioService = new DefaultPortfolioService();
    private final SecurityService securityService = new DefaultSecurityService();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return INSTANCE;
    }

    public UserService getUserService() {
        return userService;
    }

    public PortfolioService getPortfolioService() {
        return portfolioService;
    }

    public SecurityService getSecurityService() {
        return securityService;
    }
}
