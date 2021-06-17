package com.dev.taxi.controller.driver;

import com.dev.taxi.exception.AuthenticationException;
import com.dev.taxi.lib.Injector;
import com.dev.taxi.model.Driver;
import com.dev.taxi.service.AuthenticationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginController extends HttpServlet {
    private static final String DRIVER_ID = "driverId";
    private static final Injector injector = Injector.getInstance("com/dev/taxi");
    private final AuthenticationService authenticationService = (AuthenticationService) injector
            .getInstance(AuthenticationService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/drivers/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            Driver driver = authenticationService.login(req.getParameter("login"),
                    req.getParameter("password"));
            HttpSession session = req.getSession();
            session.setAttribute(DRIVER_ID, driver.getId());
            resp.sendRedirect("/index");
        } catch (AuthenticationException e) {
            req.setAttribute("errorMsg", e.getMessage());
            req.getRequestDispatcher("/WEB-INF/views/drivers/login.jsp").forward(req, resp);
        }
    }
}
