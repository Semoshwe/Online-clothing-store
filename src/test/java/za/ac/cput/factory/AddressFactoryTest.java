package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.User;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AddressFactoryTest {
    @Test
    void buildAddress() {
        Address address = AddressFactory.buildAddress(
                2L,
                3L,
                "445 floop str",
                "CapeTown",
                "South Africa",
                "3344",
                "0735568763",
                LocalDate.now(),
                null);

        assertNotNull(address);
        System.out.println(address);
    }
}