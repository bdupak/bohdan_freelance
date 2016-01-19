package com.epam.freelancer.database.dao;

import com.epam.freelancer.database.persistence.ConnectionPool;

import java.util.List;

public interface GenericDao<T, ID> {

	T save(T entity);

	T update(T entity);

	void delete(T entity);

	T getById(ID id);

	List<T> getAll();

    void setConnectionPool(ConnectionPool connectionPool);
}