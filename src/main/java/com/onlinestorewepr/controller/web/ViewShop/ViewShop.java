package com.onlinestorewepr.controller.web.ViewShop;

import com.onlinestorewepr.dao.ProductDAO;
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
    //CurrentPage
    String xpage =req.getParameter("page");
    CategoryService categoryService = new CategoryService();
    ProductService productService = new ProductService();
   /* int categoryID = Integer.parseInt(req.getParameter("CategoryID"));*/
    List<Category> categories = categoryService.getAllCategories();
    List<Product> products;
    List<String> brands = productService.getBrand();
    List<String> sizes = productService.getSize();
    List<String> colors = productService.getColor();
    ProductDAO productdao = new ProductDAO();
    int CategoryID = 0;
    int sortPrice  = 0;
    int price  = 0;

    if((req.getParameter("CategoryID")) != null){
      CategoryID= Integer.parseInt(req.getParameter("CategoryID"));
    }
    if((req.getParameter("sortPrice")) != null){
      sortPrice= Integer.parseInt(req.getParameter("sortPrice"));
    }
    if((req.getParameter("price")) != null){
      price= Integer.parseInt(req.getParameter("price"));
    }
    String brand = req.getParameter("brand");
    String size = req.getParameter("size");
    String color = req.getParameter("color");
    products = productService.filter(CategoryID,req.getParameter("brand"), price ,req.getParameter("size"), req.getParameter("color"), sortPrice);
    if ((req.getParameter("txtSearch")) != null) {
      System.out.print(req.getParameter("txtSearch"));
      products = productService.getAllProdcutbyName(req.getParameter("txtSearch"));
    }

//paging
    int page,numberItem = 6,start,end;
    int numberPage = (products.size()%numberItem==0?(products.size()/numberItem):((products.size()/numberItem)+1));
    if(xpage == null){
      page = 1;
    }else {
      page = Integer.parseInt(xpage);
    }
    start=(page-1)*numberItem;
    end = Math.min(products.size(),page*numberItem);
    products = productdao.getListByPage(products,start,end);


    String slug = req.getQueryString();

    if(slug!=null){
      int x = slug.length();
      System.out.println(x);
      if(slug.contains("&page=")==true)
      {
        StringBuffer sb = new StringBuffer(slug);
        sb.delete(x-7,x);
        slug =sb.toString();
      }
    }

    req.setAttribute("page",page);
    req.setAttribute("price",price);
    req.setAttribute("sortPrice",sortPrice);
    req.setAttribute("CategoryID",CategoryID);
    req.setAttribute("sortPrice",sortPrice);
    req.setAttribute("numberPage",numberPage);
    req.setAttribute("categories", categories);
    req.setAttribute("products", products);
    req.setAttribute("brands", brands);
    req.setAttribute("brand", brand);
    req.setAttribute("sizes", sizes);
    req.setAttribute("size", size);
    req.setAttribute("colors", colors);
    req.setAttribute("color", color);
    req.setAttribute("slug", slug);
    req.getRequestDispatcher("/web/shop.jsp").forward(req, resp);

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    super.doPost(req, resp);
  }
}
