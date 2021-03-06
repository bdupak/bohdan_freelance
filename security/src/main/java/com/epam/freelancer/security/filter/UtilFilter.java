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

import org.apache.log4j.Logger;

public class UtilFilter implements Filter {
	private final static Logger LOG = Logger.getLogger(UtilFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException
	{
		LOG.info(getClass().getSimpleName() + " - " + "Filter");
		HttpServletRequest req = (HttpServletRequest) request;
		req.setCharacterEncoding("UTF-8");

		String path = req.getRequestURI().substring(
				req.getContextPath().length());
		if (path.endsWith(".jsp"))
			((HttpServletResponse) response).sendRedirect("/home");

		if (path.startsWith("/front/") || path.startsWith("/resources/")) {
			chain.doFilter(request, response);
		} else {
			request.getRequestDispatcher("/front/" + path).forward(request,
					response);
		}
	}

	@Override
	public void destroy() {

	}

}
