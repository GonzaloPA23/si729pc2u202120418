package com.leedarson.platform.u202120418.devices.domain.model.valueobjects;
import jakarta.persistence.Embeddable;
/**
 * Record class for Name of sensor.
 * @author Fiorella Jarama Peñaloza
 */

@Embeddable
public record Name(String name) {
    private static final int MAX_LENGTH = 50;

    public Name {
        if (name == null) {
            throw new IllegalArgumentException("Sensor name cannot be null");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("Sensor name cannot be empty");
        }
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("Sensor name cannot be longer than " + MAX_LENGTH + " characters");
        }
    }

    public String getName() {
        return name;
    }
}
