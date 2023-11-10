package com.jsp.hibernate_case_study_1.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jsp.hibernate_case_study_1.entity.Cart;
import com.jsp.hibernate_case_study_1.entity.Product;

public class ProductDao {
	
	Configuration cfg=new Configuration().configure().addAnnotatedClass(Cart.class).addAnnotatedClass(Product.class);
    SessionFactory sf=cfg.buildSessionFactory();
    
	public String addProduct(Product product) {
        Session session=sf.openSession();
        Transaction trans=session.beginTransaction();
		session.save(product);
		trans.commit();
		session.close();
		return "Product successfully added";
	}
	public Product getProductById(int productId) {
		Session session=sf.openSession();
        Transaction trans=session.beginTransaction();
        Product product=session.get(Product.class, productId);
        System.out.println(product);
        trans.commit();
		session.close();
		return product;
	}
	public List<Product> getAllProducts() {
		Session session=sf.openSession();
        Transaction trans=session.beginTransaction();
        
		Query query = session.createQuery("from Product");
		List<Product> products=query.getResultList();
		trans.commit();
		session.close();
		return products;
	}
	public String updateProduct(Product product) {
		Session session=sf.openSession();
        Transaction trans=session.beginTransaction();
        session.update(product);
        trans.commit();
		session.close();
		return "Product updated successfully";
	}
	public String deleteProduct(Product product) {
		Session session=sf.openSession();
        Transaction trans=session.beginTransaction();
        session.delete(product);
        trans.commit();
		session.close();
		return "Product deleted successfully";
	}
}
