package com.epam.freelancer.business.service;

import com.epam.freelancer.business.util.ValidationParametersBuilder;
import com.epam.freelancer.database.dao.TestDao;
import com.epam.freelancer.database.dao.jdbc.DAOManager;
import com.epam.freelancer.database.model.Test;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Максим on 18.01.2016.
 */
public class TestService extends GenericService<Test, Integer> {

	public TestService() {
		super(DAOManager.getInstance().getDAO(TestDao.class.getSimpleName()));
		DAOManager daoManager = DAOManager.getInstance();
		genericDao.setConnectionPool(daoManager.getConnectionPool());
	}

	@Override
	public Test create(Map<String, String[]> data) {
		if (!isDataValid(prepareData(data)))
			throw new RuntimeException("Validation exception");

		Test test = new Test();
		String[] value = data.get("name");
		test.setName(value != null ? value[0] : null);
		value = data.get("tech_id");
		Integer integer = value != null ? Integer.parseInt(value[0]) : null;
		if (integer == null)
			throw new RuntimeException("Validation exception");
		test.setTechId(integer);
		value = data.get("admin_id");
		integer = value != null ? Integer.parseInt(value[0]) : null;
		if (integer == null)
			throw new RuntimeException("Validation exception");
		test.setAdminId(integer);
		value = data.get("pass_score");
		integer = value != null ? Integer.parseInt(value[0]) : null;
		if (integer == null)
			throw new RuntimeException("Validation exception");
		test.setPassScore(integer);
		value = data.get("sec_per_quest");
		integer = value != null ? Integer.parseInt(value[0]) : null;
		if (integer == null)
			throw new RuntimeException("Validation exception");
		test.setSecPerQuest(integer);

		test = genericDao.save(test);

		return test;
	}

	private Map<ValidationParametersBuilder.Parameters, String> prepareData(
			Map<String, String[]> data)
	{
		Map<ValidationParametersBuilder.Parameters, String> map = new HashMap<>();
		map.put(ValidationParametersBuilder.createParameters(false)
				.maxLength(50).minLength(1), data.get("name") == null ? null
				: data.get("name")[0]);
		map.put(ValidationParametersBuilder.createParameters(true).min(1.00),
				data.get("tech_id") == null ? null : data.get("tech_id")[0]);
		map.put(ValidationParametersBuilder.createParameters(true).min(1.00),
				data.get("sec_per_quest") == null ? null : data
						.get("sec_per_quest")[0]);
		map.put(ValidationParametersBuilder.createParameters(true).min(1.00),
				data.get("admin_id") == null ? null : data.get("admin_id")[0]);
		map.put(ValidationParametersBuilder.createParameters(true)
				.isInteger(true).max(5.00).min(1.00),
				data.get("pass_score") == null ? null
						: data.get("pass_score")[0]);
		return map;
	}

	public List<Test> findTestsByTechnologyId(Integer id) {
		return ((TestDao) genericDao).getTestsByTechId(id);
	}

	public List<Test> findTestsByAdminId(Integer id) {
		return ((TestDao) genericDao).getTestsByAdminId(id);
	}
}