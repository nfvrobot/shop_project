package by.shopproject.filter;

import by.shopproject.dto.CustomerLoginDto;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest instanceof HttpServletRequest && servletResponse instanceof HttpServletResponse) {
            if (isUserExists(servletRequest) || isLanguage(servletRequest) || isLoginPage(servletRequest) | isCreatePage(servletRequest)) {
                allowAccess(servletRequest, servletResponse, filterChain);
            } else {
                goBack(servletResponse);
            }
        } else {
            allowAccess(servletRequest, servletResponse, filterChain);
        }
    }

    private boolean isLanguage(ServletRequest servletRequest) {
        return ((HttpServletRequest) servletRequest).getRequestURI().contains("language");
    }

    private boolean isLoginPage(ServletRequest servletRequest) {
        return ((HttpServletRequest) servletRequest).getRequestURI().contains("login");
    }

    private void goBack(ServletResponse servletResponse) throws IOException {
        ((HttpServletResponse) servletResponse).sendRedirect("/login");
    }


    private boolean isCreatePage(ServletRequest servletRequest) {
        return ((HttpServletRequest) servletRequest).getRequestURI().contains("customer-save");
    }

    private void allowAccess(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private boolean isUserExists(ServletRequest servletRequest) {
        CustomerLoginDto customerLoginDto = (CustomerLoginDto) ((HttpServletRequest) servletRequest).getSession().getAttribute("currentUser");
        return customerLoginDto != null;
    }
}
