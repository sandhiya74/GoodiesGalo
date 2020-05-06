package com.niit.GoodiesGalo.DAO;

import java.util.ArrayList;

import com.niit.GoodiesGalo.Model.Cart;
import com.niit.GoodiesGalo.Model.Customer;

public interface ICartDAO {
	
	public boolean addCart(Cart cart);
	
	public boolean updateCart(Cart cart);
	
	public boolean deleteCart(Cart cart);
	
	public ArrayList<Cart> allcart(Customer cust);

	public Cart oneCart(int cartid);
	

}
