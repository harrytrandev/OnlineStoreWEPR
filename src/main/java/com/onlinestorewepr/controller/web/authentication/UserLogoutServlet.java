package com.onlinestorewepr.controller.web.authentication;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LogoutServlet",value = {"/logout","/web/logout"})
public class UserLogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute("userLogged");
<<<<<<< HEAD
<<<<<<< HEAD
        resp.sendRedirect("/login");
=======
        resp.sendRedirect(req.getContextPath() + "/login");
>>>>>>> c00c268839d42f556c7ca13dc9fbabaf8d2a42f7
=======
        resp.sendRedirect(req.getContextPath() + "/login");
>>>>>>> c00c268839d42f556c7ca13dc9fbabaf8d2a42f7
    }
}
