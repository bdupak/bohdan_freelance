package com.epam.freelancer.database.persistence;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtils {


    public static final Logger LOG = Logger.getLogger(PropertyUtils.class);

    public static Properties readProperties(String fileName) {
        Properties props = new Properties();

        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream stream = loader.getResourceAsStream(fileName);
        try {
            LOG.info("get property from " + fileName);
            props.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
            LOG.warn("load property exception " + e);
        }

        return props;
    }
}