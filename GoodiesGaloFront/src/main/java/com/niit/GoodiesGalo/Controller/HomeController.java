package com.niit.GoodiesGalo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
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
	@RequestMapping("/login")

	  String LoginPage(Model model)
	  {
	    model.addAttribute("loginpage",true);
	    model.addAttribute("tittle","GoodiesGalo--login");
	    return "index";
	  }
	

}
