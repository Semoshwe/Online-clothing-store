package za.ac.cput.domain;
/**
 * E-Commerce Web Application for selling clothes
 * CartItem.java
 * This POJO class for the CartItem entity. Domain class using Builder Pattern
 * Author: Kinzonzi Genereux Mukoko - 221477934
 * Date: 14 May 2024
 */
import jakarta.persistence.*;

import java.util.Objects;
@Entity
@Embeddable
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartItemID;
    private long cartID;
    private long productID;
    private double price;

    protected CartItem(){};

    private CartItem(Builder builder){
        this.cartItemID = builder.cartItemID;
        this.cartID = builder.cartID;
        this.productID = builder.productID;
        this.price = builder.price;
    }
    public long getCartItemID() {
        return cartItemID;
    }

    public long getCartID() {
        return cartID;
    }

    public long getProductID() {
        return productID;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return cartItemID == cartItem.cartItemID && cartID == cartItem.cartID && productID == cartItem.productID && Double.compare(price, cartItem.price) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartItemID, cartID, productID, price);
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "cartItemID=" + cartItemID +
                ", cartID=" + cartID +
                ", productID=" + productID +
                ", price=" + price +
                '}';
    }

    public static class Builder{
        private long cartItemID;
        private long cartID;
        private long productID;
        private double price;

        public CartItem.Builder setCartItemID(long cartItemID){
            this.cartItemID = cartItemID;
            return this;
        }

        public CartItem.Builder setCartID(long cartID){
            this.cartID = cartID;
            return this;
        }

        public CartItem.Builder setProductID(long productID){
            this.productID = productID;
            return this;
        }

        public CartItem.Builder setPrice(double price){
            this.price = price;
            return this;
        }

        public Builder copy(CartItem cartItem) {
            this.cartItemID = cartItem.cartItemID;
            this.cartID = cartItem.cartID;
            this.productID = cartItem.productID;
            this.price = cartItem.price;
            return this;
        }

        public CartItem build(){
            return new CartItem(this);
        }
    }
}
