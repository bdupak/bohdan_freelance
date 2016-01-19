package com.epam.freelancer.database.dao.jdbc;


import com.epam.freelancer.database.dao.FeedbackDao;
import com.epam.freelancer.database.model.Feedback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ������ on 17.01.2016.
 */
public class FeedbackJdbcDao extends GenericJdbcDao<Feedback, Integer> implements FeedbackDao {
    public FeedbackJdbcDao(Class<Feedback> class1) throws Exception {
        super(class1);
    }

    @Override
    public List<Feedback> getFeedbacksByDevId(Integer id) {
        String query = "SELECT * FROM " + table + " WHERE dev_id = ?";
        return getFeedbacksByQuery(query, id);
    }

    @Override
    public List<Feedback>  getFeedbacksByCustId(Integer id) {
        String query = "SELECT * FROM " + table + " WHERE cust_id = ?";
        return getFeedbacksByQuery(query, id);
    }

    private List<Feedback>  getFeedbacksByQuery(String query, Integer id) {
        List<Feedback> feedbacks = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection
                     .prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet set = statement.executeQuery()) {
                while (set.next()) {
                    Feedback test;
                    test = transformer.getObject(set);
                    feedbacks.add(test);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return feedbacks;
    }
}
