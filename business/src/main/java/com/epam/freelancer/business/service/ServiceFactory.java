package com.epam.freelancer.business.service;

import com.epam.freelancer.database.model.UserEntity;

public class ServiceFactory {

	public static <T extends UserEntity> Service<T, Integer> getService(
			String name)
	{
		if (name == null || name.isEmpty()) {
			return null;
		}

		Service<T, Integer> result = null;
		switch (name.toLowerCase()) {
//		case "student":
//			result = (Service<T, Integer>) new StudentService();
//			break;
//		case "admin":
//			result = (Service<T, Integer>) new AdminService();
//			break;
//		case "teacher":
//			result = (Service<T, Integer>) new TeacherService();
//			break;
		default:
			break;
		}
		return result;
	}

}
