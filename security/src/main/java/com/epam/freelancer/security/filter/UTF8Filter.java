package com.epam.freelancer.security.filter;

import javax.servlet.*;
import java.io.IOException;

public class UTF8Filter implements Filter {
	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws ServletException, IOException
	{
		req.setCharacterEncoding("UTF-8");
		chain.doFilter(req, resp);
	}

	public void init(FilterConfig config) throws ServletException {

	}
}