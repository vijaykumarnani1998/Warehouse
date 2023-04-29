package com.vijay.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijay.exception.ShipmentNotFoundException;
import com.vijay.model.Shipment;
import com.vijay.repo.ShipmentRepository;
import com.vijay.service.ShipmentService;

@Service
public class ShipmentServiceImpl implements ShipmentService {
	@Autowired
	private ShipmentRepository shipmentRepo;

	@Override
	public String saveShipment(Shipment shipment) {
		return shipmentRepo.save(shipment).getShipmentId();
	}

	@Override
	public List<Shipment> getAllShipments() {
		return shipmentRepo.findAll();
	}

	@Override
	public Shipment getOneShipment(String id) {
		Shipment shipment = shipmentRepo.findById(id)
				.orElseThrow(() -> new ShipmentNotFoundException("Shipment '" + id + "' Not Found"));

		return shipment;
	}

	@Override
	public void deleteShipment(String id) {
		shipmentRepo.deleteById(id);
	}

	@Override
	public void updateShipment(Shipment shipment) {
		if (shipment.getShipmentId() != null) {
			shipmentRepo.save(shipment);
		}
	}

	@Override
	public Map<String, String> getShipmentIdAndCodeByEnabled(String enable) {
	List<Object[]>list=	shipmentRepo.getShipmentIdAndCodeByEnableShipment(enable);
	Map<String,String> map=new LinkedHashMap<>();
	for(Object[] ob:list)
	{
		map.put(ob[0].toString(),ob[1].toString());
	}
	return map;
	}

}
