package com.niit.GoodiesGalo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity

public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int Cart_id;
	
	@Column(nullable=false)
	int Quantity_int;
	
	
	@ManyToOne
	Customer CustDetails;
	
	@ManyToOne
	Product ProdDetails;

	public int getCart_id() {
		return Cart_id;
	}

	public void setCart_id(int cart_id) {
		Cart_id = cart_id;
	}

	public int getQuantity_int() {
		return Quantity_int;
	}

	public void setQuantity_int(int quantity_int) {
		Quantity_int = quantity_int;
	}

	public Customer getCustDetails() {
		return CustDetails;
	}

	public void setCustDetails(Customer custDetails) {
		CustDetails = custDetails;
	}

	public Product getProdDetails() {
		return ProdDetails;
	}

	public void setProdDetails(Product prodDetails) {
		ProdDetails = prodDetails;
	}

	}
