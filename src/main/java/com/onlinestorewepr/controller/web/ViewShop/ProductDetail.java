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

@WebServlet("/web/shop-details")
public class ProductDetail extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int id = Integer.parseInt(req.getParameter("id"));
    int categoryID = Integer.parseInt(req.getParameter("CategoryID"));
    ProductService productService = new ProductService();
    Product product = productService.getProduct(id);
    List<Product> products = productService.getAllProdcutbyCategory(categoryID);
    req.setAttribute("product",product );
    req.setAttribute("products", products);
    for(Product o:products){
      System.out.println(o.getName());
    }
    req.getRequestDispatcher("/web/shop-details.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    super.doPost(req, resp);
  }
}
