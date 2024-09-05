package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import za.ac.cput.domain.Address;
import za.ac.cput.factory.AddressFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Configuration
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AddressServiceTest {
    @Autowired
    private AddressService addressService;
    private static Address address1;
    private static Address address2;

    @BeforeEach
    @Order(1)
    @Test
    void setup(){
        address1 = AddressFactory.buildAddress("102ADD","Long St","Lillies","WesternCape","2356");
        assertNotNull(address1);
        System.out.println(address1);

        address2 = AddressFactory.buildAddress("12223f","capetown","Jahana", "Western cape", "8001");
        assertNotNull(address2);
        System.out.println(address2);

    }
    @Order(2)
    @Test
    void create() {
        Address created1 = addressService.create(address1);
        assertNotNull(created1);
        System.out.println(created1);

        Address createdaddres2 = addressService.create(address2);
        assertNotNull(createdaddres2);
        System.out.println(createdaddres2);
    }
    @Order(3)
    @Test
    void read() {
        Address read = addressService.read(address1.getAddressID());
        assertNotNull(read);
        System.out.println(read);

    }
    @Order(4)
    @Test
    void update() {
        Address newaddress = new Address.Builder().copy(address1).setProvince("Gauteng").build();
        Address updated = addressService.update(newaddress);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Order(5)
    @Test
    void getall() {
        System.out.println(addressService.findAll());
    }
}