package com.epam.freelancer.security.provider;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.freelancer.context.ApplicationContext;
import com.epam.freelancer.model.UserEntity;
import com.epam.freelancer.service.UserService;
import com.epam.freelancer.util.CookieManager;
import com.epam.freelancer.util.EnvironmentVariablesManager;

public class AuthenticationProvider {
	private CookieManager cookieManager;
	private String sessinUserName;

	public AuthenticationProvider() {
		cookieManager = (CookieManager) ApplicationContext.getInstance()
				.getBean("cookieManager");
		sessinUserName = EnvironmentVariablesManager.getInstance().getVar(
				"session.user");
	}

	public void checkAutoAuthentication(String cookieName,
			UserService<? extends UserEntity> service,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException
	{
		String uuid = cookieManager.getCookieValue(request, cookieName);

		if (uuid != null) {
			UserEntity user = service.getByUUID(uuid);
			if (user != null)
				request.getSession().setAttribute(sessinUserName, user);
		}
	}

	public boolean provideAccess(String cookieName, String type, String url,
			UserService<? extends UserEntity> service,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException
	{
		UserEntity user = (UserEntity) request.getSession().getAttribute(
				sessinUserName);
		if (user != null) {
			if (checkUserEntityType(user, type))
				return true;
			else
				response.sendError(403);
			return false;
		} else {
			String uuid = cookieManager.getCookieValue(request, cookieName);

			if (uuid != null) {
				user = service.getByUUID(uuid);

				if (user != null) {
					request.getSession().setAttribute(sessinUserName, user);
					return true;
				} else {
					cookieManager.removeCookie(response, cookieName);
				}
			} else
				response.sendRedirect(request.getContextPath() + "/" + url);
		}

		return false;
	}

	private boolean checkUserEntityType(Object user, String type) {
		boolean result = false;
		switch (type) {
//		case "student":
//			if (user instanceof StudentEntity)
//				result = true;
//			break;
//		case "admin":
//			if (user instanceof AdminEntity)
//				result = true;
//			break;
//		case "teacher":
//			if (user instanceof TeacherEntity)
//				result = true;
//			break;
		default:
			result = false;
			break;
		}
		return result;
	}

	public void loginAndRemember(HttpServletResponse response,
			String cookieName, UserEntity entity)
	{
		String uuid = UUID.randomUUID().toString();
		cookieManager.addCookie(response, cookieName, uuid, 60 * 60 * 24 * 30);
		entity.setUuid(uuid);
	}

	public void invalidateUserCookie(HttpServletResponse response,
			String cookieName, UserEntity entity)
	{
		cookieManager.removeCookie(response, cookieName);
		entity.setUuid(null);
	}
}
