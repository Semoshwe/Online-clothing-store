//package za.ac.cput.factory;
///**
// * E-Commerce Web Application for selling clothes
// * CartFactoryTest.java
// * Test for the CartFactory
// * Author: Kinzonzi Genereux Mukoko - 221477934
// * Date: 16 May 2024
// * */
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.springframework.boot.test.context.SpringBootTest;
//import za.ac.cput.domain.Cart;
//import za.ac.cput.domain.CartItem;
//import za.ac.cput.factory.CartFactory;
//import za.ac.cput.factory.CartItemFactory;
//
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//@TestMethodOrder(MethodOrderer.class)
//public class CartFactoryTest {
//    private ArrayList<CartItem> list = new ArrayList<CartItem>();
//
//
//
//    @Test
//    void testBuildCart(){
//        CartItem cItem = CartItemFactory.buildCart("1202","#1432","000100",14.50);
//        list.add(cItem);
//        Cart cart = CartFactory.buildCart("#1432","0808",60.0,list);
//        assertNotNull(cart);
//        System.out.println(cart.toString());
//    }
//
//    @Test
//    void testBuildCartWithFail(){
//        CartItem cItem = CartItemFactory.buildCart("1202","","000100",14.50);
//        list.add(cItem);
//        Cart cart = CartFactory.buildCart("","0808",60.0,list);
//        assertNotNull(cart);
//        System.out.println(cart.toString());
//    }
//}