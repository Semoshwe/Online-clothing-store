package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import za.ac.cput.domain.Address;
import za.ac.cput.factory.AddressFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AddressServiceTest {
@Autowired
private AddressService addressService;
private static Address address1;
private static Address address2;


    @BeforeEach
    @Test
    void a_setup(){

        address1 = AddressFactory.buildAddress("Ad87","56 Loop","CapeTown","Western Cape","7925");
        assertNotNull(address1);
        System.out.println(address1);

        address2 = AddressFactory.buildAddress("Ad88", "35 Loop", "Milnerton","Western Cape","7835");
        assertNotNull(address2);
        System.out.println(address2);}


    @Test
    void b_create() {
        Address created1 = addressService.create(address1);
        assertNotNull(created1);
        System.out.println(created1);

        Address created2 = addressService.create(address2);
        assertNotNull(created2);
        System.out.println(created2);

    }

    @Test
    void c_read() {

        Address read = addressService.read(address1.getAddressID());
        assertNotNull(read);
        System.out.println(read);
    }

    @Order(4)
    @Test
    void update(){
        Address newAddress = new Address.Builder().copy(address1).setAddressID("3344h").build();
        Address updated = addressService.update(newAddress);
        assertNotNull(updated);
        System.out.println(updated);

    }

    @Order(5)
    @Test
    void getall(){
        System.out.println(addressService.getAll());
    }
}

