package com.niit.GoodiesGalo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int Id;
	
	@Column(nullable=false, unique=true)
	String Name;
	
	@Column(nullable=false,columnDefinition = "text")
	String Descrption;//string in java is equalent to varchar in sql--hbm2ddl
	
	@Column(nullable=false)
	int Stock_int;
	
	@Column(nullable=false)
	float Price_float;
	
	@ManyToOne
	Category Pro_category;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescrption() {
		return Descrption;
	}

	public void setDescrption(String descrption) {
		Descrption = descrption;
	}

	public int getStock_int() {
		return Stock_int;
	}

	public void setStock_int(int stock_int) {
		Stock_int = stock_int;
	}

	public float getPrice_float() {
		return Price_float;
	}

	public void setPrice_float(float price_float) {
		Price_float = price_float;
	}

	public Category getPro_category() {
		return Pro_category;
	}

	public void setPro_category(Category pro_category) {
		Pro_category = pro_category;
	}
	

}
