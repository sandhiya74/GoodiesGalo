package com.niit.GoodiesGalo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.GoodiesGalo.DAO.IProductDAO;

@Controller
public class HomeController {
	@Autowired
	IProductDAO productdao;
	@RequestMapping(value={"/","/home"})
	
	String indexpage(Model model)
	{
		model.addAttribute("indexpage",true);
		model.addAttribute("tittle","GoodiesGalo--Home");
		    return "index";
		
	}
	@RequestMapping("/aboutus")

	  String AboutusPage(Model model)
	  {
	    model.addAttribute("aboutuspage",true);
	    model.addAttribute("tittle","GoodiesGalo--Aboutus");
	    return "index";
	  }

	@RequestMapping("/contactus")

	  String ContactusPage(Model model)
	  {
	    model.addAttribute("contactuspage",true);
	    model.addAttribute("tittle","GoodiesGalo--contactus");
	    return "index";
	  }
	
	@RequestMapping("/allproducts")
	String DisplayProduct(Model model)
	{
		model.addAttribute("productlist", productdao.allProduct());
		model.addAttribute("cust_productpage",true);
		return "index";
	}
	 
	@RequestMapping("/productdetails")
	String ProductDetails(@RequestParam("prodid") int prodid, Model model)
	{
		
		model.addAttribute("product", productdao.oneProduct(prodid));
		model.addAttribute("productdetails",true);
		 model.addAttribute("tittle","GoodiesGalo--product");
		return "index";
		
	}

}
