package com.onlinestorewepr.controller.admin.order;

import com.onlinestorewepr.dao.OrderDAO;
import com.onlinestorewepr.dao.ProductDAO;
import com.onlinestorewepr.entity.Order;
import com.onlinestorewepr.entity.OrderItem;
import com.onlinestorewepr.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/admin/update-order")
public class UpdateOder extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductDAO productDAO;
    private OrderDAO orderDAO;
    public UpdateOder() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        orderDAO = new OrderDAO();
        productDAO = new ProductDAO();
        List<Product> productList = new ArrayList<Product>();;
        int id = Integer.parseInt(request.getParameter("id"));
        int total = 0;
        Order order = orderDAO.get(id);
        List getListProduct = orderDAO.getListProduct(id);
        for(int i=0; i<getListProduct.size(); i++) {
            OrderItem row = (OrderItem) getListProduct.get(i);
            total += row.getPrice() * row.getQuantity();
            int productId = row.getProduct().getId();
            Product product = productDAO.get(productId);
            productList.add(product);
        }
        request.setAttribute("total", total);
        request.setAttribute("getListProduct", getListProduct);
        request.setAttribute("productList", productList);
        request.setAttribute("order", order);
        request.getRequestDispatcher("update-order.jsp").forward(request, response);
    }
}
