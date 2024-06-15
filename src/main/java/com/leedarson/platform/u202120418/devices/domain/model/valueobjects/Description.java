package com.leedarson.platform.u202120418.devices.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * Record class for Description of sensor.
 * @author Fiorella Jarama Peñaloza
 */
@Embeddable
public record Description(String description) {
    private static final int MAX_LENGTH = 360;

    public Description {
        if (description == null) {
            throw new IllegalArgumentException("Description cannot be null");
        }
        if (description.isBlank()) {
            throw new IllegalArgumentException("Description cannot be empty");
        }
        if (description.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("Description cannot be longer than " + MAX_LENGTH + " characters");
        }
    }

    public String getDescription() {
        return description;
    }
}
