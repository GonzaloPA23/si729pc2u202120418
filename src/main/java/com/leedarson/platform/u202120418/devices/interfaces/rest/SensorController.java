package com.leedarson.platform.u202120418.devices.interfaces.rest;/**
 * @author Fiorella Jarama Peñaloza
 */

import com.leedarson.platform.u202120418.devices.domain.services.SensorCommandService;
import com.leedarson.platform.u202120418.devices.interfaces.rest.resources.CreateSensorResource;
import com.leedarson.platform.u202120418.devices.interfaces.rest.resources.SensorResource;
import com.leedarson.platform.u202120418.devices.interfaces.rest.transform.CreateSensorCommandFromResourceAssembler;
import com.leedarson.platform.u202120418.devices.interfaces.rest.transform.SensorResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SensorController - Controller for the sensor.
 *
 * @author Fiorella Jarama Peñaloza
 */
@RestController
@RequestMapping(value = "/api/v1/sensors", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Sensors", description = "Sensors Management Endpoints")
public class SensorController {

    private final SensorCommandService sensorCommandService;


    public SensorController(SensorCommandService sensorCommandService) {
        this.sensorCommandService = sensorCommandService;
    }

    /**
     * Create a sensor - POST
     *
     * @param resource - CreateSensorResource
     * @return ResponseEntity<SensorResource>
     */
    @Operation(summary = "Create a sensor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Sensor created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @PostMapping
    public ResponseEntity<SensorResource> createSensor(@RequestBody CreateSensorResource resource) {
        var createSensorCommand = CreateSensorCommandFromResourceAssembler.toCommandFromResource(resource);
        var sensor = sensorCommandService.handle(createSensorCommand);
        if (sensor.isEmpty()) return ResponseEntity.badRequest().build();
        var sensorResource = SensorResourceFromEntityAssembler.toResourceFromEntity(sensor.get());
        return new ResponseEntity<>(sensorResource, HttpStatus.CREATED);
    }
}
