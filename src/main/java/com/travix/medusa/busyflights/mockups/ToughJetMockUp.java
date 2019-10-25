package com.travix.medusa.busyflights.mockups;

import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/toughJet")
public class ToughJetMockUp {
    @RequestMapping(value = "/search", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<ToughJetResponse> search(@RequestBody ToughJetRequest toughJetsRequest) {
        //Echo request data:
        ToughJetResponse response = new ToughJetResponse();
        List<ToughJetResponse.ToughJetFlight> flights = new ArrayList<>();

        ToughJetResponse.ToughJetFlight flight = new ToughJetResponse.ToughJetFlight();
        flight.setCarrier("airline name for ToughJet");
        flight.setBasePrice(300);
        flight.setTax(50);
        flight.setDiscount(50);
        flight.setDepartureAirportName(toughJetsRequest.getFrom());
        flight.setArrivalAirportName(toughJetsRequest.getTo());
        flight.setOutboundDateTime(toughJetsRequest.getOutboundDate());
        flight.setInboundDateTime(toughJetsRequest.getInboundDate());
        flights.add(flight);

        ToughJetResponse.ToughJetFlight flight2 = new ToughJetResponse.ToughJetFlight();
        flight2.setCarrier("airline name for ToughJet 2");
        flight2.setBasePrice(200);
        flight2.setTax(20);
        flight2.setDiscount(40);
        flight2.setDepartureAirportName(toughJetsRequest.getFrom());
        flight2.setArrivalAirportName(toughJetsRequest.getTo());
        flight2.setOutboundDateTime(toughJetsRequest.getOutboundDate());
        flight2.setInboundDateTime(toughJetsRequest.getInboundDate());
        flights.add(flight2);

        response.setFlights(flights);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
