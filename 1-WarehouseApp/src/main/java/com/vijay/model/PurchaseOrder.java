package com.vijay.model;

import jakarta.persistence.Column;
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
@Table(name="purchase_order_table")
public class PurchaseOrder {
	
	@Id
	@GeneratedValue(generator="purchase order")
	@SequenceGenerator(name="purchase order",sequenceName="purchase order_Seq")
	@Column(name="po_id_col")
	private  Integer id;
	@Column(name="po_order_code_col")
	private String orderCode;
	@Column(name="po_ref_num_col")
	private String referenceNumber;
	@Column(name="po_qultycheck_col")
	private String qualityCheck;
	@Column(name="po_status_col")
	private String status;
	@Column(name="po_desc_col")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="shipment_id_fk_col")
	private Shipment shipment;
	
	@ManyToOne
	@JoinColumn(name="vendor_id_fk_col")
	private User userTypeVendor;

}
