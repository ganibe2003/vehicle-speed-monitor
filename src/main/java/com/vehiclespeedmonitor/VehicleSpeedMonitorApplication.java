package com.vehiclespeedmonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableMongoRepositories
@EnableConfigurationProperties
public class VehicleSpeedMonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehicleSpeedMonitorApplication.class, args);
	}
}
