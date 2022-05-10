package com.vehiclespeedmonitor.services;

import com.vehiclespeedmonitor.dto.AlertStatus;
import com.vehiclespeedmonitor.dto.VehicleAlert;
import com.vehiclespeedmonitor.handlers.AlertHandler;
import com.vehiclespeedmonitor.model.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Service
public class AlertService implements IAlertService{

    @Autowired
    NotificationRepository repository;

    @Autowired
    AlertHandler alertHandler;

    @Override
    public void processAlert(VehicleAlert vehicleAlert) {
        Executor executor = Executors.newFixedThreadPool(3);
        CompletableFuture.supplyAsync(() ->{
            try {
                return alertHandler.getSpeedLimit();
            }catch(Exception ex){
                throw new IllegalStateException(ex);
            }
        }).thenApplyAsync(result -> {
            vehicleAlert.setSpeedLimit(result);
            return alertHandler.getAlertType(vehicleAlert);
        }).thenApplyAsync(result ->{
            if(result.getAlertType() == 1){
                if(vehicleAlert.isOverSpeed()){
                    try{
                        //return alertHandler.publishNotification(vehicleAlert);
                        return alertHandler.storeNotification(repository, vehicleAlert);
                    }catch(Exception ex){
                        throw new IllegalStateException(ex);
                    }
                }
            }else{
                try{
                    return alertHandler.storeNotification(repository, vehicleAlert);
                }catch(Exception ex){
                    throw new IllegalStateException(ex);
                }
            }
            return new AlertStatus("FAILED");
        }).handleAsync((result, ex)->{
            System.out.println(vehicleAlert.getAlertId() + "-> " + result);
            return result;
        });
    }
}
