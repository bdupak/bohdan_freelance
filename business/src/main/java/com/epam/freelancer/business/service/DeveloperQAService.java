package com.epam.freelancer.business.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import com.epam.freelancer.business.util.ValidationParametersBuilder;
import com.epam.freelancer.database.dao.DeveloperQADao;
import com.epam.freelancer.database.dao.jdbc.DAOManager;
import com.epam.freelancer.database.model.DeveloperQA;

/**
 * Created by Максим on 18.01.2016.
 */
public class DeveloperQAService extends GenericService<DeveloperQA, Integer> {
    public DeveloperQAService() {
        super(DAOManager.getInstance().getDAO(DeveloperQADao.class.getSimpleName()));
        DAOManager daoManager = DAOManager.getInstance();
        genericDao.setDataSource(daoManager.getDataSource());
    }

    @Override
    public DeveloperQA create(Map<String, String[]> data) {
        if (!isDataValid(prepareData(data)))
            throw new RuntimeException("Validation exception");

        DeveloperQA developerQA = new DeveloperQA();
        String[] value = data.get("dev_id");
        Integer integer = value != null ? Integer.parseInt(value[0]) : null;
        developerQA.setDevId(integer);
        value = data.get("tech_id");
        integer = value != null ? Integer.parseInt(value[0]) : null;
        developerQA.setTechId(integer);
        value = data.get("rate");
        Double rate = value != null ? Double.parseDouble(value[0]) : null;
        developerQA.setRate(rate);
        developerQA.setExpire(new Date(new java.util.Date().getTime()));
        developerQA.setIsExpire(false);
        developerQA = genericDao.save(developerQA);

        return developerQA;
    }

    public void deleteDeveloperQA(DeveloperQA developerQA){
        genericDao.delete(developerQA);
    }

    public DeveloperQA updateDeveloperQA(DeveloperQA developerQA){
        return genericDao.update(developerQA);
    }

    private Map<ValidationParametersBuilder.Parameters, String> prepareData(Map<String, String[]> data) {
        Map<ValidationParametersBuilder.Parameters, String> map = new HashMap<>();
        map.put(ValidationParametersBuilder.createParameters(true).isInteger(true).min(1.00),
                data.get("dev_id") == null ? null : data.get("dev_id")[0]);
        map.put(ValidationParametersBuilder.createParameters(true).isInteger(true).min(1.00),
                data.get("tech_id") == null ? null : data.get("tech_id")[0]);
        return map;
    }
}
