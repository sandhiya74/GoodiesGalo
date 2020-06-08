package com.niit.GoodiesGalo.Model;

import java.util.Date;  
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class UserOrders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int dummyid;
	
	String order_Id;
	
	@Column(nullable=false)
	float total;
	
	@ManyToOne
	Product product_Details;
	
	@ManyToOne
	Address address;
	
	int productqty;
	
	@ManyToOne
	Customer customer_Details;
	
	@Column(nullable=false)
 @Temporal(TemporalType.DATE)
	 Date order_Date;

	public int getDummyid() {
		return dummyid;
	}

	public void setDummyid(int dummyid) {
		this.dummyid = dummyid;
	}

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

	public Product getProduct_Details() {
		return product_Details;
	}

	public void setProduct_Details(Product product_Details) {
		this.product_Details = product_Details;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getProductqty() {
		return productqty;
	}

	public void setProductqty(int productqty) {
		this.productqty = productqty;
	}

	public Customer getCustomer_Details() {
		return customer_Details;
	}

	public void setCustomer_Details(Customer customer_Details) {
		this.customer_Details = customer_Details;
	}

	public Date getOrder_Date() {
		return order_Date;
	}

	public void setOrder_Date(Date date) {
		this.order_Date = date;
	}

	
	
	
	
}
