package com.vehiclespeedmonitor;

import com.vehiclespeedmonitor.dto.VehicleAlert;
import com.vehiclespeedmonitor.model.Notification;
import com.vehiclespeedmonitor.model.NotificationRepository;
import com.vehiclespeedmonitor.services.AlertService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Random;

@SpringBootTest
@EnableConfigurationProperties
@EnableAutoConfiguration
class VehicleSpeedMonitorApplicationTests {

	@Autowired
	AlertService alertService;

	@Autowired
	NotificationRepository repository;

	@Test
	public void processAlert(){
		for(int i=1; i<1000; i++){
			Thread t = new Thread() {
				@Override
				public void run() {
					final VehicleAlert vehicleAlert = getAlert();
					alertService.processAlert(vehicleAlert);
				}
			};
			t.start();
		}
	}

	private VehicleAlert getAlert(){
		Random r = new Random();
		VehicleAlert vehicleAlert = new VehicleAlert();
		vehicleAlert.setAlertId("Alert-" + r.nextInt(1000));
		vehicleAlert.setVehicleId("Vehicle-" + r.nextInt(100));
		vehicleAlert.setVehicleLatitude(20 + (2000 - 20) * r.nextDouble());
		vehicleAlert.setVehicleLongitude(20 + (2000 - 20) * r.nextDouble());
		vehicleAlert.setVehicleSpeed(r.nextInt(200));
		vehicleAlert.setAlertTime(new Date());
		return vehicleAlert;
	}
}
