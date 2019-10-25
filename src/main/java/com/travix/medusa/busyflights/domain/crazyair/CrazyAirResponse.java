package com.travix.medusa.busyflights.domain.crazyair;

import java.util.List;

public class CrazyAirResponse {
    private List<CrazyAirFlight> flights;

    public List<CrazyAirFlight> getFlights() {
        return flights;
    }

    public void setFlights(List<CrazyAirFlight> flights) {
        this.flights = flights;
    }

    public static class CrazyAirFlight {
        private String airline;
        private double price;
        private String cabinClass;
        private String departureAirportCode;
        private String destinationAirportCode;
        private String departureDate;
        private String arrivalDate;

        public String getAirline() {
            return airline;
        }

        public void setAirline(final String airline) {
            this.airline = airline;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(final double price) {
            this.price = price;
        }

        public String getCabinClass() {
            return cabinClass;
        }

        public void setCabinClass(final String cabinClass) {
            this.cabinClass = cabinClass;
        }

        public String getDepartureAirportCode() {
            return departureAirportCode;
        }

        public void setDepartureAirportCode(final String departureAirportCode) {
            this.departureAirportCode = departureAirportCode;
        }

        public String getDestinationAirportCode() {
            return destinationAirportCode;
        }

        public void setDestinationAirportCode(final String destinationAirportCode) {
            this.destinationAirportCode = destinationAirportCode;
        }

        public String getDepartureDate() {
            return departureDate;
        }

        public void setDepartureDate(final String departureDate) {
            this.departureDate = departureDate;
        }

        public String getArrivalDate() {
            return arrivalDate;
        }

        public void setArrivalDate(final String arrivalDate) {
            this.arrivalDate = arrivalDate;
        }
    }


}
