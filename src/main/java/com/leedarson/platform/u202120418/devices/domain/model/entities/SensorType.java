package com.leedarson.platform.u202120418.devices.domain.model.entities;/**
 * @author Fiorella Jarama Peñaloza
 */

import com.leedarson.platform.u202120418.devices.domain.model.valueobjects.SensorTypes;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.List;

/**
 * SensorType class and its attributes.
 *
 * @author Fiorella Jarama Peñaloza
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
public class SensorType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private SensorTypes name;

    public SensorType(Long id) {
        this.id = id;
    }

    public String getStringName() {
        return name.name();
    }

}
