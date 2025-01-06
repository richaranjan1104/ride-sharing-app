package com.example.ridesharing.driver_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class RideDetailsDto {
    public @NotBlank(message = "Username is required") @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters") String getUserName() {
        return userName;
    }

    public void setUserName(@NotBlank(message = "Username is required") @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters") String userName) {
        this.userName = userName;
    }

    public @NotBlank(message = "Phone number is required") @Pattern(
            regexp = "^(\\+\\d{1,3}[- ]?)?\\d{10}$",
            message = "Invalid phone number format"
    ) String getPhone() {
        return phone;
    }

    public void setPhone(@NotBlank(message = "Phone number is required") @Pattern(
            regexp = "^(\\+\\d{1,3}[- ]?)?\\d{10}$",
            message = "Invalid phone number format"
    ) String phone) {
        this.phone = phone;
    }

    public @NotBlank(message = "Email is required") @Email(message = "Invalid email format") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email is required") @Email(message = "Invalid email format") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Pick-up location is required") @Size(min = 3, max = 100, message = "Pick-up location must be between 3 and 100 characters") String getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(@NotBlank(message = "Pick-up location is required") @Size(min = 3, max = 100, message = "Pick-up location must be between 3 and 100 characters") String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public @NotBlank(message = "Drop-off location is required") @Size(min = 3, max = 100, message = "Drop-off location must be between 3 and 100 characters") String getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(@NotBlank(message = "Drop-off location is required") @Size(min = 3, max = 100, message = "Drop-off location must be between 3 and 100 characters") String dropLocation) {
        this.dropLocation = dropLocation;
    }

    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    private String userName;

    @NotBlank(message = "Phone number is required")
    @Pattern(
            regexp = "^(\\+\\d{1,3}[- ]?)?\\d{10}$",
            message = "Invalid phone number format"
    )
    private String phone;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Pick-up location is required")
    @Size(min = 3, max = 100, message = "Pick-up location must be between 3 and 100 characters")
    private String pickUpLocation;

    @NotBlank(message = "Drop-off location is required")
    @Size(min = 3, max = 100, message = "Drop-off location must be between 3 and 100 characters")
    private String dropLocation;

    public RideDetailsDto() {
    }

    public RideDetailsDto(String userName, String phone, String email, String pickUpLocation, String dropLocation) {
        this.userName = userName;
        this.phone = phone;
        this.email = email;
        this.pickUpLocation = pickUpLocation;
        this.dropLocation = dropLocation;
    }

}
