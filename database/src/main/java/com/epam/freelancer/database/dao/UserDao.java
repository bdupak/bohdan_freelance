package com.epam.freelancer.database.dao;

import com.epam.freelancer.database.model.UserEntity;

public interface UserDao<T extends UserEntity> extends GenericDao<T, Integer> {
	T getByEmail(String email);

	boolean emailAvailable(String email);

	boolean uuidAvailable(String uuid);

	T getByUUID(String uuid);
}
