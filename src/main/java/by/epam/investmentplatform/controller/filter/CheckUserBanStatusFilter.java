package by.epam.investmentplatform.controller.filter;

import by.epam.investmentplatform.NamesConstants;
import by.epam.investmentplatform.controller.command.JspPageName;
import by.epam.investmentplatform.service.UserService;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.service.impl.ServiceFactory;
import by.epam.investmentplatform.util.RoutingUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebFilter(filterName = "CheckUserBanStatusFilter")
public class CheckUserBanStatusFilter extends AbstractFilter {

    public final UserService userService = ServiceFactory.getInstance().getUserService();

    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain filterChain) throws ServletException, IOException {
        List<Integer> bannedUsersIdList;
        try {
            bannedUsersIdList = userService.getBannedUsersIdList();
        } catch (ServiceException e) {
            LOGGER.error("CheckUserBanStatusFilter error: ", e);
            throw new ServletException("Something went wrong. Please, try later.");
        }

        if (req.getSession().getAttribute(NamesConstants.CURRENT_USER_ID) == null) {
            filterChain.doFilter(req, resp);
        } else {
            int userId = (int) req.getSession().getAttribute(NamesConstants.CURRENT_USER_ID);
            if (isBanned(bannedUsersIdList, userId)) {
                String requestUrl = req.getRequestURI();
                req.getSession().setAttribute(NamesConstants.REDIRECT_LINK, requestUrl);
                req.setAttribute(NamesConstants.ERROR_ATTRIBUTE, "Sorry, but your account was banned due a suspicious activity. For further information, please, contact our support team.");
                RoutingUtils.forwardToPage(JspPageName.ERROR_PAGE, req, resp);
            } else {
                filterChain.doFilter(req, resp);
            }
        }
    }

    private boolean isBanned(List<Integer> bannedIdList, int userId) {
        for (int bannedId : bannedIdList) {
            return userId == bannedId;
        }
        return false;
    }
}
