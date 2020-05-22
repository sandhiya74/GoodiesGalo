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
	int pro_Quantity;
	
	
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

	public int getPro_Quantity() {
		return pro_Quantity;
	}

	public void setPro_Quantity(int pro_Quantity) {
		this.pro_Quantity = pro_Quantity;
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
