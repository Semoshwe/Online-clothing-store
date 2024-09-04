package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import za.ac.cput.domain.Address;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.repository.AddressRepository;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AddressServiceTest {
    @Autowired
    private AddressService addressService;
    private static Address address1;
    private static Address address2;
    @Autowired
    private AddressRepository repository;

    @BeforeEach
    void setup(){
        Set<String> roles = new HashSet<>();
        roles.add("User");

        address1 = AddressFactory.buildAddress(
                1L,
                1L,
                "10 Sir Street",
                "Cape Town",
                "South Africa",
                "22335",
                "0863345678",
                LocalDate.now(),
                null);
        assertNotNull(address1);
        System.out.println(address1);

        address2 = AddressFactory.buildAddress(
                2L,
                2L,
                "134 Sally Str",
                "Benoni",
                "South Africa",
                "1453",
                "0857389930",
                LocalDate.now(),
                null);
        assertNotNull(address2);
        System.out.println(address2);
//
        repository.save(address1);
        repository.save(address2);

    }

    /**
     * Cleans up the repository after each test.
     */
    @AfterEach
    void tearDown(){
        repository.deleteAll();
    }

    /**
     * Tests the create method of AddressService.
     */
    @Order(1)
    @Test
    void create() {
        Address created = addressService.create(address1);
        assertNotNull(created, "Created address should not be null");
        assertNotNull(created.getAddressID(), "AddressID should not be null");
        assertEquals(address1.getAddressLine(), created.getAddressLine(), "Address lines should match");
        System.out.println(created);
    }

       // Address createdaddres2 = addressService.create(address2);
     //   assertNotNull(createdaddres2);
     //   System.out.println(createdaddres2);
   // }
    /**
     * Tests the read method of AddressService.
     */
    @Order(2)
    @Test
    void read() {
        Address read = addressService.read(address1.getAddressID());
        assertNotNull(read, "Read address should not be null");
        assertEquals("10 Sir Street", read.getAddressLine(), "Address line should match");
        System.out.println(read);
    }
    /**
     * Tests the update method of AddressService.
     */
    @Test
    void testUpdateAddress() {
        // Create and save the address
        Address createdAddress = addressService.create(address1);
        System.out.println("Created for test update by Id" + '\n' + createdAddress + '\n');

        // Use the same AddressID from the created address
        createdAddress = new Address.Builder()
                .copy(createdAddress)
                .setAddressLine("456 Elm St")
                .setCountry("Nigeria")
                .build();

        // Attempt to update using the correct AddressID
        Address updatedAddress = addressService.update(createdAddress);

        System.out.println("Here is the updated Address" + updatedAddress);
        assertNotNull(updatedAddress);
        assertEquals(createdAddress.getAddressLine(), updatedAddress.getAddressLine(), "Address lines should match");
    }





    /**
     * Tests the findByUserId method of AddressService.
     */
    @Order(4)
    @Test
    void findByUserId() {
        Optional<Address> found = addressService.findByUserId(1L);
        assertTrue(found.isPresent(), "Address should be found by UserID");
        assertEquals("10 Sir Street", found.get().getAddressLine(), "Address line should match");
        System.out.println(found.get());
    }

    /**
     * Tests the findByAddressLine method of AddressService.
     */
    @Order(5)
    @Test
    void findByAddressLine() {
        List<Address> found = addressService.findByAddressLine("10 Sir Street");
        assertFalse(found.isEmpty(), "Address list should not be empty");
        assertEquals("10 Sir Street", found.get(0).getAddressLine(), "Address line should match");
        System.out.println(found);
    }

    /**
     * Tests the findByZipcodes method of AddressService.
     */
    @Order(6)
    @Test
    void findByZipcodes() {
        List<Address> found = addressService.findByZipcodes("22335");
        assertFalse(found.isEmpty(), "Address list should not be empty");
        assertEquals("22335", found.get(0).getZipCode(), "ZipCode should match");
        System.out.println(found);
    }

    /**
     * Tests the findByPhoneNumber method of AddressService.
     */
    @Order(7)
    @Test
    void findByPhoneNumber() {
        List<Address> found = addressService.findByPhoneNumber("0863345678");
        assertFalse(found.isEmpty(), "Address list should not be empty");
        assertEquals("0863345678", found.get(0).getPhoneNumber(), "PhoneNumber should match");
        System.out.println(found);
    }

    /**
     * Tests the findByCountry method of AddressService.
     */
    @Order(8)
    @Test
    void findByCountry() {
        List<Address> found = addressService.findByCountry("South Africa");
        assertFalse(found.isEmpty(), "Address list should not be empty");
        assertEquals("South Africa", found.get(0).getCountry(), "Country should match");
        System.out.println(found);
    }

    /**
     * Tests the findByDeletedAtIsNotNull method of AddressService.
     */
    @Order(9)
    @Test
    void findByDeletedAtIsNotNull() {
        List<Address> found = addressService.findByDeletedAtIsNotNull();
       // assertFalse(found.isEmpty());
        assertNotNull(found.get(0).getDeletedAt());
        System.out.println(found);
    }

    /**
     * Tests the getAll method of AddressService.
     */
    @Order(10)
    @Test
    void getAll() {
        List<Address> allAddresses = addressService.getAll();
        assertFalse(allAddresses.isEmpty(), "Address list should not be empty");
        System.out.println(allAddresses);
    }
}