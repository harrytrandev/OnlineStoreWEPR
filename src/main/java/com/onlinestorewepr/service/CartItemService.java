package com.onlinestorewepr.service;

import com.onlinestorewepr.dao.CartItemDAO;
import com.onlinestorewepr.dao.UserDAO;
import com.onlinestorewepr.entity.CartItem;
import com.onlinestorewepr.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.List;

public class CartItemService {

    private HttpServletRequest request;
    private HttpServletResponse response;
    CartItemDAO cartItemDAO;
    public CartItemService(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        cartItemDAO = new CartItemDAO();
    }

    public List<CartItem> getListCartItem(int id) {
        List<CartItem> cartItems = cartItemDAO.getList(id);
        return cartItems;
    }

    public void ListCartItem () throws IOException, ServletException {
        String username = "1"; ////// Sua lai doan nay
        ProductService productService = new ProductService();
        List<CartItem> cartItems = productService.getListProduct(username);
        int total =0;
        for(CartItem cartItem: cartItems){
            total+= cartItem.getProduct().getPrice()*cartItem.getQuantity();
        }
        String message = request.getParameter("message");
        if(message != null){
            request.setAttribute("message", message);
        }
        request.setAttribute("total",total);
        request.setAttribute("cartItems",cartItems);
        request.getRequestDispatcher("/web/shopping-cart.jsp").forward(request, response);
    }
    public void delete() throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        CartItemDAO cartItemDAO =new CartItemDAO();
        cartItemDAO.delete(id);
        String message = "Delete successfully";
        response.sendRedirect("/cart?message=" + message);
    }

    public CartItem getCartItemDAO(int id) {
        return cartItemDAO.get(id);
    }

    public void updateCartItem() throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String action = request.getParameter("action");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        CartItem cartItem = cartItemDAO.get(id);
        String message = null;
        int quantityProduct = cartItem.getProduct().getQuantity();
        System.out.println("Action: " + action);
        if (action.equals("inc") && quantity == quantityProduct){
            message = "Out of stock";
        }
        else if(action.equals("dec") && quantity == 0){
            message = "Can't reduce the quantity";
        } else if (action.equals("inc")) {
            quantity = quantity + 1;
            System.out.println(quantity);
            cartItem.setQuantity(quantity);
            cartItemDAO.update(cartItem);
            System.out.println(cartItem.getQuantity());
        } else if (action.equals("dec")) {
            quantity = quantity - 1;
            cartItem.setQuantity(quantity);
            System.out.println(quantity);
            cartItemDAO.update(cartItem);
        }
        if (message!= null) {
            response.sendRedirect("/cart?message="+message);
        }
        else {
            response.sendRedirect("/cart");
        }
    }
}
