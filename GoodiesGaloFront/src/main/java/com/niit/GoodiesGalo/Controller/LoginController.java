package com.niit.GoodiesGalo.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.GoodiesGalo.DAO.ICartDAO;
import com.niit.GoodiesGalo.DAO.ICustomerDao;
import com.niit.GoodiesGalo.Model.Cart;
import com.niit.GoodiesGalo.Model.Customer;

@Controller
public class LoginController {
	@Autowired
	ICustomerDao customerdao;
	
	@Autowired
	ICartDAO cartdao;
	@RequestMapping("/login")

	  String LoginPage(@RequestParam(value="error",required=false, defaultValue ="false") boolean error,Model model)
	  {
		  if(error)
		  {
			  model.addAttribute("info",true);
			  model.addAttribute("message","user name password incorrect");
			  
		  }
		  else
		  {
			  model.addAttribute("info",false);
			  model.addAttribute("message","");
		  }
	    model.addAttribute("loginpage",true);
	    model.addAttribute("tittle","GoodiesGalo--login");
	    return "index";
	  }
	@RequestMapping("/loginsuccess")
	String loginSuccess(Model model,HttpSession session)
	{
		String userid=SecurityContextHolder.getContext().getAuthentication().getName();
		String role=SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();
		System.out.println(role);
		if(role.equals("[ROLE_ADMIN]"))
		{
			session.setAttribute("username", "ADMINSTRATOR");
			session.setAttribute("adminrole", true);
			
		}
		else
		{
			Customer customer=customerdao.selectCustomer(userid);
			session.setAttribute("custdetails", customer);
			session.setAttribute("username", customer.getCust_Name().toUpperCase());
			session.setAttribute("userrole", true);
			session.setAttribute("adminrole", false);
			ArrayList<Cart> cartlist = cartdao.allcart(customer);
			session.setAttribute("cartinfo", cartlist);
			session.setAttribute("cartqty", cartlist.size());
			if(session.getAttribute("pid") != null)
			{
				int pid=Integer.parseInt(session.getAttribute("pid").toString());
				int qty=Integer.parseInt(session.getAttribute("qty").toString());
				return "redirect:/addtocart?productid="+ pid + "&quantity=" + qty;
				
				
			}
		}
		model.addAttribute("indexpage",true);
		return "index";
		
	}
}
