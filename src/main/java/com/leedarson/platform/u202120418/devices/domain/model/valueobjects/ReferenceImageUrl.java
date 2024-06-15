package com.leedarson.platform.u202120418.devices.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * Record class for ReferenceImageUrl of sensor.
 * @author Fiorella Jarama Peñaloza
 */
@Embeddable
public record ReferenceImageUrl(String referenceImageUrl) {

    public ReferenceImageUrl {
        if (referenceImageUrl == null) {
            throw new IllegalArgumentException("Reference image URL cannot be null");
        }
        if (referenceImageUrl.isBlank()) {
            throw new IllegalArgumentException("Reference image URL cannot be empty");
        }
    }

    public String getReferenceImageUrl() {
        return referenceImageUrl;
    }
}