package com.niit.GoodiesGalo.Controller;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.GoodiesGalo.DAO.IAddressDAO;
import com.niit.GoodiesGalo.Model.Address;
import com.niit.GoodiesGalo.Model.Category;
import com.niit.GoodiesGalo.Model.Customer;



@Controller
@RequestMapping("/user")
public class AddressController {

	@Autowired
	IAddressDAO addressdao;
	
	@RequestMapping("/selectaddress")
	String addressPage(Model model,HttpSession session)
	{
		
		Customer cust=(Customer)session.getAttribute("custdetails");
		model.addAttribute("addresspage", true);
		model.addAttribute("addresslist", addressdao.allAddress(cust));
		model.addAttribute("addressobject", new Address());
		return "index";
	}

	@RequestMapping("/addaddress")
	String addaddressPage(@RequestParam Map<String, String> addressmodel,Model model,HttpSession session)
	{
		System.out.println(addressmodel.get("pincode"));

		Customer cust=(Customer)session.getAttribute("custdetails");
		Address address=new Address();
		address.setArea(addressmodel.get("area"));
		address.setCustomer(cust);
		address.setLine1(addressmodel.get("line1"));
		address.setLine2(addressmodel.get("line2"));
		address.setName(addressmodel.get("name"));
		address.setPincode(Integer.parseInt(addressmodel.get("pincode")));
		System.out.println(addressmodel.get("pincode"));
		try
		{
		if(addressdao.addAddress(address))
		{
			model.addAttribute("info", true);
			model.addAttribute("message","Address Inserted");
			
		}
		else
		{
			model.addAttribute("info", true);
			model.addAttribute("message","Address Not  Inserted");
		}
		}
		catch(Exception e) 
		{
			model.addAttribute("info", true);
			model.addAttribute("message","Address Not  Inserted");
		}
		model.addAttribute("addresspage", true);
		model.addAttribute("addresslist", addressdao.allAddress(cust));
		return "index";
	}
	@RequestMapping("/deleteaddress")
	String deleteAddress(@RequestParam("addressid") int addressid,Model model,HttpSession session)
	{
		try
		{
			
			if(addressdao.deleteAddress(addressdao.oneAddress(addressid)))
			{
				model.addAttribute("info",true);
				model.addAttribute("message","Data Deleted");
			}
			else
			{
				model.addAttribute("info",true);
				model.addAttribute("message","Data Not Deleted");
			}
				
			
		}
		catch (Exception e)
		{
			model.addAttribute("info",true);
			model.addAttribute("message","Data Deleted");
		}
		
		Customer cust=(Customer)session.getAttribute("custdetails");
		model.addAttribute("addresspage", true);
		model.addAttribute("addresslist", addressdao.allAddress(cust));
		
		return "index";
		}
	@RequestMapping("/editaddress")
	String editAddress(@RequestParam("addressid")int addressid,Model model,HttpSession session)
	{
		model.addAttribute("edit", true);
		Customer cust=(Customer)session.getAttribute("custdetails");
		model.addAttribute("addresspage", true);
		model.addAttribute("addresslist", addressdao.allAddress(cust));
		model.addAttribute("addressobject", addressdao.oneAddress(addressid));
		System.out.println( addressdao.oneAddress(addressid).getArea());
		return "index";
	}
	@RequestMapping("/updateaddress")
	String updateaddressPage(@RequestParam Map<String, String> addressmodel,Model model,HttpSession session)
	{
		Customer cust=(Customer)session.getAttribute("custdetails");
		Address address=new Address();
		address.setAddress_Id(Integer.parseInt(addressmodel.get("addressid")));
		address.setArea(addressmodel.get("area"));
		address.setCustomer(cust);
		address.setLine1(addressmodel.get("line1"));
		address.setLine2(addressmodel.get("line2"));
		address.setName(addressmodel.get("name"));
		address.setPincode(Integer.parseInt(addressmodel.get("pincode")));
		try
		{
		if(addressdao.updateAddress(address))
		{
			model.addAttribute("info", true);
			model.addAttribute("message","Address Inserted");
			
		}
		else
		{
			model.addAttribute("info", true);
			model.addAttribute("message","Address Not  Inserted");
		}
		}
		catch(Exception e) 
		{
			model.addAttribute("info", true);
			model.addAttribute("message","Address Not  Inserted");
		}
		model.addAttribute("addresspage", true);
		model.addAttribute("addresslist", addressdao.allAddress(cust));
		return "index";
	}
	
}
