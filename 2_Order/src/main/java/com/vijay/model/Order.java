package com.vijay.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="order_table")
public class Order {
	@Id
	@Column(name="order_id_col")
	@GeneratedValue(generator="order")
	@GenericGenerator(name="order",strategy="com.vijay.OrderIdGenerator")
	private  String orderId;
	@Column(name="order_mode_col")
	private String orderMode;
	@Column(name="order_code_col")
	private String orderCode;
	@Column(name="order_method_col")
	private String orderMethod;
	@Column(name="order_accept_col")
	private String orderAccept;
	@Column(name="order_desc_col")
	private String orderDescription;

}
