package guru.microservices.msscbreweryclient.web.client;

import guru.microservices.msscbreweryclient.web.model.BeerDto;
import guru.microservices.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Disabled
@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerById() {
        BeerDto dto = client.getBeerById(UUID.fromString("0a818933-087d-47f2-ad83-2f986ed087eb"));

        assertNotNull(dto);

    }

    @Test
    void testSaveNewBeer() {
        //given
        BeerDto beerDto = BeerDto.builder()
                .beerName("New Beer")
                .beerStyle("LAGER")
                .upc("06312750024004")
                .price(new BigDecimal("2.99"))
                .quantityOnHand(15)
                .build();

        URI uri = client.saveNewBeer(beerDto);

        assertNotNull(uri);

        System.out.println(uri.toString());

    }

    @Test
    void testUpdateBeer() {
        //given
        BeerDto beerDto = BeerDto.builder()
                .beerName("New Beer")
                .beerStyle("ALE")
                .upc("06312750024001")
                .price(new BigDecimal("5.99"))
                .build();

        client.updateBeer(UUID.fromString("0a818933-087d-47f2-ad83-2f986ed087eb"), beerDto);

    }

    @Test
    void testDeleteBeer() {
        client.deleteBeer(UUID.fromString("e3a6000b-40d8-429c-a855-a48e51882e09"));
    }

    @Test
    void getCustomerById() {
        CustomerDto dto = client.getCustomerById(UUID.fromString("e3a6000b-40d8-429c-a855-a48e51882e09"));

        assertNotNull(dto);

    }

    @Test
    void testSaveNewCustomer() {
        //given
        CustomerDto customerDto = CustomerDto.builder().name("Joe").build();

        URI uri = client.saveNewCustomer(customerDto);

        assertNotNull(uri);

        System.out.println(uri.toString());

    }

    @Test
    void testUpdateCustomer() {
        //given
        CustomerDto customerDto = CustomerDto.builder().name("Jim").build();

        client.updateCustomer(UUID.randomUUID(), customerDto);

    }

    @Test
    void testDeleteCustomer() {
        client.deleteCustomer(UUID.fromString("e3a6000b-40d8-429c-a855-a48e51882e09"));
    }
}