package com.onlinestorewepr.controller.web.ViewShop;

import com.onlinestorewepr.entity.Cart;
import com.onlinestorewepr.entity.CartItem;
import com.onlinestorewepr.entity.Product;
import com.onlinestorewepr.entity.User;
import com.onlinestorewepr.service.CartItemService;
import com.onlinestorewepr.service.CartService;
import com.onlinestorewepr.service.ProductService;
import com.onlinestorewepr.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/web/buy")
public class AddProduct extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String userName = "Khoa";

    UserService userService = new UserService();
    CartService cartService = new CartService();
    CartItemService cartItemservice = new CartItemService();
    User user = userService.getUser(userName);

    int idCart = user.getCart().getId();
    int productID =Integer.parseInt(req.getParameter("ProductId"));
    int quantity = Integer.parseInt(req.getParameter("quantity"));
    ProductService productService = new ProductService();

    Product product = productService.getProduct(productID);
    Cart cart = cartService.getCart(idCart);

    cartItemservice.addProduct(quantity,product,cart);
    resp.sendRedirect("../web/shop");
  }
}
