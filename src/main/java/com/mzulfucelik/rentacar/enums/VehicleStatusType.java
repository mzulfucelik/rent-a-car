package com.mzulfucelik.rentacar.enums;

public enum VehicleStatusType {
    RENTED("RENTED"),
    RENTABLE("RENTABLE");

    private final String value;

    private VehicleStatusType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
