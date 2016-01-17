package com.epam.freelancer.security.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;


/**
 * Filter which forbids users contact directly to *.jsp files
 */
public class JSPFilter implements Filter {

    public static final Logger LOG = Logger.getLogger(JSPFilter.class);


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 'home' the servlet which maps to main page
        /*((HttpServletResponse) response).sendRedirect("/");*/
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
