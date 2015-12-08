package app;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(
        urlPatterns = "*"
)
public class BetaTestersOnlyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        if (Boolean.TRUE.equals(Boolean.valueOf(httpRequest.getParameter("isBetaTester")))) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse) response).sendError(401);
        }
    }

    @Override
    public void destroy() {

    }
}
