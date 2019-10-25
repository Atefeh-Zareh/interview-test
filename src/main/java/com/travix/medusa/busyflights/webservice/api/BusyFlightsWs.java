package com.travix.medusa.busyflights.webservice.api;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import org.springframework.http.ResponseEntity;

public interface BusyFlightsWs {
    ResponseEntity<BusyFlightsResponse> busyFlightsSearch(BusyFlightsRequest busyFlightsRequest);
}
