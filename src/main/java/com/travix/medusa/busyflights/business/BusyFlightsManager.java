package com.travix.medusa.busyflights.business;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BusyFlightsManager {
    private static final String CRAZY_AIR_WS = "http://localhost:8080/crazyAir/search";
    private static final String JET_SEARCH_WS = "http://localhost:8080/toughJet/search";
    private static RestTemplate restTemplate = new RestTemplate();
    private static Mapper mapper = new DozerBeanMapper();

    public BusyFlightsResponse search(BusyFlightsRequest busyFlightsRequest) {
        //  CrazyAir
        CrazyAirRequest crazyAirRequest = new CrazyAirRequest();
        mapper.map(busyFlightsRequest, crazyAirRequest);
        crazyAirRequest.setPassengerCount(busyFlightsRequest.getNumberOfPassengers());
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = null;
        try {
            json = ow.writeValueAsString(crazyAirRequest);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println("CrazyAir input json = " + json);
        ResponseEntity<CrazyAirResponse> crazyAirResponse = restTemplate.postForEntity(CRAZY_AIR_WS,
                busyFlightsRequest, CrazyAirResponse.class);
        try {
            json = ow.writeValueAsString(crazyAirResponse.getBody());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println("CrazyAir output json = " + json);

        //ToughJet
        ToughJetRequest toughJetRequest = new ToughJetRequest();
        toughJetRequest.setFrom(busyFlightsRequest.getOrigin());
        toughJetRequest.setTo(busyFlightsRequest.getDestination());
        toughJetRequest.setOutboundDate(busyFlightsRequest.getDepartureDate());
        toughJetRequest.setInboundDate(busyFlightsRequest.getReturnDate());
        toughJetRequest.setNumberOfAdults(busyFlightsRequest.getNumberOfPassengers());
        ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            json = ow.writeValueAsString(toughJetRequest);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println("ToughJet input json = " + json);
        ResponseEntity<ToughJetResponse> toughJetResponse = restTemplate.postForEntity(JET_SEARCH_WS,
                toughJetRequest, ToughJetResponse.class);
        try {
            json = ow.writeValueAsString(toughJetResponse.getBody());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println("ToughJet output json = " + json);

        //out put
        CrazyAirResponse crazyAirResponseResult = crazyAirResponse.getBody();
        ToughJetResponse toughJetResponseResult = toughJetResponse.getBody();

        List<CrazyAirResponse.CrazyAirFlight> crazyFlights = crazyAirResponseResult.getFlights();
        List<ToughJetResponse.ToughJetFlight> toughJetFlights = toughJetResponseResult.getFlights();

        List<BusyFlightsResponse.Flight> finalFlights = new ArrayList<>();
        for (CrazyAirResponse.CrazyAirFlight crazyAirFlight : crazyFlights) {
            BusyFlightsResponse.Flight flight = new BusyFlightsResponse.Flight();
            mapper.map(crazyAirFlight, flight);
            flight.setFare(crazyAirFlight.getPrice());
            flight.setSupplier(SupplierEnum.CRAZY_AIR.getName());
            finalFlights.add(flight);
        }

        for (ToughJetResponse.ToughJetFlight toughJetFlight : toughJetFlights) {
            BusyFlightsResponse.Flight flight = new BusyFlightsResponse.Flight();
            flight.setAirline(toughJetFlight.getDepartureAirportName());
            flight.setDepartureDate(toughJetFlight.getOutboundDateTime());
            flight.setArrivalDate(toughJetFlight.getInboundDateTime());
            flight.setDepartureAirportCode(toughJetFlight.getDepartureAirportName());
            flight.setDestinationAirportCode(toughJetFlight.getDepartureAirportName());
            flight.setFare(toughJetFlight.getFare());
            flight.setSupplier(SupplierEnum.CRAZY_AIR.getName());
            finalFlights.add(flight);
        }

        Collections.sort(finalFlights);
        BusyFlightsResponse busyFlightsResponse = new BusyFlightsResponse();
        busyFlightsResponse.setFlights(finalFlights);
        return busyFlightsResponse;
    }
}
