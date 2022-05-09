package com.vehiclespeedmonitor.handlers;

import com.vehiclespeedmonitor.dto.AlertStatus;
import com.vehiclespeedmonitor.dto.VehicleAlert;
import com.vehiclespeedmonitor.model.Notification;
import com.vehiclespeedmonitor.model.NotificationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.Callable;

public class AlertHandler implements Callable {

    NotificationRepository repository;
    private VehicleAlert vehicleAlert;
    private double speedLimit = 0.0;

    public AlertHandler(VehicleAlert vehicleAlert, NotificationRepository repository){
        this.vehicleAlert = vehicleAlert;
        this.repository = repository;
    }

    @Override
    public AlertStatus call() throws Exception {
        speedLimit = getSpeedLimit();
        if(vehicleAlert.getVehicleSpeed() > speedLimit){
            if(vehicleAlert.isAlertTimeSet()){
                if(vehicleAlert.isAlertTimeValid()){
                    storeAndPublishNotification();
                }
            }else{
                publishNotification();
            }
        }
        return new AlertStatus("SUCCESS");
    }

    private void publishNotification() throws Exception{
        //TODO implement logic to publish notification to queue
        // At present storing notification to DB
        storeNotification();
    }

    private void storeAndPublishNotification() throws Exception{
        storeNotification();
        publishNotification();
    }

    private void storeNotification() throws Exception {
        repository.save(getNotification());
    }

    private double getSpeedLimit(){
        //TODO implement logic to get Speed limit from Google Road API
        return 45;
    }

    private Notification getNotification(){
        Notification notification = new Notification();
        BeanUtils.copyProperties(vehicleAlert, notification);
        notification.setAllowedSpeed(speedLimit);
        return notification;
    }
}
