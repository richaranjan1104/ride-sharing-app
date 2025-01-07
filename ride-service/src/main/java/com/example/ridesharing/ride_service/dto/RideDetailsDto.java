package com.example.ridesharing.ride_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
//@Data
public class RideDetailsDto {

    private String userName;

    private String mobileNumber;

    @NotBlank(message = "Pick-up location is required")
    @Size(min = 3, max = 100, message = "Pick-up location must be between 3 and 100 characters")
    private String pickupLocation;

    @NotBlank(message = "Drop-off location is required")
    @Size(min = 3, max = 100, message = "Drop-off location must be between 3 and 100 characters")
    private String dropoffLocation;

    //private String status;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDropoffLocation() {
        return dropoffLocation;
    }

    public void setDropoffLocation(String dropoffLocation) {
        this.dropoffLocation = dropoffLocation;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public RideDetailsDto() {}

    public RideDetailsDto(String userName, String mobileNumber, String pickupLocation, String dropoffLocation) {
        this.userName = userName;
        this.mobileNumber = mobileNumber;
        this.pickupLocation = pickupLocation;
        this.dropoffLocation = dropoffLocation;
        //this.status = status;
    }
}
