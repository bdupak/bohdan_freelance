package com.epam.freelancer.database.dao;


import com.epam.freelancer.database.model.Feedback;

import java.util.List;

/**
 * Created by ������ on 17.01.2016.
 */
public interface FeedbackDao extends GenericDao<Feedback, Integer> {

    public List<Feedback> getFeedbacksByDevId(Integer id);

    public List<Feedback>  getFeedbacksByCustId(Integer id);

}
