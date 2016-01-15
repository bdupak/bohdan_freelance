package com.epam.freelancer.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AuthenticationCustomerFilter")
public class AuthenticationCustomerFilter implements Filter {

    public static final Logger LOG = Logger.getLogger(AuthenticationCustomerFilter.class);

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String path = req.getServletPath();
        HttpSession session = req.getSession(false);

        if(path.endsWith("customer")) {
            if (session == null || !"customer".equals(session.getAttribute("role"))) {
                LOG.info("Access denied.");
                // path to home page
                res.sendRedirect("/home");
            }else {
                chain.doFilter(req, res);
            }
        }else
            chain.doFilter(req, res);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
