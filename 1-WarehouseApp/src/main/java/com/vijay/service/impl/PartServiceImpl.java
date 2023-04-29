package com.vijay.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijay.model.Part;
import com.vijay.repo.PartRepository;
import com.vijay.service.PartService;
@Service
public class PartServiceImpl implements PartService {
	
	@Autowired
	private PartRepository partRepo;

	@Override
	public String savepart(Part part) {
		return  partRepo.save(part).getPartId();
	}

	@Override
	public List<Part> getAllParts() {
		return partRepo.findAll();
	}

	@Override
	public Part getOnePart(String id) {
		Optional<Part> opt=partRepo.findById(id);
		Part part =opt.get();
		return part;
	}

	@Override
	public void deletePart(String id) {
		partRepo.deleteById(id);
	}

	@Override
	public void updatePart(Part part) {
if(part.getPartId()!=null)
{
	partRepo.save(part);
}
	}

	@Override
	public Map<String, String> getPartIdAndCode() {
     List<Object[]> list= partRepo.getPartIdAndCode();
     Map<String,String> map=new LinkedHashMap<>();
     for(Object[] ob:list)
     {
    	 map.put(ob[0].toString(),ob[1].toString());
     }
		
		return map;
	}

}
