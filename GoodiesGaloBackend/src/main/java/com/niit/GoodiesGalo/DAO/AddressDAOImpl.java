
package com.niit.GoodiesGalo.DAO;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.GoodiesGalo.Model.Address;
import com.niit.GoodiesGalo.Model.Category;
import com.niit.GoodiesGalo.Model.Customer;
import com.niit.GoodiesGalo.Model.Product;
@Repository("AddressDAO")
@Transactional
public class AddressDAOImpl implements IAddressDAO {

	@Autowired
	SessionFactory sessionfactory;

	@Override
	public boolean addAddress(Address address) {
		try {
			sessionfactory.getCurrentSession().save("address");
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean updateAddress(Address address) {
		try {
			sessionfactory.getCurrentSession().update("address");
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean deleteAddress(Address address) {
		try {
			sessionfactory.getCurrentSession().delete("address");
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public ArrayList<Address> allAddress(Customer cust) { //parameter is not unique in that case i will use list
		try
		{
			ArrayList<Address> addresslist = (ArrayList<Address>) sessionfactory.getCurrentSession().createCriteria(Address.class).add(Restrictions.eq("customer", cust)).list();
			return addresslist;
		}
		catch (Exception e)
		{
			return null;
		}
	}

	@Override
	public Address oneAddress(int addressid) {//paramete is a p.k so i will say unique result
		try
		{
			Address address = (Address) sessionfactory.getCurrentSession().createCriteria(Address.class).add(Restrictions.eq("Address_id",addressid)).uniqueResult();
			return address;
		}
		catch(Exception e)
		{
			return null;
		}

	}

}
