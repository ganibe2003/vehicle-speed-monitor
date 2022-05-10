package com.vehiclespeedmonitor.handlers;

import com.vehiclespeedmonitor.dto.AlertStatus;
import com.vehiclespeedmonitor.dto.AlertType;
import com.vehiclespeedmonitor.dto.VehicleAlert;
import com.vehiclespeedmonitor.model.Notification;
import com.vehiclespeedmonitor.model.NotificationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class AlertHandler {

    public AlertStatus publishNotification(VehicleAlert vehicleAlert) throws Exception{
        //TODO implement logic to publish notification to queue
        // At present storing notification to DB
        return new AlertStatus("SUCCESS");
    }

    public AlertStatus storeNotification(NotificationRepository repository, VehicleAlert vehicleAlert) throws Exception {
        repository.save(getNotification(vehicleAlert));
        return new AlertStatus("SUCCESS");
    }

    public AlertType getAlertType(VehicleAlert vehicleAlert){
        //TODO implement logic to get AlertType from DB
        return new AlertType(1);
    }

    public double getSpeedLimit() throws Exception{
        //TODO implement logic to get Speed limit from Google Road API
        return 45;
    }

    private Notification getNotification(VehicleAlert vehicleAlert){
        Notification notification = new Notification();
        BeanUtils.copyProperties(vehicleAlert, notification);
        return notification;
    }
}
