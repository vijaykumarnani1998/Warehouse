package com.vijay.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vijay.model.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment, String> {
	
	@Query("SELECT shipmentId,shipmentCode FROM Shipment where enableShipment=:enable")
	List<Object[]> getShipmentIdAndCodeByEnableShipment(String enable);

}
