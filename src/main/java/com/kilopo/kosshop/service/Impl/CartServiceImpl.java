package com.kilopo.kosshop.service.Impl;

import com.kilopo.kosshop.DAO.CartDAO;
import com.kilopo.kosshop.DAO.CartProductDAO;
import com.kilopo.kosshop.entity.Cart;
import com.kilopo.kosshop.entity.CartProduct;
import com.kilopo.kosshop.entity.CartStatus;
import com.kilopo.kosshop.entity.Product;
import com.kilopo.kosshop.entity.User;
import com.kilopo.kosshop.service.CartService;
import com.kilopo.kosshop.service.ProductService;
import com.kilopo.kosshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @Autowired
    private CartDAO cartDAO;

    @Autowired
    private CartProductDAO cartProductDAO;

    @Override
    public void addProductToCart(String id, HttpSession session) {
        Product product = productService.getById(id);
        if (!changeAmountIfProductExistsInSessionCart(product, session, false, 1)) {
            addNewProductToCart(product, session);
        }
    }

    @Override
    public Cart getSessionCart(HttpSession session) {
        if (session.getAttribute("cart") != null) {
        } else {
            Cart cart = new Cart();
            session.setAttribute("cart", cart);
        }
        return (Cart) session.getAttribute("cart");
    }

    @Override
    public void setUserActiveCartToSession(HttpSession session, String login) {
        Optional<User> userOptional = userService.getByColumnNameAndValue("login", login).stream().findFirst();
        userOptional.ifPresent(user -> {
            Cart cartStream = user.getCarts().stream()
                    .filter(cart -> cart.getCartStatus().equals(CartStatus.ACTIVE))
                    .findFirst().orElse(getSessionCart(session));
            cartStream.setUser(user);
            saveCartIfNotEmpty(cartStream);
            setCartToSessionCart(cartStream, session);
        });
    }

    private void saveCartIfNotEmpty(Cart cart) {
        if((!cart.getCartProducts().isEmpty()) && cart.getId() == null){
            saveCart(cart);
        }
    }

    @Override
    public void changeProductAmountInCart(String productId, Integer value, HttpSession session) {
        changeAmountIfProductExistsInSessionCart(productService.getById(productId), session, true, value);
    }

    @Override
    public void removeCartProduct(String productId, HttpSession session) {
        Cart cart = getSessionCart(session);
        Set<CartProduct> cartProductSet = new HashSet<>();
        for (CartProduct cartProduct : cart.getCartProducts()) {
            if (cartProduct.getProduct().getId().equals(Long.parseLong(productId))) {
                if (isNotAnonymous() && cartProduct.getId() != null) {
                    cartProductDAO.delete(cartProduct.getId());
                }
            } else {
                cartProductSet.add(cartProduct);
            }
        }
            cart.setCartProducts(cartProductSet);
    }

    private void addNewProductToCart(Product product, HttpSession session) {
        Cart cart = getSessionCart(session);
        CartProduct cartProduct = new CartProduct();
        cartProduct.setProduct(product);
        cartProduct.setAmount(1);
        cartProduct.setCart(cart);
        cart.getCartProducts().add(cartProduct);
        setCartToSessionCart(cart, session);
        if (isNotAnonymous()) {
            saveCartOrCartProduct(cart, cartProduct);
        }
    }

    private boolean changeAmountIfProductExistsInSessionCart(Product product, HttpSession session,
                                                             boolean setValue, Integer value) {
        AtomicBoolean done = new AtomicBoolean(false);
        Cart cart = getSessionCart(session);
        cart.getCartProducts().stream().filter(cartProduct -> cartProduct.getProduct().getId().equals(product.getId()))
                .forEach(cartProduct -> {
                    if (setValue) {
                        cartProduct.setAmount(value);
                        done.set(true);
                    } else {
                        cartProduct.setAmount(cartProduct.getAmount() + 1);
                        done.set(true);
                    }
                });

        setCartToSessionCart(cart, session);
        if (isNotAnonymous() && done.get()) {
            updateCart(cart);
        }
        return done.get();
    }

    private void setCartToSessionCart(Cart cart, HttpSession session) {
        session.setAttribute("cart", cart);
    }

    private boolean isNotAnonymous() {
        return !(SecurityContextHolder.getContext().getAuthentication()
                instanceof AnonymousAuthenticationToken);
    }

    private void saveCartProduct(CartProduct cartProduct) {
        cartProductDAO.add(cartProduct);
    }

    private Cart saveCart(Cart cart) {
        return cartDAO.add(cart);
    }

    private void updateCart(Cart cart) {
        cartDAO.addOrUpdate(cart);
    }

    private void saveCartOrCartProduct(Cart cart, CartProduct cartProduct) {
        if (cart.getId() == null) {
            saveCart(cart);
        } else {
            saveCartProduct(cartProduct);
        }
    }

}
