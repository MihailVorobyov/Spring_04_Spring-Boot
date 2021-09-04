package ru.vorobyov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vorobyov.entities.Product;
import ru.vorobyov.repositories.ProductDao;

import java.util.List;

@Service
public class ProductsService {
    
//    @Autowired
//    private ProductsRepository productsRepository;
//
//    public Product getProductById(int id) {
//        return productsRepository.getProductById(id);
//    }
//
//    public List<Product> getProductList() {
//        return productsRepository.getProductList();
//    }
//
//    public void addProduct(Product newProduct) {
//        productsRepository.addProduct(newProduct);
//    }
//
//    public ProductsService() {
    
    @Autowired
    private ProductDao productDao;
    
    public Product getProductById(long id) {
        return productDao.findById(id);
    }
    
    public List<Product> getProductList() {
        return productDao.findAll();
    }
    
    public void addProduct(Product newProduct) {
        productDao.saveOrUpdate(newProduct);
    }
    
    public void deleteById(Long id) {
        productDao.deleteById(id);
    }
    
    public ProductsService() {
    }
}
