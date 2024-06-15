package com.leedarson.platform.u202120418.devices.application.internal.eventhandlers;

import com.leedarson.platform.u202120418.devices.domain.model.commands.SeedSensorCommand;
import com.leedarson.platform.u202120418.devices.domain.services.SensorTypeCommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * ApplicationReadyEventHandler class
 * This class is used to handle the ApplicationReadyEvent
 * @author Fiorella Jarama Peñaloza
 */
@Service
public class ApplicationReadyEventHandler {
    private final SensorTypeCommandService sensorTypeCommandService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationReadyEventHandler.class);

    public ApplicationReadyEventHandler(SensorTypeCommandService sensorTypeCommandService) {
        this.sensorTypeCommandService = sensorTypeCommandService;
    }

    /**
     * Handle the ApplicationReadyEvent
     * This method is used to seed the roles
     * @param event the ApplicationReadyEvent the event to handle
     */
    @EventListener
    public void on(ApplicationReadyEvent event) {
        var applicationName = event.getApplicationContext().getId();
        LOGGER.info("Starting to verify if roles seeding is needed for {} at {}", applicationName, currentTimestamp());
        var seedRolesCommand = new SeedSensorCommand();
        sensorTypeCommandService.handle(seedRolesCommand);
        LOGGER.info("Roles seeding verification finished for {} at {}", applicationName, currentTimestamp());
    }

    private Timestamp currentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }
}