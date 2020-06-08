package com.niit.GoodiesGalo.Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.GoodiesGalo.DAO.IAddressDAO;
import com.niit.GoodiesGalo.DAO.ICartDAO;
import com.niit.GoodiesGalo.DAO.IProductDAO;
import com.niit.GoodiesGalo.DAO.IUserordersDAO;
import com.niit.GoodiesGalo.Model.Cart;
import com.niit.GoodiesGalo.Model.Address;
import com.niit.GoodiesGalo.Model.Customer;
import com.niit.GoodiesGalo.Model.Product;
import com.niit.GoodiesGalo.Model.UserOrders;



@Controller
@RequestMapping("/user")
 class UserorderController {
	
	@Autowired
	IAddressDAO addressdao;
	
	@Autowired
	IUserordersDAO userordersdao;
	@Autowired
	IProductDAO productdao;
	
	@Autowired
	ICartDAO cartdao;
	
	@RequestMapping("/placeorder")
	String placeOrder(@RequestParam ("addressid")int addressid,HttpSession session,Model model)
	{
	    
		UserOrders userorder=new UserOrders();
	    ArrayList<Cart> cartlist=(ArrayList<Cart>)session.getAttribute("cartinfo");
	    Address address=addressdao.oneAddress(addressid);
		Customer customer=(Customer)session.getAttribute("custdetails");
		String orderid="OD" +UUID.randomUUID().getMostSignificantBits();
		Iterator<Cart> cartIterator=cartlist.iterator();
		while(cartIterator.hasNext())
		{
			Cart cart=(Cart) cartIterator.next();
			userorder.setAddress(address);
			userorder.setOrder_Date(new Date());
			userorder.setCustomer_Details(customer);
		    userorder.setOrder_Id(orderid);
		    userorder.setProduct_Details(cart.getProdDetails());
		    userorder.setProductqty(cart.getPro_Quantity());
		    userorder.setTotal(Float.parseFloat(session.getAttribute("total").toString()));
		    Product p=cart.getProdDetails();
		    if(p.getPro_Stock()>= cart.getPro_Quantity() && userordersdao.addUserOrders(userorder))
		    {
		    	
		    	p.setPro_Stock(p.getPro_Stock()- cart.getPro_Quantity());
		    	productdao.updateProduct(p);
		    	cartdao.deleteCart(cart);
		    }
		    float total=0;
		    ArrayList<UserOrders> userorderslist = userordersdao.allUserOrders(customer);
			Iterator<UserOrders> UserOrdersiterator=userorderslist.iterator();
			while(UserOrdersiterator.hasNext())
			{
				UserOrders userorders=(UserOrders) UserOrdersiterator.next();
				total=total+(userorders.getProductqty()*userorders.getProduct_Details().getPro_Price());
			}
			session.setAttribute("total",total );
			session.setAttribute("cartinfo",cartlist );
			model.addAttribute("orderpage", true);
		}
		cartlist=cartdao.allcart(customer);
		session.setAttribute("total",0 );
		session.setAttribute("cartinfo",cartlist );
		return "redirect:/user/viewallorders";
		
		
	}
	@RequestMapping("/viewallorders")
	String viewOrders(HttpSession session,Model model)
	{
		Customer cust=(Customer)session.getAttribute("custdetails");
		ArrayList<UserOrders> orders=userordersdao.allUserOrders(cust);
		model.addAttribute("orderlist", orders);
		model.addAttribute("orderpage", true);
		return "index";
		
	}
	@RequestMapping("/viewdetails")
	String viewDetails(@RequestParam("oid")String orderid,Model model)
	{
	
		ArrayList<UserOrders> orders=userordersdao.oneUserOrders(orderid);
		model.addAttribute("orderlist", orders);
		model.addAttribute("oneorderpage", true);
		return "index";
		
	}
	
	

}
