package com.travix.medusa.busyflights.domain.busyflights;

import java.util.List;

public class BusyFlightsResponse {
    private List<Flight> flights;

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public static class Flight implements Comparable<Flight> {
        private String airline;
        private String supplier;
        private double fare;
        private String departureAirportCode;
        private String destinationAirportCode;
        private String departureDate;
        private String arrivalDate;

        public String getAirline() {
            return airline;
        }

        public void setAirline(String airline) {
            this.airline = airline;
        }

        public String getSupplier() {
            return supplier;
        }

        public void setSupplier(String supplier) {
            this.supplier = supplier;
        }

        public double getFare() {
            return fare;
        }

        public void setFare(double fare) {
            this.fare = fare;
        }

        public String getDepartureAirportCode() {
            return departureAirportCode;
        }

        public void setDepartureAirportCode(String departureAirportCode) {
            this.departureAirportCode = departureAirportCode;
        }

        public String getDestinationAirportCode() {
            return destinationAirportCode;
        }

        public void setDestinationAirportCode(String destinationAirportCode) {
            this.destinationAirportCode = destinationAirportCode;
        }

        public String getDepartureDate() {
            return departureDate;
        }

        public void setDepartureDate(String departureDate) {
            this.departureDate = departureDate;
        }

        public String getArrivalDate() {
            return arrivalDate;
        }

        public void setArrivalDate(String arrivalDate) {
            this.arrivalDate = arrivalDate;
        }

        @Override
        public int compareTo(Flight o) {
            return (int) (this.fare - o.fare);
        }
    }
}
