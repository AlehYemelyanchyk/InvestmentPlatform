package by.epam.investmentplatform.service.impl;

import by.epam.investmentplatform.service.PortfolioService;
import by.epam.investmentplatform.service.SecurityService;
import by.epam.investmentplatform.service.UserService;

public final class ServiceFactory {
    private static final ServiceFactory INSTANCE = new ServiceFactory();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return INSTANCE;
    }

    public UserService getUserService() {
        return new DefaultUserService();
    }

    public PortfolioService getPortfolioService() {
        return new DefaultPortfolioService();
    }

    public SecurityService getSecurityService() {
        return new DefaultSecurityService();
    }
}
