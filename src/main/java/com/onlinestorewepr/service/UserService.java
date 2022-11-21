package com.onlinestorewepr.service;

import com.onlinestorewepr.dao.OrderDAO;
import com.onlinestorewepr.dao.UserDAO;
import com.onlinestorewepr.entity.Order;
import com.onlinestorewepr.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class UserService {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private UserDAO userDAO;

    public UserService(HttpServletRequest request, HttpServletResponse response){
        this.request = request;
        this.response = response;
        this.userDAO = new UserDAO();
    }

    public void listAll() throws ServletException, IOException {
        listAll(null);
    }
    public void listAll(String message) throws ServletException, IOException {
        // TODO Auto-generated method stub
//        List<Order> listOrder = orderDAO.getAll();
        List<User> userList = userDAO.getAll();
        request.setAttribute("userList", userList);
        if (message != null) {
            request.setAttribute("message", message);
        }
        request.getRequestDispatcher("account.jsp").forward(request, response);
    }

    public void getUser(String username) throws ServletException, IOException {
        System.out.println("loi");
        User user = userDAO.get(username);
        System.out.println(user.getName());
        request.setAttribute("user", user);
        request.getRequestDispatcher("update-account.jsp").forward(request, response);
    }

    public void updateService() throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        User user = userDAO.get(username);
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        user.setPassword(password);
        user.setName(name);
        user.setPhone(phone);
        user.setAddress(address);
        userDAO.update(user);
        //
    }
}
