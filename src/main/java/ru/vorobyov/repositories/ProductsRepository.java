package ru.vorobyov.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.vorobyov.entites.Product;

import java.util.ArrayList;
import java.util.List;

@Component
@Repository
public class ProductsRepository {
	
	private static int id = 1;
	
	private List<Product> productList;
	
	public ProductsRepository() {
		productList = new ArrayList<>();
		
		Product product1 = new Product();
		product1.setId(id++);
		product1.setTitle("Яблоки");
		product1.setCost(50.0);
		
		Product product2 = new Product();
		product2.setId(id++);
		product2.setTitle("Груши");
		product2.setCost(70.0);
		
		Product product3 = new Product();
		product3.setId(id++);
		product3.setTitle("Бананы");
		product3.setCost(45.0);
		
		productList.add(product1);
		productList.add(product2);
		productList.add(product3);
	}
	
	public List<Product> getProductList() {
		return productList;
	}
	
	public Product getProductById (int id) {
		for (Product p : productList) {
			if (p.getId() == id) {
				return p;
			}
		}
		return null;
	}
	
	public void addProduct(Product newProduct) {
		newProduct.setId(id++);
		productList.add(newProduct);
	}
}
