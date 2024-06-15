package com.leedarson.platform.u202120418.devices.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * Record class for Manufacturer of sensor.
 * @author Fiorella Jarama Peñaloza
 */
@Embeddable
public record Manufacturer(String manufacturer) {
    private static final int MAX_LENGTH = 100;

    public Manufacturer {
        if (manufacturer == null) {
            throw new IllegalArgumentException("Manufacturer cannot be null");
        }
        if (manufacturer.isBlank()) {
            throw new IllegalArgumentException("Manufacturer cannot be empty");
        }
        if (manufacturer.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("Manufacturer cannot be longer than " + MAX_LENGTH + " characters");
        }
    }

    public String getManufacturer() {
        return manufacturer;
    }
}