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
   /* int categoryID = Integer.parseInt(req.getParameter("CategoryID"));*/
    List<Category> categories = categoryService.getAllCategories();
    List<Product> products;
    List<String> brands = productService.getBrand();
    List<String> sizes = productService.getSize();
    if((req.getParameter("CategoryID")) == null || (req.getParameter("CategoryID")).equals("")){
      if ((req.getParameter("brand")) != null){
        System.out.print(2);
        products = productService.getAllProdcutbyBrand(req.getParameter("brand"));
      }
      else if ((req.getParameter("txtSearch")) != null) {
        System.out.print(req.getParameter("txtSearch"));
        products = productService.getAllProdcutbyName(req.getParameter("txtSearch"));
      }
      else {
        products = productService.getAllProducts();
        System.out.print(5);
      }


    }
    else{
      products = productService.getAllProdcutbyCategory(Integer.parseInt(req.getParameter("CategoryID")));
    }

    req.setAttribute("categories", categories);
    req.setAttribute("products", products);
    req.setAttribute("brands", brands);
    req.setAttribute("sizes", sizes);
    req.getRequestDispatcher("/web/shop.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    super.doPost(req, resp);
  }
}
