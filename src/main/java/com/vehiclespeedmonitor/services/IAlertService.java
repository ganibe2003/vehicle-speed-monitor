package com.vehiclespeedmonitor.services;

import com.vehiclespeedmonitor.dto.VehicleAlert;

public interface IAlertService {

    void processAlert(VehicleAlert vehicleAlert);
}
