package by.epam.investmentplatform.service;

import by.epam.investmentplatform.entity.Security;
import by.epam.investmentplatform.service.exceptions.ServiceException;

import java.util.List;

public interface SecurityService {
    List<Security> getAllSecurities() throws ServiceException;

    List<Security> getSecuritiesByExchange() throws ServiceException;

    List<Security> getSecuritiesByType() throws ServiceException;
}
