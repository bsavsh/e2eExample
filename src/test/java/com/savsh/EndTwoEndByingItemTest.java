package com.savsh;


import com.savsh.entity.Customer;
import com.savsh.entity.Item;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;


import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;
import static org.springframework.http.HttpStatus.OK;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EndTwoEndByingItemTest {

    @LocalServerPort
    private int port;

    @Before()
    public void setUp() {
        RestAssured.port = port;
        String baseHost = System.getProperty("server.host");
        if (baseHost == null) {
            baseHost = "http://localhost";
        }
        RestAssured.baseURI = baseHost;
    }

    @Test
    public void testFavoriteAndBusketFunctionality() {
        Customer julia = given().param("firstName", "Julia").param("lastName", "Mykytyn").when().post("/customer").body().as(Customer.class);
        given().when().get(urlProductBySku()).then().statusCode(OK.value());
        Item item = given().when().get(urlProductBySku()).body().as(Item.class);
        given().when()
                .post(getUrlToAddItemToBusketFor(julia, item))
                .then().statusCode(OK.value());
        given().when()
                .get(urlToGetItemsFromBusket(julia))
                .then().assertThat().body("size", is(1))
                .statusCode(OK.value());
        given().when()
                .get(urlToGetItemsfromFavorite(julia))
                .then().assertThat().body("size", is(0))
                .statusCode(OK.value());
    }


    @Test
    public void buyOrderFromFavorite() {
        Customer bohdan = given().param("firstName", "Bohdan").param("lastName", "Savshak").when().post("/customer").body().as(Customer.class);

        given().when().get(urlProductBySku()).then().statusCode(OK.value());
        Item item = given().when().get(urlProductBySku()).body().as(Item.class);

        given().when()
                .post(getUrlToAddItemToFavoriteFor(bohdan, item)).then()
                .statusCode(OK.value());
        given().when()
                .get(urlToGetItemsFromBusket(bohdan))
                .then().assertThat().body("size", is(0))
                .statusCode(OK.value());
        given().when()
                .get(urlToGetItemsfromFavorite(bohdan))
                .then().assertThat().body("size", is(1))
                .statusCode(OK.value());

        given().when()
                .post(urlToBuyOrder(bohdan, item))
                .then().statusCode(OK.value());

        given().when()
                .get(urlToGetCustomersOrder(bohdan))
                .then().body("size", is(1))
                .statusCode(OK.value());
    }

    private String urlToBuyOrder(Customer bohdan, Item item) {
        return String.format("shopping/user/%S/item/%s/order", bohdan.getId(), item.getId());
    }

    private String urlToGetCustomersOrder(Customer customer) {
        return String.format("/order/customer/%s", customer.getId());
    }

    private String urlToGetItemsfromFavorite(Customer customer) {
        return String.format(("/customer/%s/favorite"), customer.getId());
    }

    private String urlToGetItemsFromBusket(Customer customer) {
        return String.format("/customer/%s/busket", customer.getId());
    }

    private String urlProductBySku() {
        return String.format("/product/bysku/%s", "SKU-1");
    }

    private String getUrlToAddItemToBusketFor(Customer customer, Item item) {
        return String.format("/shopping/busket/user/%s/item/%s", customer.getId(), item.getId());
    }

    private String getUrlToAddItemToFavoriteFor(Customer customer, Item item) {
        return String.format("/shopping/favorite/user/%s/item/%s", customer.getId(), item.getId());
    }


}
