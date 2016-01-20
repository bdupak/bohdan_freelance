package com.epam.freelancer.database.dao.jdbc;


import com.epam.freelancer.database.dao.DeveloperQADao;
import com.epam.freelancer.database.model.DeveloperQA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by ������ on 17.01.2016.
 */
public class DeveloperQAJdbcDao extends GenericJdbcDao<DeveloperQA, Integer> implements DeveloperQADao {
    public DeveloperQAJdbcDao() throws Exception {
        super(DeveloperQA.class);
    }

    @Override
    public DeveloperQA getDevQAByDevId(Integer id) {
        String query = "SELECT * FROM " + table + " WHERE dev_id = ?";
        DeveloperQA devQA = null;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection
                     .prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet set = statement.executeQuery()) {
                if (set.next()) {
                    devQA = transformer.getObject(set);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return devQA;
    }
}
