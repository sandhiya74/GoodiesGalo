package com.niit.GoodiesGalo.DAO;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.GoodiesGalo.Model.Category;
import com.niit.GoodiesGalo.Model.Customer;
import com.niit.GoodiesGalo.Model.Product;
import com.niit.GoodiesGalo.Model.UserOrders;
@Repository("CatagoryDAO")
@Transactional
public class UserordersDAOImpl implements IUserordersDAO {
	@Autowired
	SessionFactory sessionfactory;
	
	@Override
	public boolean addUserOrders(UserOrders userorders) {
		try {
			sessionfactory.getCurrentSession().save("Userorders");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateUserOrdersr(UserOrders userorders) {
		try {
			sessionfactory.getCurrentSession().update("Userorders");
			return true;
		} 
		catch (Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean deleteUserOrders(UserOrders userorders) {
		try {
			sessionfactory.getCurrentSession().delete("Userorders");
			return true;
		} 
		catch (Exception e)
		{
			return false;
		}
	}

	@Override
	public ArrayList<UserOrders> allUserOrders(Customer cust) {
		try
		{
			ArrayList<UserOrders> userorderslist = (ArrayList<UserOrders>) sessionfactory.getCurrentSession().createCriteria(UserOrders.class).add(Restrictions.eq("Customerdetails", cust)).list();
			return userorderslist;
		}
		catch (Exception e)
		{
			return null;
			
		}

	}

	@Override
	public UserOrders oneUserOrders(String orderid) {
		try
		{
			UserOrders userorders = (UserOrders) sessionfactory.getCurrentSession().createCriteria(UserOrders.class).add(Restrictions.eq("Order_id",orderid)).uniqueResult();
			return userorders;
		}
		catch(Exception e)
		{
			return null;
		}
	}

}
