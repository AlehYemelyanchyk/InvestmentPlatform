package by.epam.investmentplatform.service.factory;

import by.epam.investmentplatform.service.PortfolioService;
import by.epam.investmentplatform.service.SecurityService;
import by.epam.investmentplatform.service.UserService;
import by.epam.investmentplatform.service.impl.PortfolioServiceImpl;
import by.epam.investmentplatform.service.impl.SecurityServiceImpl;
import by.epam.investmentplatform.service.impl.UserServiceImpl;

public final class ServiceFactory {
    private static final ServiceFactory INSTANCE = new ServiceFactory();

    private final UserService userService = new UserServiceImpl();
    private final PortfolioService portfolioService = new PortfolioServiceImpl();
    private final SecurityService securityService = new SecurityServiceImpl();

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
