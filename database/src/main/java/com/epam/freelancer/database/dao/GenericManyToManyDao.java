package com.epam.freelancer.database.dao;


import com.epam.freelancer.database.model.BaseEntity;

import javax.sql.DataSource;
import java.util.List;

public interface GenericManyToManyDao<F extends BaseEntity<ID>, S extends BaseEntity<ID>, ID>
{
	List<S> getBasedOnFirst(ID firstId);

	List<F> getBasedOnSecond(ID secondId);

	void saveContact(ID firstId, ID secondId);

	public void setDataSource(DataSource dataSource);
}
