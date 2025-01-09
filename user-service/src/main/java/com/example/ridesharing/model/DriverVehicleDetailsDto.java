package com.example.ridesharing.model;

public class DriverVehicleDetailsDto {

    private String userName;
    private String email;
    private String vehicleName;
    private String vehicleNumber;
    private boolean driverStatus;

    public DriverVehicleDetailsDto() {}

    public DriverVehicleDetailsDto(String userName, String email, String vehicleName, String vehicleNumber, boolean driverStatus) {
        this.userName = userName;
        this.email = email;
        this.vehicleName = vehicleName;
        this.vehicleNumber = vehicleNumber;
        this.driverStatus = driverStatus;
    }

    // Getters and Setters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public boolean isDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(boolean driverStatus) {
        this.driverStatus = driverStatus;
    }

    @Override
    public String toString() {
        return "DriverVehicleDetailsDto{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", vehicleName='" + vehicleName + '\'' +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", driverStatus=" + driverStatus +
                '}';
    }
}
