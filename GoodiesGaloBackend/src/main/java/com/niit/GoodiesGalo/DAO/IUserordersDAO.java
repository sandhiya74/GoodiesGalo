package com.niit.GoodiesGalo.DAO;

import java.util.ArrayList;

import com.niit.GoodiesGalo.Model.Customer;
import com.niit.GoodiesGalo.Model.UserOrders;

public interface IUserordersDAO {
	
	public boolean addUserOrders(UserOrders userorders);
	
	public boolean updateUserOrdersr(UserOrders userorders);
	
	public boolean deleteUserOrders(UserOrders userorders);
	
	public ArrayList<UserOrders> allUserOrders(Customer cust);
	
	public UserOrders oneUserOrders(String orderid);

}
