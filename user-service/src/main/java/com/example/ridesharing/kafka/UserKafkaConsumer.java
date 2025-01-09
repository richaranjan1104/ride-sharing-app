package com.example.ridesharing.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.example.ridesharing.model.User;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserKafkaConsumer {

    // In-memory store for consumed users, ideally this should be replaced by a database
    private final Map<String, User> usersByEmail = new HashMap<>();
    private final Map<String, User> usersByUsername = new HashMap<>();

    @KafkaListener(topics = "user-registration-topic", groupId = "group_id")
    public void consume(User user) {
        // Storing users in memory. In production, use a database or cache.
        usersByEmail.put(user.getEmail(), user);
        usersByUsername.put(user.getUsername(), user);
        System.out.println("Consumed user: " + user);
    }

    // Method to fetch user by email
    public User getUserByEmail(String email) {
        return usersByEmail.get(email);  // Return the user if found or null if not found
    }

    // Method to fetch user by username
    public User getUserByUsername(String username) {
        return usersByUsername.get(username);  // Return the user if found or null if not found
    }
}
