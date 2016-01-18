package com.epam.freelancer.business.context;

import com.epam.freelancer.business.service.AdminService;
import com.epam.freelancer.business.service.DeveloperService;
import com.epam.freelancer.database.dao.*;
import com.epam.freelancer.database.dao.jdbc.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class ApplicationContext {
    private Map<String, Object> beans = new ConcurrentHashMap<>();

    private ApplicationContext() {
    }

    private void initContext() {
        initDAO();
        DAOManager daoManager = DAOManager.getInstance();

        DeveloperService developerService = new DeveloperService();
        developerService.setWorkerMTMDao(daoManager.getManyToManyDAO(WorkerManyToManyDao.class.getSimpleName()));
        addBean("developerService", developerService);
        AdminService adminService = new AdminService();
        addBean("adminService", adminService);
    }

    private void initDAO() {
        DAOManager daoManager = DAOManager.getInstance();
        try {
            daoManager.addDao(AdminDao.class.getSimpleName(), new AdminJdbcDao());
            daoManager.addDao(WorkerManyToManyDao.class.getSimpleName(), new WorkerManyToManyJdbcDao());
            daoManager.addDao(TestDao.class.getSimpleName(), new TestJdbcDao());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static final class ApplicationContextHolder {
        private static final ApplicationContext INSTANCE = new ApplicationContext();

        static {
            INSTANCE.initContext();
        }
    }

    public static ApplicationContext getInstance() {
        return ApplicationContextHolder.INSTANCE;
    }

    public Object getBean(String key) {
        return beans.get(key);
    }

    public Object addBean(String key, Object bean) {
        return beans.put(key, bean);
    }

}
