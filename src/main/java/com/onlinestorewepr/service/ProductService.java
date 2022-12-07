package com.onlinestorewepr.service;

import com.onlinestorewepr.dao.CategoryDAO;
import com.onlinestorewepr.dao.ProductDAO;
import com.onlinestorewepr.dao.UserDAO;
import com.onlinestorewepr.entity.CartItem;
import com.onlinestorewepr.entity.Category;
import com.onlinestorewepr.entity.Product;
import com.onlinestorewepr.entity.User;
import com.onlinestorewepr.util.CommonUtil;
import com.onlinestorewepr.util.MessageUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ProductService {
  private HttpServletRequest req;
  private HttpServletResponse resp;
  private ProductDAO productDAO;
  private MessageUtil message;

  public ProductService(HttpServletRequest req, HttpServletResponse resp) {
    this.req = req;
    this.resp = resp;
    this.productDAO = new ProductDAO();
    this.message = new MessageUtil();
  }

  public HttpServletRequest getReq() {
    return req;
  }

  public void setReq(HttpServletRequest req) {
    this.req = req;
  }

  public HttpServletResponse getResp() {
    return resp;
  }

  public void setResp(HttpServletResponse resp) {
    this.resp = resp;
  }

  public ProductDAO getProductDAO() {
    return productDAO;
  }

  public void setProductDAO(ProductDAO productDAO) {
    this.productDAO = productDAO;
  }

  public MessageUtil getMessage() {
    return message;
  }

  public void setMessage(MessageUtil message) {
    this.message = message;
  }

  private void readData(Product product) {
    try {
      int categoryId = Integer.parseInt(req.getParameter("category-id"));
      CategoryDAO categoryDAO = new CategoryDAO();
      Category category = categoryDAO.get(categoryId);
      boolean available = req.getParameter("available") == null || (req.getParameter("available").equals("1"));
      String name = req.getParameter("name");
      String image = "temp";
      String description = req.getParameter("description");
      int price = Integer.parseInt(req.getParameter("price"));
      int discount = Integer.parseInt(req.getParameter("discount"));
      int quantity = Integer.parseInt(req.getParameter("quantity"));
      String size = req.getParameter("size");
      String color = req.getParameter("color");
      String brand = req.getParameter("brand");

      product.setAvailable(available);
      product.setCategory(category);
      product.setName(name);
      product.setImage(image);
      product.setDescription(description);
      product.setPrice(price);
      product.setDiscount(discount);
      product.setQuantity(quantity);
      product.setSize(size);
      product.setColor(color);
      product.setBrand(brand);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void ListProducts() throws ServletException, IOException {
    List<Product> products = productDAO.getAll();
    if (products != null) {
      products.sort((o1, o2) -> {
        int compareValue = o1.getName().compareTo(o2.getName());
        return (Integer.compare(compareValue, 0));
      });
    }
    req.setAttribute("products", products);
    req.getRequestDispatcher("/admin/products.jsp").forward(req, resp);
  }

  public void ShowAddProduct() throws ServletException, IOException {
    CategoryDAO categoryDAO = new CategoryDAO();
    List<Category> categories = categoryDAO.getAll();
    if (categories != null) {
      categories.sort((o1, o2) -> {
        int compareValue = o1.getName().compareTo(o2.getName());
        return (Integer.compare(compareValue, 0));
      });
    }
    req.setAttribute("action", "add");
    req.setAttribute("categories", categories);
    req.getRequestDispatcher("/admin/update-product.jsp").forward(req, resp);
  }

  public void AddProduct() throws ServletException, IOException {
    String messageBody = "", messageType = "";
    try {
      Product product = new Product();
      Part part = req.getPart("image");
      readData(product);
      if (product.isPropertiesValid()) {
        try {
          // Save image
          String imageName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
          String now = CommonUtil.getImgDir();
          String realPath = req.getServletContext().getRealPath("/images" + now);
          // Check if path exist, if not, create a new one
          Path path = Paths.get(realPath);
          if (!Files.exists(path)) {
            Files.createDirectories(path);
          }
          part.write(realPath + "/" + imageName);
          String image = String.format("images%s/%s", now, imageName);
          product.setImage(image);
          // ------------------

          productDAO.insert(product);
          messageBody = "A new product was created successfully!";
          messageType = "success";
        } catch (Exception ex) {
          ex.printStackTrace();
          messageBody = "An error occurred when update product's info! Please try again";
          messageType = "danger";
        }
      } else {
        messageBody = "All fields cannot be empty!";
        messageType = "danger";
      }
    } catch (Exception ex) {
      ex.printStackTrace();
      messageBody = "An error occurred when transfer data! Please try again";
      messageType = "danger";
    }
    message.setBody(messageBody);
    message.setType(messageType);
    req.setAttribute("message", message);
    ShowAddProduct();
  }

  public void ShowUpdateProduct() throws ServletException, IOException {
    CategoryDAO categoryDAO = new CategoryDAO();
    List<Category> categories = categoryDAO.getAll();
    int id = req.getParameter("id") == null ? 0 : Integer.parseInt(req.getParameter("id"));
    Product product = productDAO.get(id);
    req.setAttribute("product", product);
    req.setAttribute("categories", categories);
    req.setAttribute("action", "update");
    req.getRequestDispatcher("/admin/update-product.jsp").forward(req, resp);
  }

  public void UpdateProduct() throws ServletException, IOException {
    String messageBody = "", messageType = "";
    int id = Integer.parseInt(req.getParameter("id"));
    Product existedProduct = productDAO.get(id);
    Product product = new Product();
    readData(product);
    if (product.isPropertiesValid() && existedProduct != null) {
      try {
        // If upload another image, assign the new and delete the old
        Part part = req.getPart("image");
        if (!part.getSubmittedFileName().isEmpty()) {
          String imageName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
          String now = CommonUtil.getImgDir();
          String realPath = req.getServletContext().getRealPath("/images" + now);
          Path path = Paths.get(realPath);
          if (!Files.exists(path)) {
            Files.createDirectories(path);
          }
          part.write(realPath + "/" + imageName);
          String image = String.format("images%s/%s", now, imageName);
          product.setImage(image);

          // Delete existed image
          CommonUtil.deleteDir(req.getServletContext().getRealPath(existedProduct.getImage()));
        } else {
          // if not upload, keep the existed image
          product.setImage(existedProduct.getImage());
        }
        product.setId(id);
        productDAO.update(product);
        messageBody = "Product's info was changed successfully!";
        messageType = "success";
      } catch (Exception ex) {
        messageBody = "An error occurred when creating a new product! Please try again";
        messageType = "danger";
        ex.printStackTrace();
      }
    } else {
      messageBody = "All fields cannot be empty!";
      messageType = "danger";
    }
    message.setBody(messageBody);
    message.setType(messageType);
    req.setAttribute("message", message);
    ShowUpdateProduct();
  }

  public void DeleteProduct() throws ServletException, IOException {
    String messageBody = "", messageType = "";
    int id = Integer.parseInt(req.getParameter("id"));
    if (id != 0) {
      Product product = productDAO.get(id);
      if (product != null) {
        if (product.getOrderItems().isEmpty() && product.getCartItems().isEmpty()) {
          // delete image
          CommonUtil.deleteDir(req.getServletContext().getRealPath(product.getImage()));
          productDAO.delete(id);
          messageBody = "Product was deleted successfully!";
          messageType = "primary";
        } else {
          messageBody = "Cannot delete this category, this product is already in some cart or order.";
          messageType = "danger";
        }
      }
      else {
        messageBody = "Product doesn't exist";
        messageType = "danger";
      }
    }
    else {
      messageBody = "Id doesn't exist";
      messageType = "danger";
    }
    message.setBody(messageBody);
    message.setType(messageType);

    req.setAttribute("message", message);
    req.setAttribute("title", "Delete Information");
    req.setAttribute("action", "/admin/product");
    req.getRequestDispatcher("/admin/information.jsp").forward(req, resp);
  }

  public List<CartItem> getListCartItems( String username) {
    List<Product> products = null;
    UserDAO userDAO = new UserDAO();
    User user = userDAO.get(username);
    CartItemService cartItemService = new CartItemService(req,resp);
    List<CartItem> cartItems = cartItemService.getListCartItem(user.getCart().getId());
    return  cartItems;
//    for(CartItem cartItem : cartItems){
//      System.out.println(cartItem.getProduct().getName());
//    }
  }
  public List<Product> getAllProducts() {
    List<Product> products = null;
    products = productDAO.getAll();
    return  products;
  }
}
