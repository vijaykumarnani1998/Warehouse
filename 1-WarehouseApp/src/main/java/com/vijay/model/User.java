package com.vijay.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="user_tab")
public class User {
	@Id
	@Column(name="user_id_col")
	@GeneratedValue(generator="user")
	@SequenceGenerator(name="user" ,sequenceName="user_seq")
	private Integer userId;
	@Column(name="user_type_col")
	private String userType;
	@Column(name="user_code_col")
	private String userCode;
	@Column(name="user_for_col")
	private String userFor;
	@Column(name="user_email_col")
	private String userEmail;
	@Column(name="user_contact_col")
	private String userContact;
	@Column(name="user_idType_col")
	private String userIdType;
	@Column(name="user_other_col")
	private String ifOther;
	@Column(name="user_idNumber_col")
	private String userIdNumber;

}


