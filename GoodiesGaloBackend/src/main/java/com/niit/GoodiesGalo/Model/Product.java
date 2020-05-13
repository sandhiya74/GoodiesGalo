package com.niit.GoodiesGalo.Model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int pro_Id;
	
	@Column(nullable=false, unique=true)
	@NotBlank(message = "Product Name Cannot be blank")               //all these are hibernate validators
	@Length(min = 3,message = "The minimum no. of charecter is 3") 
	String pro_Name;
	
	@Column(nullable=false,columnDefinition = "text")
	String pro_Description;//string in java is equalent to varchar in sql--hbm2ddl
	
	@Column(nullable=false)
	int pro_Stock;
	
	@Column(nullable=false)
	float pro_Price;
	
	@ManyToOne
	Category pro_Category;
	
	@javax.persistence.Transient
	MultipartFile pro_Images;
	

	public int getPro_Id() {
		return pro_Id;
	}

	public void setPro_Id(int pro_Id) {
		this.pro_Id = pro_Id;
	}

	public String getPro_Name() {
		return pro_Name;
	}

	public void setPro_Name(String pro_Name) {
		this.pro_Name = pro_Name;
	}

	public String getPro_Description() {
		return pro_Description;
	}

	public void setPro_Description(String pro_Description) {
		this.pro_Description = pro_Description;
	}

	public int getPro_Stock() {
		return pro_Stock;
	}

	public void setPro_Stock(int pro_Stock) {
		this.pro_Stock = pro_Stock;
	}

	public float getPro_Price() {
		return pro_Price;
	}

	public void setPro_Price(float pro_Price) {
		this.pro_Price = pro_Price;
	}

	public Category getPro_Category() {
		return pro_Category;
	}

	public void setPro_Category(Category pro_Category) {
		this.pro_Category = pro_Category;
	}

	public MultipartFile getPro_Images() {
		return pro_Images;
	}

	public void setPro_Images(MultipartFile pro_Images) {
		this.pro_Images = pro_Images;
	}

	
	

}
