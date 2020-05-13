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
	int cart_Id;
	
	@Column(nullable=false)
	int quantity;
	
	
	@ManyToOne
	Customer custDetails;
	
	@ManyToOne
	Product prodDetails;

	public int getCart_Id() {
		return cart_Id;
	}

	public void setCart_Id(int cart_Id) {
		this.cart_Id = cart_Id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Customer getCustDetails() {
		return custDetails;
	}

	public void setCustDetails(Customer custDetails) {
		this.custDetails = custDetails;
	}

	public Product getProdDetails() {
		return prodDetails;
	}

	public void setProdDetails(Product prodDetails) {
		this.prodDetails = prodDetails;
	}

	
	
	}
