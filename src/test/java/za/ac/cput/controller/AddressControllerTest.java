package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.domain.Address;
import za.ac.cput.factory.AddressFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * AddressControllerTest.java
 * <p>
 * This class contains integration tests for the AddressController endpoints.
 * It tests the creation, reading, updating, and retrieval of all addresses
 * through the AddressController endpoints.
 * </p>
 *
 * <p>
 * The tests use Spring Boot's TestRestTemplate to interact with the application
 * context and verify that the controller methods are functioning correctly.
 * </p>
 *
 * @author [Your Name]
 * @date [Current Date]
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AddressControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "/address";
    private static Address address1;

    /**
     * Sets up the test environment by creating a sample Address object.
     */
    @BeforeAll
    public static void setUp() {
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
    }

    /**
     * Tests the creation of an address through the /create endpoint.
     */
    @Test
    @Order(1)
    void create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Address> postResponse = restTemplate.postForEntity(url, address1, Address.class);
        assertNotNull(postResponse.getBody(), "The response body should not be null");
        assertEquals(address1.getAddressID(), postResponse.getBody().getAddressID(), "The AddressID should match");
        assertEquals(HttpStatus.CREATED, postResponse.getStatusCode(), "The status code should be 201 Created");
        System.out.println(postResponse.getBody());
    }

    /**
     * Tests the reading of an address through the /read/{id} endpoint.
     */
    @Test
    @Order(2)
    void read() {
        String url = BASE_URL + "/read/" + address1.getAddressID();
        ResponseEntity<Address> response = restTemplate.getForEntity(url, Address.class);
        assertNotNull(response.getBody(), "The response body should not be null");
        assertEquals(address1.getAddressID(), response.getBody().getAddressID(), "The AddressID should match");
        assertEquals(HttpStatus.OK, response.getStatusCode(), "The status code should be 200 OK");
        System.out.println(response.getBody());
    }

    /**
     * Tests the updating of an address through the /update endpoint.
     */
    @Test
    @Order(3)
    void update() {
        String url = BASE_URL + "/update";
        Address updatedAddress = new Address.Builder()
                .copy(address1)
                .setAddressLine("456 Elm St")
                .setCountry("Nigeria")
                .build();
        ResponseEntity<Address> postResponse = restTemplate.postForEntity(url, updatedAddress, Address.class);
        assertNotNull(postResponse.getBody(), "The response body should not be null");
        assertEquals(updatedAddress.getAddressID(), postResponse.getBody().getAddressID(), "The AddressID should match");
        assertEquals(HttpStatus.OK, postResponse.getStatusCode(), "The status code should be 200 OK");
        System.out.println(postResponse.getBody());
    }

    /**
     * Tests retrieving all addresses through the /getAll endpoint.
     */
    @Test
    @Order(4)
    void getAll() {
        String url = BASE_URL + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody(), "The response body should not be null");
        assertEquals(HttpStatus.OK, response.getStatusCode(), "The status code should be 200 OK");
        System.out.println(response.getBody());
    }
}
