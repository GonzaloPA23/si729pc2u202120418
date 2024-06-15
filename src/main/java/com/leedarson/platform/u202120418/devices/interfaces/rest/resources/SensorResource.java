package com.leedarson.platform.u202120418.devices.interfaces.rest.resources;

/**
 * SensorResource - Resource for the sensor.
 * @author Fiorella Jarama Peñaloza
 */
public record SensorResource(
        Long id,
        String name,
        Long sensorType,
        String description,
        String manufacturer,
        String referenceImageUrl) {
}
