package com.niit.GoodiesGalo.Model;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;


@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int cust_id;
	@Email
	@Column(nullable=false,unique=true)
	String cust_Emailid;
	
	@Length(min = 3,message = "The minimum no. of charecter is 3")
	@Column(nullable=false)
	String cust_Name;
	
	@Pattern(regexp="[0-9]{10}",message="Mobile no. must be of Indian Standards")
	@Column(nullable=false,unique=true)
	String cust_Phone;
	
	@Pattern(regexp="^[a-zA-Z0-9]+$",message=" it will check for alphanumeric (Alpha Numeric) values.")
	@Transient
	@Column(nullable=false)
	String cust_Password;

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

	public String getCust_Password() {
		return cust_Password;
	}

	public void setCust_Password(String cust_Password) {
		this.cust_Password = cust_Password;
	}

	
	}
	
	
	
	
	
	


