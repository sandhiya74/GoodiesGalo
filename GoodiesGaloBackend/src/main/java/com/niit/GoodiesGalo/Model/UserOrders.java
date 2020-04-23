package com.niit.GoodiesGalo.Model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class UserOrders {
	
	@Id
	String Order_id;
	
	@Column(nullable=false)
	float Total_float;
	
	@Column(nullable=false)
	Product Productdetails;
	
	@Column(nullable=false)
	Address Address;
	
	@Column(nullable=false)
	Customer Customerdetails;
	
	@Column(nullable=false)
 @Temporal(TemporalType.DATE)
	 Date order_date;

	public String getOrder_id() {
		return Order_id;
	}

	public void setOrder_id(String order_id) {
		Order_id = order_id;
	}

	public float getTotal_float() {
		return Total_float;
	}

	public void setTotal_float(float total_float) {
		Total_float = total_float;
	}

	public Product getProductdetails() {
		return Productdetails;
	}

	public void setProductdetails(Product productdetails) {
		Productdetails = productdetails;
	}

	public Address getAddress() {
		return Address;
	}

	public void setAddress(Address address) {
		Address = address;
	}

	public Customer getCustomerdetails() {
		return Customerdetails;
	}

	public void setCustomerdetails(Customer customerdetails) {
		Customerdetails = customerdetails;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}


	
	
}
