package com.leedarson.platform.u202120418.devices.infrastructure.persistence.jpa.repositories;

import com.leedarson.platform.u202120418.devices.domain.model.entities.SensorType;
import com.leedarson.platform.u202120418.devices.domain.model.valueobjects.SensorTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * This interface is responsible for providing the SensorType entity related operations.
 * It extends the JpaRepository interface.
 */
@Repository
public interface SensorTypeRepository extends JpaRepository<SensorType, Long> {
    Optional<SensorType> findByName(SensorTypes name);
    boolean existsByName(SensorTypes name);
}