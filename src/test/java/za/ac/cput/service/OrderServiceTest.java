//package za.ac.cput.service;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import za.ac.cput.domain.Orders;
//import za.ac.cput.factory.OrderFactory;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@TestMethodOrder(MethodOrderer.class)
//class OrderServiceTest {
//
//    @Autowired
//    private OrderService orderService;
//
//
//    private Orders order;
//
//    @BeforeEach
//    void setUp() {
//        // Creating test data
//        Long orderID = 1L;
//        String customerID = "1001";
//        LocalDate orderDate = LocalDate.now();
//        String orderItemsID = "1234";
//        double totalPrice = 150.0;
//        String status = "Pending";
//        String addressID = "A100";
//
//        Orders order = OrderFactory.buildOrder(orderID, customerID, orderDate, orderItemsID, totalPrice, status, addressID);
//
//    }
//
//    @Test
//    void create() {
//        Orders createdOrder = orderService.create(order);
//        assertNotNull(createdOrder);
//        assertEquals(order.getOrderID(), createdOrder.getOrderID());
//    }
//
//    @Test
//    void read() {
//        Orders read = orderService.read((Long.toString(order.getOrderID())));
//        assertNotNull(read);
//        System.out.println(read);
//    }
//
//    @Test
//    void update() {
//    }
//
//    @Test
//    void getAll() {
//    }
//}