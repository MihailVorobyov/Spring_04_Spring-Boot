package ru.vorobyov.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import ru.vorobyov.entities.Product;

import java.util.List;

@Repository
public class ProductDao {

	private SessionFactory factory;
	
	private Session session;
	
	public ProductDao() {
		factory = new Configuration()
			.configure("hibernate_cfg.xml")
			.addAnnotatedClass(Product.class)
			.buildSessionFactory();
	}
	
	public Product findById(Long id) {
		session = factory.getCurrentSession();
		
		session.beginTransaction();
		Product product = session.find(Product.class, id);
		session.disconnect();
		
		return product;
	}
	
	public List<Product> findAll() {
		session = factory.getCurrentSession();
		
		session.beginTransaction();
		List<Product> productList = session.createQuery("from Product").getResultList();
		session.disconnect();
		
		return productList;
	}
	
	public void deleteById(Long id) {
		session = factory.getCurrentSession();
		
		session.beginTransaction();
		Product productToBeDeleted = session.get(Product.class, id);
		session.delete(productToBeDeleted);
		session.getTransaction().commit();
	}
	
	public Product saveOrUpdate(Product product) {
		session = factory.getCurrentSession();
		Product productFromDB;
		
		session.beginTransaction();
		List<Product> productList = session.createQuery("from Product p where p.title = :title and p.price = :price")
			.setParameter("title", product.getTitle())
			.setParameter("price", product.getPrice())
			.getResultList();

		if (productList.isEmpty()) {
			productFromDB = product;
		} else if (productList.size() == 1) {
			productFromDB = productList.get(0);
		} else {
			productFromDB = null;
		}
		session.saveOrUpdate(product);
		session.getTransaction().commit();

		return productFromDB;
	}
}
