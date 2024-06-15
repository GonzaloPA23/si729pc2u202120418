package com.leedarson.platform.u202120418.devices.infrastructure.persistence.jpa.repositories;

import com.leedarson.platform.u202120418.devices.domain.model.aggregates.Sensor;
import com.leedarson.platform.u202120418.devices.domain.model.entities.SensorType;
import com.leedarson.platform.u202120418.devices.domain.model.valueobjects.Manufacturer;
import com.leedarson.platform.u202120418.devices.domain.model.valueobjects.Name;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * SensorRepository - Repository for Sensors
 * @author Fiorella Jarama Peñaloza
 */
public interface SensorRepository extends JpaRepository<Sensor, Long> {
}
