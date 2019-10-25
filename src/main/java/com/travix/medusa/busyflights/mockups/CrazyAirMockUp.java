package com.travix.medusa.busyflights.mockups;

import com.travix.medusa.busyflights.business.CabinClassEnum;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/crazyAir")
public class CrazyAirMockUp {
    @RequestMapping(value = "/search", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<CrazyAirResponse> search(@RequestBody CrazyAirRequest crazyAirsRequest) {
        //Echo request data:
        CrazyAirResponse response = new CrazyAirResponse();
        List<CrazyAirResponse.CrazyAirFlight> flights = new ArrayList<>();
        CrazyAirResponse.CrazyAirFlight flight = new CrazyAirResponse.CrazyAirFlight();
        flight.setAirline("Airline 1");
        flight.setPrice(100);
        flight.setCabinClass(CabinClassEnum.ECONOMY.getName());
        flight.setDepartureAirportCode(crazyAirsRequest.getOrigin());
        flight.setDestinationAirportCode(crazyAirsRequest.getDestination());
        flight.setDepartureDate(crazyAirsRequest.getDepartureDate());
        flight.setArrivalDate(crazyAirsRequest.getReturnDate());
        flights.add(flight);

        CrazyAirResponse.CrazyAirFlight flight2 = new CrazyAirResponse.CrazyAirFlight();
        flight2.setAirline("airline 2");
        flight2.setPrice(200);
        flight2.setCabinClass(CabinClassEnum.BUSINESS.getName());
        flight2.setDepartureAirportCode(crazyAirsRequest.getOrigin());
        flight2.setDestinationAirportCode(crazyAirsRequest.getDestination());
        flight2.tsetDepartureDate(crazyAirsRequest.getDepartureDate());
        flight2.setArrivalDate(crazyAirsRequest.getReturnDate());
        flights.add(flight2);

        response.setFlights(flights);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
