package com.example.ridesharing.driver_service.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic createTopic(){
        return new NewTopic("ride-driver-topic",2,(short)1);
    }


    @Bean
    public NewTopic createDriverUserTopic(){
        return new NewTopic("driver-user-topic",2,(short)1);
    }
}
