package com.niit.GoodiesGalo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class CustomerCred {
	
	
	@Id
	String cust_Emailid;
	
	@Column(nullable=false)
	String cust_role;
	
	@Column(nullable=false)
	String cust_status;
	
	
	@Column(nullable=false)
	String cust_Password;


	public String getCust_Emailid() {
		return cust_Emailid;
	}


	public void setCust_Emailid(String cust_Emailid) {
		this.cust_Emailid = cust_Emailid;
	}


	public String getCust_role() {
		return cust_role;
	}


	public void setCust_role(String cust_role) {
		this.cust_role = cust_role;
	}


	public String getCust_status() {
		return cust_status;
	}


	public void setCust_status(String cust_status) {
		this.cust_status = cust_status;
	}


	public String getCust_Password() {
		return cust_Password;
	}


	public void setCust_Password(String cust_Password) {
		this.cust_Password = cust_Password;
	}


}
