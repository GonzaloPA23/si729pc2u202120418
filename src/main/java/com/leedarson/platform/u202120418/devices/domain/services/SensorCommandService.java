package com.leedarson.platform.u202120418.devices.domain.services;

import com.leedarson.platform.u202120418.devices.domain.model.aggregates.Sensor;
import com.leedarson.platform.u202120418.devices.domain.model.commands.CreateSensorCommand;

import java.util.Optional;

/**
 * SensorCommandService - Interface for the service that handles the commands for the sensor.
 * @author Fiorella Jarama Peñaloza
 */
public interface SensorCommandService {
    /**
     * Handle the command to create a sensor.
     * @param command The command to create a sensor.
     * @return The sensor created.
     */
    Optional<Sensor> handle(CreateSensorCommand command);
}
