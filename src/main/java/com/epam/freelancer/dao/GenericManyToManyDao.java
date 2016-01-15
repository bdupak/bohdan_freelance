package com.epam.freelancer.dao;

import java.util.List;

import javax.sql.DataSource;

import com.epam.freelancer.model.BaseEntity;

public interface GenericManyToManyDao<F extends BaseEntity<ID>, S extends BaseEntity<ID>, ID>
{
	List<S> getBasedOnFirst(ID firstId);

	List<F> getBasedOnSecond(ID secondId);

	void saveContact(ID firstId, ID secondId);

	public void setDataSource(DataSource dataSource);
}
