package ru.vorobyov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import ru.vorobyov.entites.Product;
import ru.vorobyov.service.ProductsService;

@Controller
public class ProductsController {
	
	@Autowired
	private ProductsService productsService;
	
	@Autowired
	public void setProductsService(ProductsService productsService) {
		this.productsService = productsService;
	}
	
	@GetMapping("/shop")
	public String showIndexPage() {
		return "index_page";
	}
	
	@GetMapping("/showProducts")
	public String showAllProducts(Model uiModel) {
		uiModel.addAttribute("products", productsService.getProductList());
		return "products";
	}
	
	@GetMapping("/product")
	public String showProduct(Model uiModel, @RequestParam("id") int id) {
		uiModel.addAttribute("product", productsService.getProductById(id));
		return "product";
	}
	
	@GetMapping("/addProduct")
	public String showAddProductForm(Model uiModel) {
		Product product = new Product();
		uiModel.addAttribute("product", product);
		return "addProductForm";
	}
	
	
	@GetMapping("/processForm")
	public String processForm(@ModelAttribute("product") Product product) {
		productsService.addProduct(product);
		return "addProductForm";
	}
	
}
