package com.niit.GoodiesGalo.DAO;

import com.niit.GoodiesGalo.Model.Customer;

public interface ICustomerDao {

	public boolean addCustomer(Customer customer);
	public boolean updateCustomer(Customer customer);
	public Customer selectCustomer(String emailId);
}
