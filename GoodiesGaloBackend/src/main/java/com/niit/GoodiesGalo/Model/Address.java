package com.niit.GoodiesGalo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    int Address_id;
	
	@Column(nullable=false)
	String Name;
	
	@Column(nullable=false)
	String Line1;
	
	@Column(nullable=false)
	String Line2;
	
	@Column(nullable=false)
	String Area;
	
	@Column(nullable=false)
	String Pincode;
	
	@ManyToOne
	Customer Customer;

	public int getAddress_id() {
		return Address_id;
	}

	public void setAddress_id(int address_id) {
		Address_id = address_id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getLine1() {
		return Line1;
	}

	public void setLine1(String line1) {
		Line1 = line1;
	}

	public String getLine2() {
		return Line2;
	}

	public void setLine2(String line2) {
		Line2 = line2;
	}

	public String getArea() {
		return Area;
	}

	public void setArea(String area) {
		Area = area;
	}

	public String getPincode() {
		return Pincode;
	}

	public void setPincode(String pincode) {
		Pincode = pincode;
	}

	public Customer getCustomer() {
		return Customer;
	}

	public void setCustomer(Customer customer) {
		Customer = customer;
	}
	
	
	
}
