package com.epam.freelancer.database.dao;

import com.epam.freelancer.database.model.Developer;
import com.epam.freelancer.database.model.Ordering;

import java.util.List;

/**
 * Created by Максим on 18.01.2016.
 */
public interface WorkerManyToManyDao extends  GenericManyToManyDao<Developer, Ordering, Integer> {
    List<Ordering> getPortfolio(Integer devId);
    List<Ordering> getOrdersByDevId(Integer devId);
    List<Developer> getDevsByOrderingId(Integer orderId);

}
