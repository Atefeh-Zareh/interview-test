package com.travix.medusa.busyflights.business;

public enum SupplierEnum {
    CRAZY_AIR("CrazyAir"), TOUGH_JET("ToughJet");

    private String name;

    SupplierEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
