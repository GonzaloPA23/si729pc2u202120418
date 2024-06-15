package com.leedarson.platform.u202120418.devices.application.internal.commandservices;

import com.leedarson.platform.u202120418.devices.domain.model.aggregates.Sensor;
import com.leedarson.platform.u202120418.devices.domain.model.commands.CreateSensorCommand;
import com.leedarson.platform.u202120418.devices.domain.services.SensorCommandService;
import com.leedarson.platform.u202120418.devices.infrastructure.persistence.jpa.repositories.SensorRepository;
import com.leedarson.platform.u202120418.devices.infrastructure.persistence.jpa.repositories.SensorTypeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * SensorCommandServicesImpl - Implementation of the command services for Sensors
 *
 * @author Fiorella Jarama Peñaloza
 */
@Service
public class SensorCommandServicesImpl implements SensorCommandService {

    private final SensorRepository sensorRepository;
    private final SensorTypeRepository sensorTypeRepository;

    public SensorCommandServicesImpl(SensorRepository sensorRepository, SensorTypeRepository sensorTypeRepository) {
        this.sensorRepository = sensorRepository;
        this.sensorTypeRepository = sensorTypeRepository;
    }

    @Override
    public Optional<Sensor> handle(CreateSensorCommand command) {
        var sensor = new Sensor(command);

        if (sensor.getSensorType() != null && sensor.getSensorType().getId() != null) {
            sensor.setSensorType(sensorTypeRepository.getById(sensor.getSensorType().getId()));
        }

        sensorRepository.save(sensor);
        return Optional.of(sensor);
    }
}
