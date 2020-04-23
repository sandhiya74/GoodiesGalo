package com.niit.GoodiesGalo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int cust_id;
	
	@Column(nullable=false,unique=true)
	String cust_Emailid;
	
	@Column(nullable=false)
	String cust_Name;
	
	@Column(nullable=false,unique=true)
	String cust_Phone;
	
	@Transient
	@Column(nullable=false)
	String password;

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public String getCust_Emailid() {
		return cust_Emailid;
	}

	public void setCust_Emailid(String cust_Emailid) {
		this.cust_Emailid = cust_Emailid;
	}

	public String getCust_Name() {
		return cust_Name;
	}

	public void setCust_Name(String cust_Name) {
		this.cust_Name = cust_Name;
	}

	public String getCust_Phone() {
		return cust_Phone;
	}

	public void setCust_Phone(String cust_Phone) {
		this.cust_Phone = cust_Phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	

}
