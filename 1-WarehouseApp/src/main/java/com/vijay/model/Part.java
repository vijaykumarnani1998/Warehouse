package com.vijay.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="part_tab")
public class Part {
	
	@Id
	@GeneratedValue(generator="part")
	@GenericGenerator(name="part" ,strategy="com.vijay.PartIdGenerator")
	@Column(name="part_id_col")
	private String partId;
	@Column(name="part_code_col")
	  private String partCode;
	@Column(name="part_length_col")
	  private String partLength;
	@Column(name="part_width_col")
	  private String partWidth;
	@Column(name="part_height_col")
	  private String partHeight;
	@Column(name="part_cost_col")
	  private String partBaseCost;
	@Column(name="part_currency_col")
	  private String partBaseCurrency;
	@Column(name="part_Desc_col")
	  private String partDescription;
	
	@ManyToOne
	@JoinColumn(name="uom_id_fk")
	private Uom uom;
	
	@ManyToOne
	@JoinColumn(name="order_code_sale_id_fk")
	private Order ordercodesale;
	
	@ManyToOne
	@JoinColumn(name="order_code_purchase_id_fk")
	private Order ordercodepurchase;

}
