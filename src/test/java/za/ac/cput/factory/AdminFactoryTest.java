package za.ac.cput.factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
 *AdminFactoryTest:java
 *Admin: Factory Class Test
 * Author: Luke Duffell
 * Student no: 217061567
 * Date: 17 May 2024
 */

class AdminFactoryTest {

    @Test
    void buildAdmin() {
        Admin admin = AdminFactory.buildAdmin("217061567", "Relaxed");

        assertNotNull(admin);
        System.out.println(admin);
    }
}