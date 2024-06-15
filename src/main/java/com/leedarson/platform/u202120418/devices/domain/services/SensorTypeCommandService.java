package com.leedarson.platform.u202120418.devices.domain.services;

import com.leedarson.platform.u202120418.devices.domain.model.commands.SeedSensorCommand;

/**
 * Service to handle sensor type commands.
 * @author Fiorella Jarama Peñaloza
 */
public interface SensorTypeCommandService {
    void handle(SeedSensorCommand command);
}