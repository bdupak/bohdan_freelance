package com.epam.freelancer.security.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class AuthenticationCustomerFilter implements Filter {

	public static final Logger LOG = Logger
			.getLogger(AuthenticationCustomerFilter.class);

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws ServletException, IOException
	{
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String path = req.getServletPath();
		HttpSession session = req.getSession();

		if (path.endsWith("customer")) {
			if (session == null
					|| !"customer".equals(session.getAttribute("role")))
			{
				LOG.info("Access denied.");
				// path to home page
				res.sendRedirect("/home");
			} else {
				chain.doFilter(req, res);
			}
		} else
			chain.doFilter(req, res);
	}

	public void init(FilterConfig config) throws ServletException {

	}

}
