package com.vijay.service;

import java.util.List;

import com.vijay.model.Uom;

public interface UomService {
	
	public String saveUom(Uom uom);
	public List<Uom> getAllUoms();
	public Uom getOneUom(String id);
	public void deleteUom(String id);
	public void updateUom(Uom  uom);

}
