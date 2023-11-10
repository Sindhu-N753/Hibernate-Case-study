package com.jsp.hibernate_case_study_1.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jsp.hibernate_case_study_1.entity.Cart;
import com.jsp.hibernate_case_study_1.entity.Product;

public class CartDao {
	
	Configuration cfg=new Configuration().configure().addAnnotatedClass(Cart.class).addAnnotatedClass(Product.class);
    SessionFactory sf=cfg.buildSessionFactory();
    
    public String createCart(Cart cart)
    {
    	Session session=sf.openSession();
        Transaction trans=session.beginTransaction();
		trans.commit();
		session.close();
		return "Cart successfully created";
    }
    public String addProductToCart(Cart cart)
    {
    	Session session=sf.openSession();
        Transaction trans=session.beginTransaction();
        session.save(cart);
		trans.commit();
		session.close();
		return "Product added to cart successfully";
    }
    public Cart getProductFromCart(int productId)
    {
    	Session session=sf.openSession();
        Transaction trans=session.beginTransaction();
        Cart cart=session.get(Cart.class, productId);
		trans.commit();
		session.close();
		return cart;
    }
    public String removeProductFromCart(Cart cartProduct) 
    {
    	Session session=sf.openSession();
        Transaction trans=session.beginTransaction();
        session.save(cartProduct);
		trans.commit();
		session.close();
		return "cartProduct deleted successfully";
    }
}
