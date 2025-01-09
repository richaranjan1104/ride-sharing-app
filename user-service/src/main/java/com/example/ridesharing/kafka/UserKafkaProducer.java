package com.example.ridesharing.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.example.ridesharing.model.User;

@Service
public class UserKafkaProducer {

    private final KafkaTemplate<String, User> kafkaTemplate;
    private final UserKafkaConsumer userKafkaConsumer;

    private static final String TOPIC = "user-registration-topic";

    public UserKafkaProducer(KafkaTemplate<String, User> kafkaTemplate, UserKafkaConsumer userKafkaConsumer) {
        this.kafkaTemplate = kafkaTemplate;
        this.userKafkaConsumer = userKafkaConsumer;
    }

    public void sendMessage(User user) {
        // Check if the user already exists by email or username
        User existingUserByEmail = userKafkaConsumer.getUserByEmail(user.getEmail());
        User existingUserByUsername = userKafkaConsumer.getUserByUsername(user.getUsername());

        if (existingUserByEmail != null) {
            // Handle case where the email is already registered
            System.out.println("User with email " + user.getEmail() + " already exists.");
            return;  // Don't send duplicate registration message
        }

        if (existingUserByUsername != null) {
            // Handle case where the username is already taken
            System.out.println("User with username " + user.getUsername() + " already exists.");
            return;  // Don't send duplicate registration message
        }

        // Send the user to Kafka if no duplicates were found
        kafkaTemplate.send(TOPIC, user);
        System.out.println("User registered successfully and message sent to Kafka.");
    }
}
