package com.jsp.hibernate_case_study_1.service;

import java.util.Scanner;

import com.jsp.hibernate_case_study_1.dao.CartDao;
import com.jsp.hibernate_case_study_1.dao.ProductDao;
import com.jsp.hibernate_case_study_1.entity.Cart;
import com.jsp.hibernate_case_study_1.entity.Product;

public class CartService {
	Scanner sc=new Scanner(System.in);
	ProductDao productdao=new ProductDao();
	Cart cart=new Cart();
	CartDao cartdao=new CartDao();
	
	public void createCart() {
		String string=cartdao.createCart(cart);
		System.out.println(string);
	}
	public void addProductToCart() {
		System.out.println("Enter the product id you want to add to cart");
        int productId=sc.nextInt();
        Product product=productdao.getProductById(productId);
        if(product!=null)
        {
        	cart.getProducts().add(product);
        	cartdao.addProductToCart(cart);
        }
        else
        {
        	System.err.println("Product with id "+productId+" not found!!");
        }
        
	}
	public void removeProductFromCart() {
		System.out.println("Enter id for the product you want to purchase");
		int productId=sc.nextInt();
		Cart cartProduct=cartdao.getProductFromCart(productId);
		if(cart!=null)
			cartdao.removeProductFromCart(cartProduct);
		else
			System.err.println("product");
	}
}
