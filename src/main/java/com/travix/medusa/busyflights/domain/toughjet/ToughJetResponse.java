package com.travix.medusa.busyflights.domain.toughjet;

import java.util.List;

public class ToughJetResponse {
    private List<ToughJetFlight> flights;

    public List<ToughJetFlight> getFlights() {
        return flights;
    }

    public void setFlights(List<ToughJetFlight> flights) {
        this.flights = flights;
    }

    public static class ToughJetFlight {
        private String carrier;
        private double basePrice;
        private double tax;
        private double discount;
        private String departureAirportName;
        private String arrivalAirportName;
        private String outboundDateTime;
        private String inboundDateTime;

        public String getCarrier() {
            return carrier;
        }

        public void setCarrier(final String carrier) {
            this.carrier = carrier;
        }

        public double getBasePrice() {
            return basePrice;
        }

        public void setBasePrice(final double basePrice) {
            this.basePrice = basePrice;
        }

        public double getTax() {
            return tax;
        }

        public void setTax(final double tax) {
            this.tax = tax;
        }

        public double getDiscount() {
            return discount;
        }

        public void setDiscount(final double discount) {
            this.discount = discount;
        }

        public String getDepartureAirportName() {
            return departureAirportName;
        }

        public void setDepartureAirportName(final String departureAirportName) {
            this.departureAirportName = departureAirportName;
        }

        public String getArrivalAirportName() {
            return arrivalAirportName;
        }

        public void setArrivalAirportName(final String arrivalAirportName) {
            this.arrivalAirportName = arrivalAirportName;
        }

        public String getOutboundDateTime() {
            return outboundDateTime;
        }

        public void setOutboundDateTime(final String outboundDateTime) {
            this.outboundDateTime = outboundDateTime;
        }

        public String getInboundDateTime() {
            return inboundDateTime;
        }

        public void setInboundDateTime(final String inboundDateTime) {
            this.inboundDateTime = inboundDateTime;
        }


        public double getFare() {
            return basePrice + tax - discount;
        }
    }
}
