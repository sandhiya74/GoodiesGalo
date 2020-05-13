package com.niit.GoodiesGalo.Model;

import java.util.Date;  
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class UserOrders {
	
	@Id
	String order_Id;
	
	@Column(nullable=false)
	float total;
	
	@ManyToOne
	Product productdetails;
	
	@ManyToOne
	Address address;
	
	@ManyToOne
	Customer customerdetails;
	
	@Column(nullable=false)
 @Temporal(TemporalType.DATE)
	 Date order_Date;

	public String getOrder_Id() {
		return order_Id;
	}

	public void setOrder_Id(String order_Id) {
		this.order_Id = order_Id;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Product getProductdetails() {
		return productdetails;
	}

	public void setProductdetails(Product productdetails) {
		this.productdetails = productdetails;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Customer getCustomerdetails() {
		return customerdetails;
	}

	public void setCustomerdetails(Customer customerdetails) {
		this.customerdetails = customerdetails;
	}

	public Date getOrder_Date() {
		return order_Date;
	}

	public void setOrder_Date(Date order_Date) {
		this.order_Date = order_Date;
	}

	
	
	
}
