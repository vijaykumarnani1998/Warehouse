package com.vijay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijay.exception.UomNotFoundException;
import com.vijay.model.Uom;
import com.vijay.repo.UomRepository;
import com.vijay.service.UomService;

@Service
public class UomServiceImpl implements UomService {

	@Autowired
	private UomRepository uomRepo;

	@Override
	public String saveUom(Uom uom) {
		return uomRepo.save(uom).getUomId();
	}

	@Override
	public List<Uom> getAllUoms() {
		return uomRepo.findAll();
	}

	@Override
	public Uom getOneUom(String id) {
	Uom uom=uomRepo.findById(id).orElseThrow(()->new UomNotFoundException("Uom Not Found"));
	return uom;
	}

	@Override
	public void deleteUom(String id) {
		
		uomRepo.deleteById(id);
	}

	@Override
	public void updateUom(Uom uom) {
		if (uom.getUomId() != null) {
			uomRepo.save(uom);
		}
	}
}
