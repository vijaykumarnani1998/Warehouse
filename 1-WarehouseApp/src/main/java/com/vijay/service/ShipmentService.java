package com.vijay.service;

import java.util.List;
import java.util.Map;

import com.vijay.model.Shipment;

public interface ShipmentService {
	
	public String saveShipment(Shipment shipment);
	public List<Shipment> getAllShipments();
	public Shipment getOneShipment(String id);
	public void deleteShipment(String id);
	public void updateShipment(Shipment shipment);
	
	public Map<String,String> getShipmentIdAndCodeByEnabled(String enable);


}
