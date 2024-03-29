package com.vehiclespeedmonitor.model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends MongoRepository<Notification, String> {

    public List<Notification> findByVehicleId(String vehicleId);
}
