package com.example.ridesharing.driver_service.consumer;

import com.example.ridesharing.driver_service.dto.DriverVehicleDetailsDto;
import com.example.ridesharing.driver_service.dto.RideDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;

import java.util.concurrent.CompletableFuture;

public class DriverRideConsumer {

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    @KafkaListener(topics = "ride-driver-topic",groupId = "driver-grp-1")
    public void consumeRideDetails(RideDetailsDto rideDetailsDto) {

        /**
         *   Based on the rideDetailsDto data like pickUp and drop location we have to set below
         *   data and send back this information to User whether trip got accepted
         */
        DriverVehicleDetailsDto driverVehicleDetailsDto = new DriverVehicleDetailsDto();
        if(rideDetailsDto.getDropLocation().equalsIgnoreCase("Malleshwaram")){
            driverVehicleDetailsDto.setDriverName("Vasanth");
            driverVehicleDetailsDto.setVehicleNumber("KA50-H-8800");
            driverVehicleDetailsDto.setVehicleName("Swift Dzire");
            driverVehicleDetailsDto.setDriverStatus(true);
        }else{
            driverVehicleDetailsDto.setDriverStatus(false);
        }

        //Publishing vehicle and driver details to driver-user-topic
        //     kafkaTemplate.send("driver-user-topic",driverVehicleDetailsDto);

        //     CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send("driver-user-topic", driverVehicleDetailsDto);
        //     future.get();  // This becomes synchronous call as Kafka will be waiting for the response.

        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send("driver-user-topic", driverVehicleDetailsDto);
        future.whenComplete((result,ex)->{
            System.out.println(result.getRecordMetadata().partition()); // To see partition details on the result
            if(ex == null){  // If ex==null when there is not exception occurred when sending messages
                System.out.println("Sent message=[" + rideDetailsDto +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else{
                System.out.println("Unable to send message=[" +
                        rideDetailsDto + "] due to : "+ ex.getMessage());
            }
        });
    }
}
