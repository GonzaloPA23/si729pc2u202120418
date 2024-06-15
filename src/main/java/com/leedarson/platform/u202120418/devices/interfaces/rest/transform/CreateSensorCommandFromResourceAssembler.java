package com.leedarson.platform.u202120418.devices.interfaces.rest.transform;/**
 * @author Fiorella Jarama Peñaloza
 */

import com.leedarson.platform.u202120418.devices.domain.model.commands.CreateSensorCommand;
import com.leedarson.platform.u202120418.devices.interfaces.rest.resources.CreateSensorResource;
import com.leedarson.platform.u202120418.devices.interfaces.rest.resources.SensorResource;

/**
 * CreateSensorCommandFromResourceAssembler - Assembler for creating a sensor command from a resource.
 *
 * @author Fiorella Jarama Peñaloza
 */
public class CreateSensorCommandFromResourceAssembler {
    public static CreateSensorCommand toCommandFromResource(CreateSensorResource resource) {
        return new CreateSensorCommand(resource.name(), resource.sensorType(),resource.description(), resource.manufacturer(), resource.referenceImageUrl());
    }
}
