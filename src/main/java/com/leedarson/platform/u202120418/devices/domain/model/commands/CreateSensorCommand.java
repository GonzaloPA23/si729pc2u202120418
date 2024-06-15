package com.leedarson.platform.u202120418.devices.domain.model.commands;

/**
 * Command to create a sensor.
 * @author Fiorella Jarama Peñaloza
 */
public record CreateSensorCommand(
        String name,
        Long sensorTypeId,
        String description,
        String manufacturer,
        String referenceImageUrl) {
}
