package com.epam.freelancer.database.model;

public interface BaseEntity<ID> {
	public ID getId();

	public void setId(ID id);
}
