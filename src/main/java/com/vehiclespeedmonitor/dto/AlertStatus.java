package com.vehiclespeedmonitor.dto;

public class AlertStatus {
    private String status;
    private String errorCode;
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AlertStatus (String status){
        this(status, null, null);
    }

    public AlertStatus(String status, String errorCode, String message){
       this.status = status;
       this.errorCode = errorCode;
       this.message = message;
    }


}
