package com.niit.GoodiesGalo.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.GoodiesGalo.DAO.ICategoryDAO;
import com.niit.GoodiesGalo.Model.Category;


@Controller
@RequestMapping("/admin")
public class CategoryController {
	@Autowired
	ICategoryDAO categorydao;

	@RequestMapping("/category")
	String categoryPage(Model model) {
		model.addAttribute("categorypage", true);
		model.addAttribute("categorylist",categorydao.allCategory());
		model.addAttribute("categoryobject", new Category());
		model.addAttribute("title", "category");
		model.addAttribute("edit", false);
		model.addAttribute("info", false);
		model.addAttribute("message", "");
		return "index";
	}

	@RequestMapping("/addcategory")
	String addcategoryPage(@Valid @ModelAttribute("categoryobject")Category category,BindingResult br,Model model)
	{
		try
		{
		if(br.hasErrors())
		{
			model.addAttribute("info", true);
			model.addAttribute("message", "Please Enter Data In Correct Format");
			model.addAttribute("categoryobject", category);//this line will help in populating errors
			System.out.println("HasErrors");
			
		}
		else
		{
			if(categorydao.addCategory(category))
				{
					model.addAttribute("info", true);
					model.addAttribute("message", "Category Added");
					System.out.println("Done");
					model.addAttribute("categoryobject",new Category());
				}
				else
				{
					model.addAttribute("info", true);
					model.addAttribute("message", "Check Data");
					model.addAttribute("categoryobject",category);
					System.out.println("Failure");
				}
		}
		}
		
		catch(Exception e)
		{
			model.addAttribute("info", true);
			model.addAttribute("message", "Check Data");
			model.addAttribute("categoryobject",category);
			System.out.println("Failure");
			
		}
		model.addAttribute("edit", false);
		model.addAttribute("categorypage",true);
		model.addAttribute("categorylist",categorydao.allCategory());
		
		model.addAttribute("title","GoodiesGalo--Category");
		
		return "index";
	}
	@RequestMapping("/deletecategory")
	String deleteCategory(@RequestParam("catname") String category_name,Model model)
	{
		try
		{
			Category category =categorydao.oneCategory(category_name);
			if(categorydao.deleteCategory(category)) {
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
		
		model.addAttribute("categorypage", true);
		model.addAttribute("categorylist", categorydao.allCategory());
		model.addAttribute("categoryobject", new Category());
		model.addAttribute("title", "category");
		model.addAttribute("edit", false);
		return "index";
		}
	
	@RequestMapping("/getdatatoedit")
	String getOneCategoryToEdit(@RequestParam("catname")String catname,Model model)
	{
		model.addAttribute("edit", true);
		model.addAttribute("categorypage", true);
		model.addAttribute("categorylist", categorydao.allCategory());
		model.addAttribute("categoryobject", categorydao.oneCategory(catname));
		model.addAttribute("title", "category");
		model.addAttribute("info", true);
		model.addAttribute("message", "Please Edit the Data that you want to change");
		return "index";
	}
	@RequestMapping("/updatecategory")
	String updateCategory(@Valid @ModelAttribute("categoryobject") Category category, BindingResult br, Model model) {
		try {
			if (br.hasErrors()) {
				model.addAttribute("edit", true);
				model.addAttribute("info", true);
				model.addAttribute("message", "Please Enter Data In correct Format");
				model.addAttribute("categoryobject", category);
				System.out.println("Done");
			} else {

				if (categorydao.updateCategory(category)) {
					model.addAttribute("info", true);
					model.addAttribute("message", "CategoryAdded");
					System.out.println("Done");
					model.addAttribute("categoryobject", new Category());
					model.addAttribute("edit", false);

				} else {
					model.addAttribute("info", true);
					model.addAttribute("message", "checkData");
					System.out.println("Failure");
					model.addAttribute("categoryobject", category);
					model.addAttribute("edit", true);
				}
			}
		} catch (Exception e) {
			model.addAttribute("info", true);
			model.addAttribute("message", "checkData");
			System.out.println("Failure");
			model.addAttribute("categoryobject", category);
			model.addAttribute("edit", true);

		}
		model.addAttribute("categorypage", true);
		model.addAttribute("categorylist", categorydao.allCategory());
		model.addAttribute("title", "category");
		return "index";
	}


}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

	
