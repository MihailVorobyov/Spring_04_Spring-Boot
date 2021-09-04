package ru.vorobyov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.vorobyov.entities.Product;
import ru.vorobyov.service.ProductsService;

@Controller
public class ProductsController {
	
	@Autowired
	private ProductsService productsService;
	
	@Autowired
	public void setProductsService(ProductsService productsService) {
		this.productsService = productsService;
	}
	
	@GetMapping("/")
	public String showIndexPage() {
		return "index_page";
	}
	
	@GetMapping("/showProducts")
	public String showAllProducts(Model uiModel) {
		uiModel.addAttribute("productList", productsService.getProductList());
		return "products";
	}

	@GetMapping("/findProduct")
	public String findProduct(Model uiModel) {
		uiModel.addAttribute("product", new Product());
		return "findProduct";
	}
	
	@RequestMapping("/processFind")
	public String processFind(Model uiModel, @ModelAttribute("product") Product product) {
		Product result = productsService.getProductById(product.getId());
		uiModel.addAttribute("resultProduct", result);
		uiModel.addAttribute("product", new Product());
		return "findProduct";
	}
	
	@GetMapping("/addProduct")
	public String addProduct(Model uiModel) {
		
		Product product = new Product();
		uiModel.addAttribute("product", product);
		return "addProductForm";
	}
	
	@PostMapping("/processAdd")
	public String processAdd(@ModelAttribute("product") Product product) {
		productsService.addProduct(product);
		return "redirect:addProduct";
	}
	
	@PostMapping("/processDelete")
	public String processDelete(@ModelAttribute("product") Product product) {
		productsService.deleteById(product.getId());
		return "admin_form";
	}
}
