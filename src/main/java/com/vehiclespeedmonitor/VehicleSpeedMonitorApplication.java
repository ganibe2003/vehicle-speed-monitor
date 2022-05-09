package com.vehiclespeedmonitor;

import com.vehiclespeedmonitor.dto.VehicleAlert;
import com.vehiclespeedmonitor.services.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Random;


@SpringBootApplication
@EnableMongoRepositories
@EnableConfigurationProperties
public class VehicleSpeedMonitorApplication {

	@Autowired
	AlertService alertService;
	public static void main(String[] args) {
		SpringApplication.run(VehicleSpeedMonitorApplication.class, args);
	}

	@Component
	public class ReconTool implements CommandLineRunner {

		@Override
		public void run(String... args) throws Exception {
			Random r = new Random();
			VehicleAlert vehicleAlert = new VehicleAlert();
			vehicleAlert.setAlertId("Alert-" + r.nextInt(1000));
			vehicleAlert.setVehicleId("Vehicle-" + r.nextInt(100));
			vehicleAlert.setVehicleLatitude(20 + (2000 - 20) * r.nextDouble());
			vehicleAlert.setVehicleLongitude(20 + (2000 - 20) * r.nextDouble());
			vehicleAlert.setVehicleSpeed(r.nextInt(200));
			vehicleAlert.setAlertTime(new Date());
			alertService.processAlert(vehicleAlert);
		}
	}
}
