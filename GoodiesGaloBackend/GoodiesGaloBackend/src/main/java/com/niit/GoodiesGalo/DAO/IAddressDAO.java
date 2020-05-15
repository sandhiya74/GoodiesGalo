package com.niit.GoodiesGalo.DAO;

import java.util.ArrayList;

import com.niit.GoodiesGalo.Model.Address;
import com.niit.GoodiesGalo.Model.Customer;

public interface IAddressDAO {

	
	public boolean addAddress(Address address);
	
	public boolean updateAddress(Address address);
	
	public boolean deleteAddress(Address address);
	
	public ArrayList<Address> allAddress(Customer cust);
	
	public Address oneAddress(int addressid);
}
