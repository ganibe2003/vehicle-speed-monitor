package com.vehiclespeedmonitor.services;

import com.google.common.util.concurrent.*;
import com.vehiclespeedmonitor.dto.AlertStatus;
import com.vehiclespeedmonitor.dto.VehicleAlert;
import com.vehiclespeedmonitor.handlers.AlertHandler;
import com.vehiclespeedmonitor.model.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;

@Service
public class AlertService implements IAlertService {

    @Autowired
    NotificationRepository repository;

    @Override
    public void processAlert(VehicleAlert vehicleAlert) {
        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newSingleThreadExecutor());
        ListenableFuture<AlertStatus> status = service.submit(new AlertHandler(vehicleAlert, repository));

        Futures.addCallback(status, new FutureCallback<AlertStatus>() {
            @Override
            public void onSuccess(AlertStatus status) {
                //TODO Implement success scenario
                System.out.println(status.getStatus());
            }
            @Override
            public void onFailure(Throwable t) {
                //TODO Implement failure scenario
                t.printStackTrace();
            }
        });
    }

    private int getSpeedLimit(String vehicleId, double vehicleLongitude, double vehicleLatitude){
        return 45;
    }
}
