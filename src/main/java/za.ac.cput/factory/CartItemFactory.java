package za.ac.cput.factory;
/**
 * E-Commerce Web Application for selling clothes
 * CartItemFactory.java
 * This class uses the Factory Pattern to create an instance of the CartItem entity
 * Author: Kinzonzi Genereux Mukoko - 221477934
 * Date: 14 May 2024
 * */
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartItem;
import za.ac.cput.util.Helper;

import java.util.List;

public class CartItemFactory {
    public static CartItem buildCartItem(long cartItemID, String cartID,long productID, double price){
        if(Helper.isNullOrEmpty(cartItemID) ||
                Helper.isNullOrEmpty(cartID) ||
                price == 0 || Helper.isNullOrEmpty(productID))
            return null;

        return new CartItem.Builder().setCartItemID(cartItemID)
                .setCartID(cartID)
                .setProductID(productID)
                .setPrice(price)
                .build();
    }


}
