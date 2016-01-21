package com.epam.freelancer.web.controller;

import com.epam.freelancer.business.context.ApplicationContext;
import com.epam.freelancer.business.service.AdminService;
import com.epam.freelancer.business.service.CustomerService;
import com.epam.freelancer.business.service.DeveloperService;
import com.epam.freelancer.database.model.Admin;
import com.epam.freelancer.database.model.Customer;
import com.epam.freelancer.database.model.Developer;
import com.epam.freelancer.security.provider.AuthenticationProvider;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserController extends HttpServlet {
	public static final Logger LOG = Logger.getLogger(UserController.class);
    private static final long serialVersionUID = -2356506023594947745L;

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
                case "user/signin":
                    signIn(request, response);
                    break;
                case "user/create":
                    create(request, response);
                    break;
                case "user/signinByGoogle":
                    signinByGoogle(request, response);
                    break;

                default:
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOG.fatal(getClass().getSimpleName() + " - " + "doPost");
        }
    }

    public void create(HttpServletRequest request, HttpServletResponse response) {
        String param = request.getQueryString();
        System.out.println("QUERY = " + param);
       /* String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String password_confirmation = request.getParameter("password_confirmation");

        System.out.println("FirstName: " + firstName);
        System.out.println("LastName: " + lastName);
        System.out.println("email: " + email);
        System.out.println("password: " + password);
        System.out.println("password_confirmation: " + password_confirmation);

        DeveloperService ds = new DeveloperService();

        if(ds.emailAvailable(email)) {
            ds.create(request.getParameterMap());
        }*/
    }

    public void signIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        boolean remember = "on".equals(request.getParameter("remember"));

        if (email == null || "".equals(email)) {
            request.setAttribute("notCorrectData", "Invalid credentials");
            request.getRequestDispatcher("/views/signin.jsp").forward(request, response);
            return;
        }

        if (password == null || "".equals(password)) {
            request.setAttribute("notCorrectData", "Invalid credentials");
            request.getRequestDispatcher("/views/signin.jsp").forward(request, response);
            return;
        }

        HttpSession session = request.getSession();
        ApplicationContext.getInstance().addBean("authenticationProvider", new AuthenticationProvider());
        AuthenticationProvider authenticationProvider = (AuthenticationProvider) ApplicationContext.
                getInstance().getBean("authenticationProvider");

        DeveloperService ds = new DeveloperService();
        Developer developer = ds.findByEmail(email);

        if (developer != null) {
            if (ds.validCredentials(email, password, developer)) {
                session.setAttribute("user", developer);
                if (remember) {
                    authenticationProvider.loginAndRemember(response, "freelancerRememberMeCookie", developer);
                } else {
                    authenticationProvider.invalidateUserCookie(response, "freelancerRememberMeCookie", developer);
                }
            } else {
                request.setAttribute("notCorrectData", "Invalid credentials");
                request.getRequestDispatcher("/views/signin.jsp").forward(request, response);
                return;
            }
        } else {
            request.setAttribute("notCorrectData", "Invalid credentials");
            request.getRequestDispatcher("/views/signin.jsp").forward(request, response);
            return;
        }

        CustomerService cs = new CustomerService();
        Customer customer = cs.findByEmail(email);

        if (customer != null) {
            if (cs.validCredentials(email, password, customer)) {
                session.setAttribute("user", customer);
                if (remember) {
                    authenticationProvider.loginAndRemember(response, "freelancerRememberMeCookie", customer);
                } else {
                    authenticationProvider.invalidateUserCookie(response, "freelancerRememberMeCookie", customer);
                }
            } else {
                request.setAttribute("notCorrectData", "Invalid credentials");
                request.getRequestDispatcher("/views/signin.jsp").forward(request, response);
                return;
            }
        } else {

            request.setAttribute("notCorrectData", "Invalid credentials");
            request.getRequestDispatcher("/views/signin.jsp").forward(request, response);
            return;
        }

        AdminService as = new AdminService();
        Admin admin = as.findByEmail(email);

        if (admin != null) {
            if (as.validCredentials(email, password, admin)) {
                session.setAttribute("user", admin);
                if (remember) {
                    authenticationProvider.loginAndRemember(response, "freelancerRememberMeCookie", admin);
                } else {
                    authenticationProvider.invalidateUserCookie(response, "freelancerRememberMeCookie", admin);
                }
            } else {
                request.setAttribute("notCorrectData", "Invalid credentials");
                request.getRequestDispatcher("/views/signin.jsp").forward(request, response);
            }
        } else {

            request.setAttribute("notCorrectData", "Invalid credentials");
            request.getRequestDispatcher("/views/signin.jsp").forward(request, response);
            return;
        }
    }

    public void signinByGoogle(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String img = request.getParameter("img");

        System.out.println("EMAIL " + email);
        System.out.println("NAME " + name);
        System.out.println("IMG " + img);

        DeveloperService ds = new DeveloperService();

        if (ds.emailAvailable(email)) {

        }
    }
}
