package com.leedarson.platform.u202120418.devices.interfaces.rest.resources;

/**
 * CreateSensorResource - Resource for creating a sensor.
 * @author Fiorella Jarama Peñaloza
 */
public record CreateSensorResource(
        String name,
        Long sensorType,
        String description,
        String manufacturer,
        String referenceImageUrl) {
}
