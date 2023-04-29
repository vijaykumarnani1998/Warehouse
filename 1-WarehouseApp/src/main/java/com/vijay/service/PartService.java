package com.vijay.service;

import java.util.List;
import java.util.Map;

import com.vijay.model.Part;

public interface PartService {
	
	public String savepart(Part part);
	public List<Part> getAllParts();
	public Part getOnePart(String id);
	public void deletePart(String id);
	public void updatePart(Part part);
	 
	public Map<String,String> getPartIdAndCode();

}
