package com.vijay.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vijay.model.Part;

public interface PartRepository extends JpaRepository<Part, String> {
	
	@Query("SELECT partId,partCode FROM Part")
	List<Object[]> getPartIdAndCode();

}
