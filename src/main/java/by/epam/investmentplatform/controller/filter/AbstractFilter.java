package by.epam.investmentplatform.controller.filter;

import by.epam.investmentplatform.util.UrlUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AbstractFilter implements Filter {
    protected final Logger LOGGER = LogManager.getLogger(getClass());

    @Override
    public final void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String url = request.getRequestURI();
        if (UrlUtils.isMediaUrl(url) || UrlUtils.isStaticUrl(url)) {
            filterChain.doFilter(request, response);
        }
        doFilter(request, response, filterChain);
    }

    public abstract void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws IOException, ServletException;
}
