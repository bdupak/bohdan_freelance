package com.epam.freelancer.web.controller;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    public void create(HttpServletRequest request, HttpServletResponse response) {
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String password_confirmation = request.getParameter("password_confirmation");

        System.out.println("FirstName: " + firstName);
        System.out.println("LastName: " + lastName);
        System.out.println("email: " + email);
        System.out.println("password: " + password);
        System.out.println("password_confirmation: " + password_confirmation);
    }
}
