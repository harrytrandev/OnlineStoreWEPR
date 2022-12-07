package com.onlinestorewepr.service;

import com.onlinestorewepr.dao.CartItemDAO;
import com.onlinestorewepr.dao.CategoryDAO;
import com.onlinestorewepr.dao.ProductDAO;
import com.onlinestorewepr.entity.Cart;
import com.onlinestorewepr.entity.CartItem;
import com.onlinestorewepr.entity.Product;
import com.onlinestorewepr.dao.UserDAO;
import com.onlinestorewepr.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CartItemService {
    private HttpServletRequest req;
    private HttpServletResponse resp;
    private ProductDAO productDAO = null;
    private ServiceResult serviceResult = null;
    CartItemDAO cartItemDAO;

    public CartItemService(HttpServletRequest req, HttpServletResponse resp) {
        this.req = req;
        this.resp = resp;
        productDAO = new ProductDAO();
        serviceResult = new ServiceResult();
        cartItemDAO = new CartItemDAO();
    }
    public void addProduct() throws ServletException, IOException {
        String userName = "Khoa";

        CartItemDAO cartItemdao = new CartItemDAO();

        ProductService productService = new ProductService(req, resp);

        UserService userService = new UserService(req, resp);
        CartService cartService = new CartService();

        User user = new UserDAO().get(userName);

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

    public List<CartItem> getListCartItem(int id) {
        List<CartItem> cartItems = cartItemDAO.getList(id);
        return cartItems;
    }

    public void ListCartItem () throws IOException, ServletException {
        String username = "1"; ////// Sua lai doan nay
        ProductService productService = new ProductService(req, resp);
        List<CartItem> cartItems = productService.getListCartItems(username);
        int total =0;
        for(CartItem cartItem: cartItems){
            total+= cartItem.getProduct().getPrice()*cartItem.getQuantity();
        }
        String message = req.getParameter("message");
        if(message != null){
            req.setAttribute("message", message);
        }
        req.setAttribute("total",total);
        req.setAttribute("cartItems",cartItems);
        req.getRequestDispatcher("/web/shopping-cart.jsp").forward(req, resp);
    }
    public void delete() throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        CartItemDAO cartItemDAO =new CartItemDAO();
        cartItemDAO.delete(id);
        String message = "Delete successfully";
        resp.sendRedirect("/cart?message=" + message);
    }

    public CartItem getCartItemDAO(int id) {
        return cartItemDAO.get(id);
    }

    public void updateCartItem() throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String action = req.getParameter("action");
        int quantity = Integer.parseInt(req.getParameter("quantity"));
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
            resp.sendRedirect("/cart?message="+message);
        }
        else {
            resp.sendRedirect("/cart");
        }
    }
}
