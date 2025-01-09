package com.example.ridesharing.kafka;

import com.example.ridesharing.model.DriverVehicleDetailsDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserKafkaConsumer1 {

    private final Map<String, DriverVehicleDetailsDto> driverStore = new HashMap<>();

    @KafkaListener(topics = "driver-user-topic", groupId = "user-grp-1")
    public void consume(DriverVehicleDetailsDto driverVehicleDetailsDto) {
        // Log the consumed data
        System.out.println("Consumed driver data: " + driverVehicleDetailsDto);

        // Store the consumed driver data
        driverStore.put(driverVehicleDetailsDto.getVehicleNumber(), driverVehicleDetailsDto);

        // Log the stored driver data
        System.out.println("Stored driver data for vehicle number: " + driverVehicleDetailsDto.getVehicleNumber());
    }

    public DriverVehicleDetailsDto getDriverDetailsByVehicleNumber(String vehicleNumber) {
        // Fetch the driver details from the store
        return driverStore.get(vehicleNumber);
    }
}
