package com.onlinestorewepr.service;

import com.onlinestorewepr.dao.CartDAO;
import com.onlinestorewepr.entity.Cart;
import com.onlinestorewepr.entity.Order;
import com.onlinestorewepr.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.onlinestorewepr.dao.OrderDAO;
import com.onlinestorewepr.dao.ProductDAO;
import com.onlinestorewepr.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import java.util.List;
public class OrderService {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private OrderDAO orderDAO;
    private CartDAO cartDAO;
    public OrderService(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.orderDAO = new OrderDAO();
        this.cartDAO = new CartDAO();
    }
    public void addToOrder() throws ServletException, IOException {

    }
    public void listAll() throws ServletException, IOException {
        // TODO Auto-generated method stub
        listAll(null);
    }
    public void listAll(String message) throws ServletException, IOException {
        // TODO Auto-generated method stub
//        List<Order> listOrder = orderDAO.getAll();
        List<Order> listOrder = OrderDAO.getAll();
        request.setAttribute("listOrder", listOrder);
        if (message != null) {
            request.setAttribute("message", message);
        }
        request.getRequestDispatcher("orders.jsp").forward(request, response);
    }

    public void updateService() throws ServletException, IOException {
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        Order order = orderDAO.get(id);
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String status = request.getParameter("status");
        order.setPhone(phone);
        order.setAddress(address);
        order.setStatus(status);
        orderDAO.update(order);
        response.sendRedirect("/admin/list_order");
        //request.getServletContext().getRequestDispatcher("/admin/list_order").forward(request, response);
    }

}