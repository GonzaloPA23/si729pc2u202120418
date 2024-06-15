package com.leedarson.platform.u202120418.devices.domain.model.aggregates;/**
 * @author Fiorella Jarama Peñaloza
 */

import com.leedarson.platform.u202120418.devices.domain.model.commands.CreateSensorCommand;
import com.leedarson.platform.u202120418.devices.domain.model.entities.SensorType;
import com.leedarson.platform.u202120418.devices.domain.model.valueobjects.*;
import com.leedarson.platform.u202120418.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * Sensor class and its attributes.
 *
 * @author Fiorella Jarama Peñaloza
 */
@Getter
@Setter
@Entity
public class Sensor extends AuditableAbstractAggregateRoot<Sensor> {

    @Embedded
    private Name name;

    @Embedded
    private Description description;

    @Embedded
    private Manufacturer manufacturer;

    @Embedded
    private ReferenceImageUrl referenceImageUrl;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "sensor_type_id")
    private SensorType sensorType;

    public Sensor(Name name, Description description, Manufacturer manufacturer, ReferenceImageUrl referenceImageUrl, SensorType sensorType) {
        this.name = name;
        this.description = description;
        this.manufacturer = manufacturer;
        this.referenceImageUrl = referenceImageUrl;
        this.sensorType = sensorType;
    }

    public Sensor() {
    }

    /**
     * Constructor for Sensor.
     *
     * @param command CreateSensorCommand
     */
    public Sensor(CreateSensorCommand command){
        this.name = new Name(command.name());
        this.description = new Description(command.description());
        this.manufacturer = new Manufacturer(command.manufacturer());
        this.referenceImageUrl = new ReferenceImageUrl(command.referenceImageUrl());
        this.sensorType = new SensorType(command.sensorTypeId());
    }

    public String getName() {
        return name.getName();
    }

    public String getDescription() {
        return description.getDescription();
    }

    public String getManufacturer() {
        return manufacturer.getManufacturer();
    }

    public String getReferenceImageUrl() {
        return referenceImageUrl.getReferenceImageUrl();
    }

    public Long getSensorTypeId() {
        return sensorType.getId();
    }
}
