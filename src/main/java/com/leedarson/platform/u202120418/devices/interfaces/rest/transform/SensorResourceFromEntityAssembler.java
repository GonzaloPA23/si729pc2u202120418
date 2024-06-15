package com.leedarson.platform.u202120418.devices.interfaces.rest.transform;/**
 * @author Fiorella Jarama Peñaloza
 */

import com.leedarson.platform.u202120418.devices.domain.model.aggregates.Sensor;
import com.leedarson.platform.u202120418.devices.interfaces.rest.resources.SensorResource;

/**
 * SensorResourceFromEntityAssembler - Assembler for creating a sensor resource from an entity.
 *
 * @author Fiorella Jarama Peñaloza
 */
public class SensorResourceFromEntityAssembler {
    /**
     * Transforms a Sensor entity into a SensorResource.
     * @param sensor
     * @return the SensorResource.
     */
    public static SensorResource toResourceFromEntity(Sensor sensor) {
        return new SensorResource(
                sensor.getId(),
                sensor.getName(),
                sensor.getSensorType().getId(),
                sensor.getDescription(),
                sensor.getManufacturer(),
                sensor.getReferenceImageUrl());
    }
}
