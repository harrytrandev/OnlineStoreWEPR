package com.onlinestorewepr.service;

import com.onlinestorewepr.dao.CartItemDAO;
import com.onlinestorewepr.entity.Cart;
import com.onlinestorewepr.entity.CartItem;
import com.onlinestorewepr.entity.Product;

import java.util.List;

public class CartItemService {

    public void addProduct(int quantity, Product product, Cart cart){
        CartItemDAO cartItemdao = new CartItemDAO();
        CartItem cartItem = new CartItem();
        cartItem.setQuantity(quantity);
        cartItem.setProduct(product);
        cartItem.setCart(cart);

        cartItemdao.insert(cartItem);
    }
}
