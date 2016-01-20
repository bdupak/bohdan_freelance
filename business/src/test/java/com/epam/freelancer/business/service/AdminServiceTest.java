package com.epam.freelancer.business.service;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.junit.Test;

import com.epam.freelancer.business.context.ApplicationContext;
import com.epam.freelancer.database.model.Admin;

/**
 * Created by Максим on 19.01.2016.
 */
public class AdminServiceTest extends TestCase {

    @Test
    public void testCreateAdmin() throws Exception {
        ApplicationContext applicationContext = ApplicationContext.getInstance();
        Map<String, String[]> map = new HashMap<>();
        map.put("first_name", new String[]{"Alex"});
        map.put("last_name", new String[]{"Higgins"});
        map.put("lang", new String[]{"eu"});
        map.put("email", new String[]{"ahiggins@gmail.com"});
        map.put("password",new String[]{"admin"});

        AdminService service = (AdminService) applicationContext.getBean(AdminService.class.getSimpleName());
    }

    @Test
    public void testUpdateAdmin() throws Exception {
        ApplicationContext applicationContext = ApplicationContext.getInstance();
        AdminService service = (AdminService) applicationContext.getBean(AdminService.class.getSimpleName());

        Admin admin = new Admin();
        admin.setFname("Alex");
        admin.setLname("Higgins");
        admin.setLang("eu");
        admin.setEmail("ahiggins@gmail.com");

        service.updateAdmin(admin);
    }
}
