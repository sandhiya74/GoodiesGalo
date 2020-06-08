package com.niit.GoodiesGalo.Controller;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.GoodiesGalo.DAO.ICartDAO;
import com.niit.GoodiesGalo.DAO.IProductDAO;
import com.niit.GoodiesGalo.Model.Cart;
import com.niit.GoodiesGalo.Model.Customer;
import com.niit.GoodiesGalo.Model.Product;

@Controller
public class CartController {
	@Autowired
	IProductDAO productdao;
	
	@Autowired
	ICartDAO cartdao;


	
	@RequestMapping("/addtocart")
	
	String addToCart(@RequestParam("productid") int pid, @RequestParam(required=false,value="quantity",defaultValue="1") int qty, @RequestParam(value="cartpage",required=false,defaultValue="false") boolean cartpage,Model model,HttpSession session )
	{
		Customer c=(Customer)session.getAttribute("custdetails");
		if(session.getAttribute("cartinfo")==null)
		{
			session.setAttribute("pid", pid);
			session.setAttribute("qty", qty);
			model.addAttribute("loginpage",true);
		}
		else
		{
			Cart item=new Cart();
			
			Product p = productdao.oneProduct(pid);
			ArrayList<Cart> cartlist=(ArrayList<Cart>)session.getAttribute("cartinfo");
			if(cartlist.isEmpty())
			{
				item.setCustDetails(c);
				item.setProdDetails(p);
				if(p.getPro_Stock()>=qty)
				{
					item.setPro_Quantity(qty);
				}
				else
				{
					item.setPro_Quantity(1);
					model.addAttribute("error", true);
					model.addAttribute("message", "Stock insufficent");
					model.addAttribute("pid", p.getPro_Id());
				}
				cartdao.addCart(item);
			}
			else
			{
				int flag = 1;
	               Iterator<Cart> cartitem=cartlist.listIterator();	
				while(cartitem.hasNext())
	               {
	            	   Cart cart=(Cart) cartitem.next();
	            	   if(cart.getProdDetails().getPro_Id()==pid)
	            	   {
	            		  if(cartpage)
	            		  {
	            			  if(qty > p.getPro_Stock())
		            		   {
	            				   model.addAttribute("error", true);
		       					   model.addAttribute("message", "Stock insufficent");
		       					model.addAttribute("pid", p.getPro_Id());
		            		   }
		            		   else
		            		   {
		            			   cart.setPro_Quantity(qty);
		            			   cartdao.updateCart(cart);
		            		   }
	            		  }
	            		  else
	            		  {
	            			  int oldqty =cart.getPro_Quantity();
	            			  int newqty =oldqty +qty;
	            			  if(newqty > p.getPro_Stock())
	            				  
		            		   {
		            			   model.addAttribute("error", true);
		       					   model.addAttribute("message", "Stock insufficent");
		       					   model.addAttribute("pid", p.getPro_Id());
		            		   }
		            		   else
		            		   {
		            			   cart.setPro_Quantity(newqty);
		            			   cartdao.updateCart(cart);
		            		   }
	            		  }
	            		   
	            		   flag = 0;
	            		   break;
	            	   }
	               }
	               if(flag==1)
	               {
	            	   item.setCustDetails(c);
	   				item.setProdDetails(p);
	   				if(p.getPro_Stock()>=qty)
	   				{
	   					item.setPro_Quantity(qty);
	   				}
	   				else
	   				{
	   					model.addAttribute("error", true);
	   					model.addAttribute("message", "Stock insufficent");
	   					model.addAttribute("pid", p.getPro_Id());
	   				}
	   				cartdao.addCart(item);
	               }
			}
			float total=0;
			cartlist=cartdao.allcart(c);
			Iterator<Cart> cartiterator=cartlist.iterator();
			while(cartiterator.hasNext())
			{
				Cart cart=(Cart) cartiterator.next();
				total=total+(cart.getPro_Quantity()*cart.getProdDetails().getPro_Price());
			}
			session.setAttribute("total",total );
			session.setAttribute("cartinfo",cartlist );
			model.addAttribute("cartpage", true);
		}
		return "index";
		
	}
	
	
	
	@RequestMapping("/user/viewcart")
	String viewCart(HttpSession session,Model model)
	{
		Customer cust=(Customer)session.getAttribute("custdetails");
		if(session.getAttribute("cartinfo")== null)
		{
			ArrayList<Cart>cartlist=cartdao.allcart(cust);
			float total=0;
			Iterator<Cart> cartiterator=cartlist.iterator();
			while(cartiterator.hasNext())
			{
				Cart cart=(Cart) cartiterator.next();
				total=total+(cart.getPro_Quantity()*cart.getProdDetails().getPro_Price());
			}
			session.setAttribute("total",total );
			session.setAttribute("cartinfo",cartlist );
			session.setAttribute("cartinfo", cartdao.allcart(cust));		   
		}
		
		 model.addAttribute("cartpage", true);
   		return "index";
	
		
	}
	@RequestMapping("/user/deleteitem")
	String deleteCart(@RequestParam("cartid") int cartid,Model model,HttpSession session)
	{
		System.out.println(cartid);
		Customer cust=(Customer)session.getAttribute("custdetails");
		cartdao.deleteCart(cartdao.oneCart(cartid));
		session.setAttribute("cartinfo", cartdao.allcart(cust));
		model.addAttribute("cartpage", true);
	    return "index";
		
	
	}
	

}
