package com.onlinestorewepr.service;

import com.onlinestorewepr.dao.CartItemDAO;
import com.onlinestorewepr.dao.CategoryDAO;
import com.onlinestorewepr.dao.ProductDAO;
import com.onlinestorewepr.entity.Cart;
import com.onlinestorewepr.entity.CartItem;
import com.onlinestorewepr.entity.Product;
import com.onlinestorewepr.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class CartItemService {
    private HttpServletRequest req;
    private HttpServletResponse resp;
    private ProductDAO productDAO = null;
    private ServiceResult serviceResult = null;
    public CartItemService(HttpServletRequest req, HttpServletResponse resp) {
        this.req = req;
        this.resp = resp;
        productDAO = new ProductDAO();
        serviceResult = new ServiceResult();
    }
    public void addProduct()throws ServletException, IOException {
        String userName = "Khoa";

        CartItemDAO cartItemdao = new CartItemDAO();

        ProductService productService = new ProductService(req, resp);

        UserService userService = new UserService();
        CartService cartService = new CartService();

        User user = userService.getUser(userName);

        int idCart = user.getCart().getId();
        int productID =Integer.parseInt(req.getParameter("ProductId"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        Product product = productService.getProduct(productID);
        Cart cart = cartService.getCart(idCart);

        CartItem cartItem = new CartItem();
        cartItem.setQuantity(quantity);
        cartItem.setProduct(product);
        cartItem.setCart(cart);

        cartItemdao.insert(cartItem);

        resp.sendRedirect("../web/shop");
    }
}
