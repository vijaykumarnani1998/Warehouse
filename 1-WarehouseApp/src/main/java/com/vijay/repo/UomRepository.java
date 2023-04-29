package com.vijay.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vijay.model.Uom;

public interface UomRepository extends JpaRepository<Uom, String> {
	
	@Query("SELECT count(uomModel) FROM Uom where uomModel=:uomModel")
	Integer getUomModelCount(String uomModel);
	
	@Query("SELECT uomId,uomModel FROM Uom")
	List<Object[]>getUomIdAndModel();

}
