package com.epam.freelancer.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


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
        ((HttpServletResponse) response).sendRedirect("/home");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
