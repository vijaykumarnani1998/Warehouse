 package com.vijay.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="purchase_details_tab")
public class PurchaseDetails {
	
	@Id
	@GeneratedValue
	private Integer id;
	private Integer quantity;
	
	@ManyToOne
	@JoinColumn(name="part_id_fk_col")
	private Part part;
	
	@ManyToOne
	@JoinColumn(name="purchse_order_id_fk_col")
	private PurchaseOrder purchaseorder;

}
