package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.User;

public class CustomerFactoryTest {

    @Test
    void createCustomer() {
        // My User object to pass to the CustomerFactory
        Address address = new Address.Builder()
                .setAddressID("1111")
                .setStreet("16 Adderly street")
                .setCity("Cape Town")
                .setProvince("Western Cape")
                .setZipCode("95000")
                .build(); // Ensure the build method is called

        User user = new User.Builder()
                .setUserID("user123")
                .setFirstName("Rethabile")
                .setLastName("Ntsekhe")
                .setPassword("pass")
                .setEmail("220455430@mycput.ac.za")
                .setAddress(address)
                .build();

        Customer createdCustomer = CustomerFactory.createCustomer("23L", "Premium", "1234");
        System.out.println(createdCustomer);

        // Validate that the Customer object is not null and has correct attributes
        assertNotNull(createdCustomer);
        assertEquals("123", createdCustomer.getCustomerId());
        assertEquals("Premium", createdCustomer.getPrivileges());
        assertEquals("user123", createdCustomer.getUser().getUserID());
    }
}
