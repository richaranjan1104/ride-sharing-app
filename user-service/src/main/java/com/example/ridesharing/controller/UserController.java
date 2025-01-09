package com.example.ridesharing.controller;

import com.example.ridesharing.exception.GlobalExceptionHandler.DriverNotFoundException;
import com.example.ridesharing.kafka.UserKafkaConsumer1;
import com.example.ridesharing.model.DriverVehicleDetailsDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserKafkaConsumer1 userKafkaConsumer1;

    public UserController(UserKafkaConsumer1 userKafkaConsumer1) {
        this.userKafkaConsumer1 = userKafkaConsumer1;
    }

    @GetMapping("/driver/{vehicleNumber}")
    public ResponseEntity<DriverVehicleDetailsDto> getDriverDetails(@PathVariable String vehicleNumber) {
        // Validate vehicle number
        if (vehicleNumber == null || vehicleNumber.isEmpty()) {
            throw new IllegalArgumentException("Vehicle number cannot be null or empty");
        }

        // Get the driver details from the consumed data
        DriverVehicleDetailsDto driverDetails = userKafkaConsumer1.getDriverDetailsByVehicleNumber(vehicleNumber);

        if (driverDetails != null) {
            return ResponseEntity.ok(driverDetails);
        } else {
            // Throw custom exception if not found
            throw new DriverNotFoundException("Driver details not found for vehicle number: " + vehicleNumber);
        }
    }
}
