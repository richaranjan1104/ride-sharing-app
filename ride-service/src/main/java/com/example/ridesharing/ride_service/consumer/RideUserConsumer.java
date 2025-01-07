package com.example.ridesharing.ride_service.consumer;

import com.example.ridesharing.ride_service.dto.RideDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;

import java.util.concurrent.CompletableFuture;

public class RideUserConsumer {

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    @KafkaListener(topics = "user-ride-topic",groupId = "user-ride-group1")
    public void consumeUserDetails(UserDetailsDto userDetailsDto) {

        /**
         *   Based on the UserDto data like userName and phone number we have to set below
         *   data and send back this information to driver service
         */
        RideDetailsDto rideDetailsDto = new RideDetailsDto();
        if(userDetailsDto.getUsername != null){
            String userName = userDetailsDto.getUserName();
            String phoneNumber = userDetailsDto.getPhoneNumber();
            rideDetailsDto.setUserName(userName);
            rideDetailsDto.setMobileNumber(phoneNumber);
            rideDetailsDto.setPickupLocation("Sarjapura");
            rideDetailsDto.setDropoffLocation("K R Puram");
        }

        //Publishing user and rider details to ride-driver-topic

        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send("ride-driver-topic", rideDetailsDto);
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
