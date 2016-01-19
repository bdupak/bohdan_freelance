package com.epam.freelancer.database.dao;

import com.epam.freelancer.database.model.Developer;
import com.epam.freelancer.database.model.Technology;

import java.util.List;

/**
 * Created by Максим on 20.01.2016.
 */
public interface DevMTMTechDao extends  GenericManyToManyDao<Developer, Technology, Integer>{
    public List<Technology> getTechnologiesByDevId(Integer id);
}
