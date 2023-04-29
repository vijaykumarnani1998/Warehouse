package com.vijay.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Sales_Order_tab")
public class SaleOrder {
	
	@Id
	@GeneratedValue(generator="salesorder")
	@SequenceGenerator(name="salesorder",sequenceName="salesorder_seq")
	private Integer id;
	private String orderCode;
	private String referenceNumber;
	private String stockMode;
	private String stockSource;
	private String status;
	private String description;

	@ManyToOne
	@JoinColumn(name="shipment_id_fk_col")
	private Shipment shipment;
	@ManyToOne
	@JoinColumn(name="userType_Customer_id_fk_col")
	private User userTypeCustomer;
}
