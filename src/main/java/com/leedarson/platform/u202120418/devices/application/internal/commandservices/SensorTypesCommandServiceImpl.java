package com.leedarson.platform.u202120418.devices.application.internal.commandservices;

import com.leedarson.platform.u202120418.devices.domain.model.commands.SeedSensorCommand;
import com.leedarson.platform.u202120418.devices.domain.model.entities.SensorType;
import com.leedarson.platform.u202120418.devices.domain.model.valueobjects.SensorTypes;
import com.leedarson.platform.u202120418.devices.domain.services.SensorTypeCommandService;
import com.leedarson.platform.u202120418.devices.infrastructure.persistence.jpa.repositories.SensorTypeRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class SensorTypesCommandServiceImpl implements SensorTypeCommandService {

    private final SensorTypeRepository sensorTypeRepository;

    public SensorTypesCommandServiceImpl(SensorTypeRepository sensorTypeRepository) {
        this.sensorTypeRepository = sensorTypeRepository;
    }

    @Override
    public void handle(SeedSensorCommand command) {
        Arrays.stream(SensorTypes.values()).forEach(sensorType -> {
            if (!sensorTypeRepository.existsByName(sensorType)) {
                sensorTypeRepository.save(new SensorType(null, sensorType));
            }
        });
    }
}
