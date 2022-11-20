package com.onlinestorewepr.controller.web.ViewShop;

import com.onlinestorewepr.entity.Category;
import com.onlinestorewepr.entity.Product;
import com.onlinestorewepr.service.CategoryService;
import com.onlinestorewepr.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/web/shop")
public class ViewShop extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    CategoryService categoryService = new CategoryService();
    ProductService productService = new ProductService();

    List<Category> categories = categoryService.getAllCategories();
    List<Product> products = productService.getAllProducts();

    req.setAttribute("categories", categories);
    req.setAttribute("products", products);
    req.getRequestDispatcher("/web/shop.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    super.doPost(req, resp);
  }
}
