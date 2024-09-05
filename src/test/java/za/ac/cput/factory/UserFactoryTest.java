package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.User;

import static org.junit.jupiter.api.Assertions.*;

class UserFactoryTest {
    @Test
    void buildUser() {
        Address address = new Address.Builder()
                .setAddressID("12345")
                .setStreet("Main Street")
                .setCity("Cape Town")
                .setProvince("Western Cape")
                .setZipCode("8000")
                .build();


        User user = UserFactory.createUser("I7I775", "Nicole", "Smith", "password123", "nicole@example.com", "12345","115445");


        assertNotNull(user);
        assertEquals("I7I775", user.getUserID());
        assertEquals("Nicole", user.getFirstName());
        assertEquals("Smith", user.getLastName());
        assertEquals("password123", user.getPassword());
        assertEquals("nicole@example.com", user.getEmail());
        assertEquals("12345", user.getAddressID());

        System.out.println(user);
    }
}
