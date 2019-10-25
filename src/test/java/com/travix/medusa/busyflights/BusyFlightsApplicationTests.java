package com.travix.medusa.busyflights;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusyFlightsApplicationTests {

    private static final String WEB_SERVICE_URL = "http://localhost:8080/busyFlights/search";
    private static RestTemplate restTemplate = new RestTemplate();

    @Test
    public void searchTest() {
        try {
            BusyFlightsRequest busyFlightsRequest = new BusyFlightsRequest();
            busyFlightsRequest.setDepartureDate("10/25/2019");
            busyFlightsRequest.setReturnDate("10/25/2019");
            busyFlightsRequest.setOrigin("MGT");
            busyFlightsRequest.setDestination("LHR");
            busyFlightsRequest.setNumberOfPassengers(1);

            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(busyFlightsRequest);
            System.out.println("input json = " + json);
            ResponseEntity<BusyFlightsResponse> listResponseEntity = restTemplate.postForEntity(WEB_SERVICE_URL,
                    busyFlightsRequest, BusyFlightsResponse.class);

            json = ow.writeValueAsString(listResponseEntity.getBody());
            System.out.println("output json = " + json);
        } catch (Exception ex) {
            fail("error in call rest search service \n" + ex.toString());
        }
    }
}