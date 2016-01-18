package com.epam.freelancer.business.service;

import com.epam.freelancer.business.util.ValidationParametersBuilder;
import com.epam.freelancer.database.dao.DeveloperDao;
import com.epam.freelancer.database.dao.jdbc.DAOManager;
import com.epam.freelancer.database.model.Developer;

import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Максим on 18.01.2016.
 */
public class DeveloperService extends UserService<Developer> {

    public DeveloperService() {
        super(DAOManager.getInstance().getDAO(DeveloperDao.class.getSimpleName()));
        DAOManager daoManager = DAOManager.getInstance();
        genericDao.setDataSource(daoManager.getDataSource());
    }

    @Override
    public Developer create(Map<String, String[]> data) {
        if (!isDataValid(prepareData(data)))
            throw new RuntimeException("Validation exception");

        Developer entity = new Developer();
        String[] value = data.get("first_name");
        entity.setFname(value != null ? value[0] : null);
        value = data.get("last_name");
        entity.setLname(value != null ? value[0] : null);
        value = data.get("email");
        entity.setEmail(value != null ? value[0] : null);
        value = data.get("lang");
        entity.setLang(value != null ? value[0] : "en");
        value = data.get("uuid");
        entity.setUuid(value != null ? value[0] : null);
        value = data.get("reg_url");
        entity.setRegUrl(value != null ? value[0] : null);
        entity.setRegDate(new Date(new java.util.Date().getTime()));
        value = data.get("password");
        try {
            entity.setPassword(value != null ? encodePassword(value[0]) : null);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return genericDao.save(entity);
    }

    public void deleteDeveloper(Developer Developer){
        genericDao.delete(Developer);
    }

    public Developer updateDeveloper(Developer Developer){
        return genericDao.update(Developer);
    }

    public Developer getDeveloper(Integer id){
        return genericDao.getById(id);
    }

    public List<Developer> getAllDevelopers(){
        return genericDao.getAll();
    }

    private Map<ValidationParametersBuilder.Parameters, String> prepareData(Map<String, String[]> data) {
        Map<ValidationParametersBuilder.Parameters, String> map = new HashMap<>();
        map.put(ValidationParametersBuilder.createParameters(false).maxLength(50)
                        .minLength(1),
                data.get("first_name") == null ? null
                        : data.get("first_name")[0]);
        map.put(ValidationParametersBuilder.createParameters(false).maxLength(50)
                        .minLength(1),
                data.get("last_name") == null ? null : data.get("last_name")[0]);
        map.put(ValidationParametersBuilder.createParameters(false).maxLength(50)
                        .minLength(1),
                data.get("lang") == null ? null : data.get("lang")[0]);
        map.put(ValidationParametersBuilder.createParameters(false).maxLength(50)
                        .minLength(1),
                data.get("uuid") == null ? null : data.get("uuid")[0]);
        map.put(ValidationParametersBuilder.createParameters(false).maxLength(140)
                        .minLength(1),
                data.get("password") == null ? null : data.get("password")[0]);
        map.put(ValidationParametersBuilder
                        .createParameters(false)
                        .maxLength(50)
                        .pattern(
                                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]+)"),
                data.get("email") == null ? null : data.get("email")[0]);

        return map;
    }
}
