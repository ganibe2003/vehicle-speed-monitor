package com.vehiclespeedmonitor.dto;

import java.util.Date;

public class AlertType {

    private String alertId;
    private String vehicleId;
    private Date alertStartTime;
    private Date alertEndTime;
    private int alertType;

    public AlertType(){}

    public AlertType(int alertType){
        this.alertType = alertType;
    }
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

    public int getAlertType() {
        return alertType;
    }

    public void setAlertType(int alertType) {
        this.alertType = alertType;
    }
}
