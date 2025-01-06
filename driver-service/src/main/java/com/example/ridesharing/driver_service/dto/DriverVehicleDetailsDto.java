package com.example.ridesharing.driver_service.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class DriverVehicleDetailsDto {

    @NotBlank(message = "Driver name is required")
    @Size(min = 3, max = 50, message = "Driver name must be between 3 and 20 characters")
    private String driverName;

    @NotBlank(message = "Vehicle number is required")
    @Pattern(
            regexp = "^[A-Z]{2}[0-9]{2}[A-Z]{2}[0-9]{4}$",
            message = "Invalid vehicle number format (e.g., AB12CD3456)"
    )
    private String vehicleNumber;

    @NotBlank(message = "Vehicle name is required")
    @Size(min = 3, max = 50, message = "Vehicle name must be between 3 and 20 characters")
    private String vehicleName;

    @AssertTrue(message = "Driver must be available (true) to accept bookings")
    private boolean driverStatus;

    public DriverVehicleDetailsDto() {
    }

    public DriverVehicleDetailsDto(String driverName, boolean driverStatus, String vehicleName, String vehicleNumber) {
        this.driverName = driverName;
        this.driverStatus = driverStatus;
        this.vehicleName = vehicleName;
        this.vehicleNumber = vehicleNumber;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public boolean isDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(boolean driverStatus) {
        this.driverStatus = driverStatus;
    }
}
