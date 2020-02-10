package com.kilopo.kosshop.service;

import com.kilopo.kosshop.entity.Cart;

import javax.servlet.http.HttpSession;

public interface CartService {
    void addProductToCart(String id, HttpSession session);
    Cart getSessionCart(HttpSession session);
    void setUserActiveCartToSession(HttpSession session, String login);
    void changeProductAmountInCart(String productId, Integer value, HttpSession session);
    void removeCartProduct(String productId, HttpSession session);
}
