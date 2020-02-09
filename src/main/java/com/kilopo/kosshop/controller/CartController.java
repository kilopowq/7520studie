package com.kilopo.kosshop.controller;

import com.kilopo.kosshop.DAO.ProductDAO;
import com.kilopo.kosshop.constants.Constants;
import com.kilopo.kosshop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private CartService cartService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProductToCart(@RequestParam String productId, HttpSession session) {
        cartService.addProductToCart(productId, session);
        return Constants.View.HOME_PAGE;
    }

    @RequestMapping(value="/cartProductCount", method = RequestMethod.GET)
    @ResponseBody
    public Integer getCartProductCount(HttpSession session) {
        return cartService.getSessionCart(session).getCountOfProducts();
    }

    @RequestMapping(value="/removeCartProduct", method = RequestMethod.POST)
    public void getCartProductCount(@RequestParam String productId, HttpSession session) {
        cartService.removeCartProduct(productId, session);
    }

    @RequestMapping(value = "/changeProductAmount", method = RequestMethod.POST)
    public String changeProductAmount(@RequestParam String productId, @RequestParam String value, HttpSession session) {
        cartService.changeProductAmountInCart(productId, Integer.valueOf(value), session);
        return Constants.View.PRODUCTS_VIEW;
    }

}
