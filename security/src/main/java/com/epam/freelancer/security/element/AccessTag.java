package com.epam.freelancer.security.element;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.epam.freelancer.database.model.Admin;
import com.epam.freelancer.database.model.Customer;
import com.epam.freelancer.database.model.Developer;
import com.epam.freelancer.database.model.UserEntity;

public class AccessTag extends SimpleTagSupport {
	private String role;

	@Override
	public void doTag() throws JspException, IOException {
		if (checkAccess())
			allowShowBody();
	}

	private boolean checkAccess() {
		String currentRole = getRole();
		if (role.equals("user"))
			return isUserAvailable(getRole());
		if (!role.startsWith("not_"))
			return currentRole.equals(role);
		return !role.substring(4).equals(currentRole);
	}

	private boolean isUserAvailable(String role) {
		switch (role) {
		case "developer":
		case "admin":
		case "customer":
			return true;
		default:
			return false;
		}
	}

	private String getRole() {
		String role = "";
		PageContext pageContext = (PageContext) getJspContext();
		HttpSession session = ((HttpServletRequest) pageContext.getRequest())
				.getSession();
		UserEntity user = (UserEntity) session.getAttribute("user");
		if (user instanceof Developer)
			role = "developer";
		if (user instanceof Admin)
			role = "admin";
		if (user instanceof Customer)
			role = "customer";
		if (user == null)
			role = "none";
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	private void allowShowBody() {
		try {
			PageContext pageContext = (PageContext) getJspContext();
			JspWriter out = pageContext.getOut();

			StringWriter sw = new StringWriter();
			JspFragment body = getJspBody();
			body.invoke(sw);

			out.println(sw.toString());
		} catch (IOException | JspException e) {
			e.printStackTrace();
		}
	}
}
