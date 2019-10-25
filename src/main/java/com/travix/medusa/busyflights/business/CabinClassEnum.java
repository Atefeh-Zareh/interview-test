package com.travix.medusa.busyflights.business;

public enum CabinClassEnum {
    ECONOMY("E"), BUSINESS("B");

    private String name;

    CabinClassEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
