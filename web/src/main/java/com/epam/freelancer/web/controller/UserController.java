package com.epam.freelancer.web.controller;

import com.epam.freelancer.business.context.ApplicationContext;
import com.epam.freelancer.business.service.AdminService;
import com.epam.freelancer.business.service.CustomerService;
import com.epam.freelancer.business.service.DeveloperService;
import com.epam.freelancer.business.service.UserService;
import com.epam.freelancer.database.model.UserEntity;
import org.apache.log4j.Logger;
import sun.applet.AppletClassLoader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.UUID;

public class UserController extends HttpServlet {

    public static final Logger LOG = Logger.getLogger(UserController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            switch (FrontController.getPath(request)) {
                case "user/email":
//                    checkEmail(request, response);
                    break;
                case "user/trylogin":
//                    tryToLogin(request, response);
                    break;
                case "user/create":
                    create(request, response);
                    break;

                default:
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOG.fatal(getClass().getSimpleName() + " - " + "doPost");
        }
    }

    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String role = request.getParameter("role");
        if(role==null || role.isEmpty()){
            response.sendRedirect("/chooserole");
            return;
        }
        String email = request.getParameter("email");
        if(!isAvailable(email)){
            request.setAttribute("notAvailableEmail", true);
            request.getRequestDispatcher(FrontController.getPath(request));
        }

        request.getParameterMap().put("uuid", new String[]{UUID.randomUUID().toString()});

        if(role.equals("developer")){
            DeveloperService developerService = (DeveloperService) ApplicationContext.getInstance().getBean("developerService");
            developerService.create(request.getParameterMap());
        }else if(role.equals("customer")){
            CustomerService customerService = (CustomerService) ApplicationContext.getInstance().getBean("customerService");
            customerService.create(request.getParameterMap());
        }
        request.setAttribute("confirm_email", true);
        request.getRequestDispatcher("/view/signin.jsp");

    }


    private boolean isAvailable(String email){
        boolean result=false;
        if(((AdminService)ApplicationContext.getInstance().getBean("adminService")).emailAvailable(email) &&
                ((DeveloperService)ApplicationContext.getInstance().getBean("developerService")).emailAvailable(email) &&
                ((CustomerService)ApplicationContext.getInstance().getBean("customerService")).emailAvailable(email)){
            result=true;
        }
        return result;
    }
}
