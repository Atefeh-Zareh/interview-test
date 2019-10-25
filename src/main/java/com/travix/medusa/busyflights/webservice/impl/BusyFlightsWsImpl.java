package com.travix.medusa.busyflights.webservice.impl;

import com.travix.medusa.busyflights.business.BusyFlightsManager;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.webservice.api.BusyFlightsWs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/busyFlights")
public class BusyFlightsWsImpl implements BusyFlightsWs {
    @Autowired
    BusyFlightsManager busyFlightsManager;

    @Override
    @RequestMapping(value = "/search", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<BusyFlightsResponse> busyFlightsSearch(@RequestBody BusyFlightsRequest busyFlightsRequest) {
        BusyFlightsResponse busyFlightsResponse = busyFlightsManager.search(busyFlightsRequest);
        return new ResponseEntity(busyFlightsResponse, HttpStatus.OK);
    }
}
