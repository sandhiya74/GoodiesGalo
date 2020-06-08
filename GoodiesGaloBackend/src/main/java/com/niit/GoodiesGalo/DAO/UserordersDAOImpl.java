package com.niit.GoodiesGalo.DAO;

import java.util.ArrayList; 

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.GoodiesGalo.Model.Customer;

import com.niit.GoodiesGalo.Model.UserOrders;
@Repository("userorderdao")
@Transactional
public class UserordersDAOImpl implements IUserordersDAO {
	@Autowired
	SessionFactory sessionfactory;
	
	@Override
	public boolean addUserOrders(UserOrders userorders) {
		try {
			sessionfactory.getCurrentSession().save(userorders);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateUserOrdersr(UserOrders userorders) {
		try {
			sessionfactory.getCurrentSession().update(userorders);
			return true;
		} 
		catch (Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean deleteUserOrders(UserOrders userorders){
		try {
			sessionfactory.getCurrentSession().delete(userorders);
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
			ArrayList<UserOrders> userorderslist = (ArrayList<UserOrders>) sessionfactory.getCurrentSession().createCriteria(UserOrders.class).add(Restrictions.eq("customer_Details", cust)).list();
			return userorderslist;
		}
		catch (Exception e)
		{
			return null;
			
		}

	}

	@Override
	public  ArrayList<UserOrders> oneUserOrders(String orderid) {
		try
		{
			ArrayList<UserOrders> userorders = (ArrayList<UserOrders>) sessionfactory.getCurrentSession().createCriteria(UserOrders.class).add(Restrictions.eq("order_Id",orderid)).list();
			return userorders;
		}
		catch(Exception e)
		{
			return null;
		}
	}

}
