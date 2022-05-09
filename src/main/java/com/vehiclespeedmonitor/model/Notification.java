package com.vehiclespeedmonitor.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "notifications")
public class Notification {

    @Id
    private String alertId;
    private String vehicleId;
    private double vehicleLatitude;
    private double vehicleLongitude;
    private double vehicleSpeed;
    private Date alertTime;
    private double speedLimit;

    public String getAlertId() {
        return alertId;
    }

    public void setAlertId(String alertId) {
        this.alertId = alertId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public double getVehicleLatitude() {
        return vehicleLatitude;
    }

    public void setVehicleLatitude(double vehicleLatitude) {
        this.vehicleLatitude = vehicleLatitude;
    }

    public double getVehicleLongitude() {
        return vehicleLongitude;
    }

    public void setVehicleLongitude(double vehicleLongitude) {
        this.vehicleLongitude = vehicleLongitude;
    }

    public double getVehicleSpeed() {
        return vehicleSpeed;
    }

    public void setVehicleSpeed(double vehicleSpeed) {
        this.vehicleSpeed = vehicleSpeed;
    }

    public Date getAlertTime() {
        return alertTime;
    }

    public void setAlertTime(Date alertTime) {
        this.alertTime = alertTime;
    }

    public double getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(double speedLimit) {
        this.speedLimit = speedLimit;
    }

    public void setAllowedSpeed(double speedLimit) {
        this.speedLimit = speedLimit;
    }
}
