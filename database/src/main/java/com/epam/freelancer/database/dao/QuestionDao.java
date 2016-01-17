package com.epam.freelancer.database.dao;


import com.epam.freelancer.database.model.Question;

import java.util.List;

public interface QuestionDao extends GenericDao<Question, Integer>{
	List<Question> getByTechnology(Integer id);

	List<Question> getByAdminId(Integer id);
}
