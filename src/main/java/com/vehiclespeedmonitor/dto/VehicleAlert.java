package com.vehiclespeedmonitor.dto;

import java.util.Date;

public class VehicleAlert {

    private String alertId;
    private String vehicleId;
    private double vehicleLatitude;
    private double vehicleLongitude;
    private double vehicleSpeed;
    private Date alertTime;
    private Date alertStartTime;
    private Date alertEndTime;
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

    public Date getAlertStartTime() {
        return alertStartTime;
    }

    public void setAlertStartTime(Date alertStartTime) {
        this.alertStartTime = alertStartTime;
    }

    public Date getAlertEndTime() {
        return alertEndTime;
    }

    public void setAlertEndTime(Date alertEndTime) {
        this.alertEndTime = alertEndTime;
    }

    public double getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(double speedLimit) {
        this.speedLimit = speedLimit;
    }

    public boolean isAlertTimeSet() {
        return alertStartTime != null && alertEndTime != null;
    }

    public boolean isAlertTimeValid() {
        return alertTime.after(alertStartTime) && alertTime.before(alertEndTime);
    }

    public boolean isOverSpeed(){
        return vehicleSpeed > speedLimit;
    }
}
