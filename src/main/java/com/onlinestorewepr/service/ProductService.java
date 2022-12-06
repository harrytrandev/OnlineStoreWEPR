package com.onlinestorewepr.service;

import com.onlinestorewepr.dao.CategoryDAO;
import com.onlinestorewepr.dao.ProductDAO;
import com.onlinestorewepr.entity.Category;
import com.onlinestorewepr.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ProductService {
  private HttpServletRequest req;
  private HttpServletResponse resp;
  private ProductDAO productDAO = null;
  private CategoryDAO categoryDAO = null;
  private ServiceResult serviceResult = null;

  public ProductDAO getProductDAO() {
    return productDAO;
  }

  public void setProductDAO(ProductDAO productDAO) {
    this.productDAO = productDAO;
  }

  public ServiceResult getServiceResult() {
    return serviceResult;
  }

  public void setServiceResult(ServiceResult serviceResult) {
    this.serviceResult = serviceResult;
  }

  public CategoryDAO getCategoryDAO() {
    return categoryDAO;
  }

  public void setCategoryDAO(CategoryDAO categoryDAO) {
    this.categoryDAO = categoryDAO;
  }

  public ProductService(HttpServletRequest req, HttpServletResponse resp) {
    this.req = req;
    this.resp = resp;
    productDAO = new ProductDAO();
    categoryDAO = new CategoryDAO();
    serviceResult = new ServiceResult();
  }

  public void createProduct(int categoryId, String name, Part imagePart, String imagePath, String description, int price, int discount, int quantity, String size, String color, String brand) {
    String message = "", messageType = "";

    // Check if a product with the same name already exists in DB
    if (productDAO.findByName(name) == null) {
      // Check if category exists ?
      Category category = categoryDAO.get(categoryId);
      if (category != null) {
        // If category exists, create a new product
        try {
          // Handle image url
          DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd/HH/mm");
          LocalDateTime now = LocalDateTime.now();
          String fileName =  Paths.get(imagePart.getSubmittedFileName()).getFileName().toString();
          imagePath += "\\" + dateTimeFormatter.format(now).replace('/', '\\');

          Path path = Paths.get(imagePath);
          if (!Files.exists(path))
            Files.createDirectories(path);
          String imageUrl = imagePath + "\\" + fileName;
          // ------

          Product product = new Product(name, imageUrl, description, price, quantity, discount, size, color, brand, category);
          productDAO.insert(product);

          imagePart.write(imageUrl);

          message = "A new product was created successfully!";
          messageType = "success";
        } catch (Exception e) {
          e.printStackTrace();
          message = "An error occurred when creating a new category! Please try again.";
          messageType = "danger";
        }
      } else {
        message = "Category doesn't exist! Please try again.";
        messageType = "danger";
      }
    } else {
      message = String.format("A product with name %s already exists! Please choose another name.", name);
      messageType = "danger";
    }
    serviceResult.setMessage(message);
    serviceResult.setMessageType(messageType);
  }

  public Product getProduct(int id) {
    return productDAO.get(id);
  }
  public void getProductDetail() throws ServletException, IOException {
    ProductDAO productdao = new ProductDAO();
    int id = Integer.parseInt(req.getParameter("id"));
    int categoryID = Integer.parseInt(req.getParameter("CategoryID"));
    Product product = productdao.get(id);
    List<Product> products = get4ProdcutbyCategory(categoryID);
    req.setAttribute("product",product );
    req.setAttribute("products", products);

    req.getRequestDispatcher("/web/shop-details.jsp").forward(req, resp);
  }


  public List<Product> get4ProdcutbyCategory(int CategoryID) {
    List<Product> products = null;
    products = productDAO.getTopbyCategory(CategoryID);
    if (products != null) {
      products.sort((o1, o2) -> {
        int compareValue = o1.getName().compareTo(o2.getName());
        return (Integer.compare(compareValue, 0));
      });
    }

    return products;
  }
/*Lấy 4 sản phẩm mới nhất*/
  public List<Product> get8ProdcutNew() {
    List<Product> products = null;
    products = productDAO.getNewArrivals();
    return products;
  }
  public void viewProduct() throws ServletException, IOException {
    List<Product> products = null;
    ProductDAO productdao = new ProductDAO();
    CategoryService categoryService = new CategoryService();


    List<Category> categories = categoryService.getAllCategories();
    List<String> brands = getBrand();
    List<String> sizes = getSize();

    int CategoryID = 0;
    int sortPrice  = 0;
    int price  = 0;

    String xpage =req.getParameter("page");
    String brand = req.getParameter("brand");
    String size = req.getParameter("size");
    String txtSearch = req.getParameter("txtSearch");
    if((req.getParameter("CategoryID")) != null){
      CategoryID= Integer.parseInt(req.getParameter("CategoryID"));
    }
    if((req.getParameter("sortPrice")) != null){
      sortPrice= Integer.parseInt(req.getParameter("sortPrice"));
    }
    if((req.getParameter("price")) != null){
      price= Integer.parseInt(req.getParameter("price"));
    }

    if(txtSearch!=null){
      products = productDAO.searchByName(txtSearch);
    }
    else{
      products = productDAO.filterProduct(CategoryID,brand,price,size, sortPrice);
    }
    if (products != null & sortPrice==0) {
      products.sort((o1, o2) -> {
        int compareValue = o1.getName().compareTo(o2.getName());
        return (Integer.compare(compareValue, 0));
      });
    }

//paging

    int page,numberItem = 9,start,end;
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
    req.setAttribute("slug", slug);

    req.getRequestDispatcher("/web/shop.jsp").forward(req, resp);
  }

  public List<String> getBrand() {
    List<String> brands = null;
    brands = productDAO.getBrand();
    return brands;
  }

  public List<String> getSize() {
    List<String> sizes = null;
    sizes = productDAO.getSize();
    return sizes;
  }

  public List<String> getColor() {
    List<String> colors = null;
    colors = productDAO.getColor();
    return colors;
  }

}
