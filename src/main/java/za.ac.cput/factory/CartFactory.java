package za.ac.cput.factory;
/**
 * E-Commerce Web Application for selling clothes
 * CartFactory.java
 * This class uses the Factory Pattern to create an instance of the Cart entity
 * Author: Kinzonzi Genereux Mukoko - 221477934
 * Date: 14 May 2024
 * */
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartItem;
import za.ac.cput.util.Helper;

import java.util.List;

public class CartFactory {

    public static Cart buildCart(String cartID, String customerID, double totalAmpount, List<CartItem> cartItems){
        if(Helper.isNullOrEmpty(cartID) ||
                Helper.isNullOrEmpty(customerID) ||
                totalAmpount == 0 || Helper.isNullOrEmpty(cartItems.toString()))
            return null;

        return new Cart.Builder().setCartID(cartID)
                .setCustomerID(customerID)
                .setTotalAmount(totalAmpount)
                .setCartItems(cartItems)
                .build();
    }
}
