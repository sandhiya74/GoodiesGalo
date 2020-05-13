package com.niit.GoodiesGalo.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.GoodiesGalo.DAO.ICategoryDAO;
import com.niit.GoodiesGalo.DAO.IProductDAO;
import com.niit.GoodiesGalo.Model.Category;
import com.niit.GoodiesGalo.Model.Product;

@Controller
@RequestMapping("/admin")
public class ProductController {
	@Autowired
	IProductDAO productdao;
	@Autowired
	ICategoryDAO categorydao;

	@RequestMapping("/product")
	String ProductPage(Model model) {
		model.addAttribute("productpage", true);
		model.addAttribute("categorylist", categorydao.allCategory());
		model.addAttribute("productobject", new Product());
		model.addAttribute("productlist", productdao.allProduct());
		model.addAttribute("title", "product");
		model.addAttribute("edit", false);
		model.addAttribute("info", false);
		model.addAttribute("message", "");
		return "index";
	}

	@RequestMapping("/addproduct")
	String addProductPage(@Valid @ModelAttribute("productobject") Product product, BindingResult br, Model model) {
		System.out.println(product.getPro_Category().getCat_Id());
		try {
			if (br.hasErrors()) {

				model.addAttribute("info", true);
				model.addAttribute("message", "Please Enter Data In Correct Format");
				model.addAttribute("productobject", product);// this line will help in populating errors
				System.out.println("HasErrors");

			} else {
				if (productdao.addProduct(product)) {
					addImage(product.getPro_Id(), product.getPro_Images());
					model.addAttribute("info", true);
					model.addAttribute("message", "Product Added");
					System.out.println("Done");
					model.addAttribute("productobject", product);
				} else {
					model.addAttribute("info", true);
					model.addAttribute("message", "Check Data");
					model.addAttribute("productobject", product);
					System.out.println("Failure");
				}
			}
		}

		catch (Exception e) {
			model.addAttribute("info", true);
			model.addAttribute("message", " Check Data");
			model.addAttribute("productobject", product);
			System.out.println(e);
			System.out.println("Failure");

		}
		model.addAttribute("edit", false);
		model.addAttribute("productpage", true);
		model.addAttribute("productlist", productdao.allProduct());
		model.addAttribute("categorylist", categorydao.allCategory());
		model.addAttribute("title", "product");
		return "index";

	}

	private void addImage(int pro_Id, MultipartFile pro_Images) {
		// i am saying the path the file is to be created.
		String path = "D:\\GoodiesGaloFront\\src\\main\\webapp\\resources\\productimages\\";
		/*
		 * create the image file url; the image file url will have path+file name+.jpg
		 * extension
		 */
		try {
			if (pro_Images.getSize() != 0) {
				path = path + String.valueOf(pro_Id) + ".jpeg";
				File f = new File(path);
				
				if (f.exists()) {
					f.delete();
				}
				BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream(f));
				bs.write(pro_Images.getBytes());
				bs.close();
				Thread.sleep(5000);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	

	@RequestMapping("/deleteproduct")
	String deleteCategory(@RequestParam("prodid") int prodid, Model model) {
	
	String path = "D:\\GoodiesGaloFront\\src\\main\\webapp\\resources\\productimages\\";
	/*
	 * create the image file url; the image file url will have path+file name+.jpg
	 * extension
	 */ 
			path = path + String.valueOf(prodid) + ".jpeg";
			File f = new File(path);
	     	f.delete();
			
		try {
			// Step 1: fetch the cat object from database
			Product product = productdao.oneProduct(prodid);

			if (productdao.deleteProduct(product)) {
				model.addAttribute("info", true);
				model.addAttribute("message", "Data Deleted");
			} else {
				model.addAttribute("info", true);
				model.addAttribute("message", "Data Not Deleted");
			}

		} catch (Exception e) {
			model.addAttribute("info", true);
			model.addAttribute("message", "Data Not Deleted");
		}
		model.addAttribute("productpage", true);
		model.addAttribute("productlist", productdao.allProduct());
		model.addAttribute("categorylist", categorydao.allCategory());
		model.addAttribute("productobject", new Product());
		model.addAttribute("title", "product");

		return "index";
	}

	@RequestMapping("/getproducttoedit")
	String getProductToEdit(@RequestParam("prodid") int prodid, Model model) {
		model.addAttribute("edit", true);
		model.addAttribute("info", false);
		model.addAttribute("message", "please edit the Data");

		model.addAttribute("productpage", true);
		model.addAttribute("productobject", productdao.oneProduct(prodid));
		model.addAttribute("productlist", productdao.allProduct());
		model.addAttribute("categorylist", categorydao.allCategory());
		model.addAttribute("tittle", "product");
		return "index";

	}

	@RequestMapping("/updateproduct")
	String updateProductPage(@Valid @ModelAttribute("productobject") Product product, BindingResult br, Model model) {
		try {
			if (br.hasErrors()) {
				model.addAttribute("edit", true);
				model.addAttribute("productobject", product);

				model.addAttribute("info", true);
				model.addAttribute("message", "Please Enter Data In correct Format");

				System.out.println("Done");

			} else {
				if (productdao.updateProduct(product)) {
					addImage(product.getPro_Id(), product.getPro_Images());
					model.addAttribute("edit", false);
					model.addAttribute("productobject", new Product());
					model.addAttribute("info", true);
					model.addAttribute("message", "Updated");
					System.out.println("Done");
				} else {

					model.addAttribute("edit", true);
					model.addAttribute("productobject", product);

					model.addAttribute("info", true);
					model.addAttribute("message", "checkData");
					System.out.println("Failure");

				}
			}
		} catch (Exception e) {

			model.addAttribute("edit", true);
			model.addAttribute("productobject", product);
			model.addAttribute("info", true);
			model.addAttribute("message", "checkData");
			System.out.println("Failure");
		}

		model.addAttribute("productpage", true);
		model.addAttribute("productlist", productdao.allProduct());
		model.addAttribute("categorylist", categorydao.allCategory());
		model.addAttribute("tittle", "product");
		return "index";
	}

}
