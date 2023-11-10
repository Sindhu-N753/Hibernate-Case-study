package com.jsp.hibernate_case_study_1.service;

import java.util.List;
import java.util.Scanner;

import com.jsp.hibernate_case_study_1.dao.ProductDao;
import com.jsp.hibernate_case_study_1.entity.Product;

public class ProductService {
	Scanner sc=new Scanner(System.in);
	Product product=new Product();
	ProductDao productdao=new ProductDao();
	
	public void addProduct() {
        System.out.println("Enter the product Name, Product price, Product Quantity");
        product.setProductName(sc.next());
        product.setProductPrice(sc.nextDouble());
        product.setProductQuantity(sc.nextInt());
        productdao.addProduct(product);
	}
	public void getProductById() {
		System.out.println("Enter the productId");
        int productId=sc.nextInt();
        Product product=productdao.getProductById(productId);
        System.out.println(product.getProductName()+"  "+product.getProductPrice()+"  "+product.getProductQuantity());
	}
	public void getAllProducts(){
	List<Product> allProducts=productdao.getAllProducts();
	allProducts.forEach(System.out::println);
}
	public void updateProduct() {
		System.out.println("Give the id for the product to update");
        int productId=sc.nextInt();
        Product product=productdao.getProductById(productId);
        if(product!=null)
        {
        	System.out.println("Enter 1.To update product name\n2.To update product price\n3.To update product quantity");
        	
        	int choice=sc.nextInt();
        	switch(choice)
        	{
        	case 1:System.out.println("Enter the new product name to update");
        	       String productName=sc.next();
        	       product.setProductName(productName);
        	       productdao.updateProduct(product);
                   break;
        	case 2:System.out.println("Enter the new product price to update");
 	       		   double productPrice=sc.nextDouble();
 	       		   product.setProductPrice(productPrice);
 	       		   productdao.updateProduct(product);
 	       		   break;
        	case 3:System.out.println("Enter the new product quantity to update");
 	       	 	   int productQuantity=sc.nextInt();
 	       	 	   product.setProductQuantity(productQuantity);
 	       	 	   productdao.updateProduct(product);
 	       	 	   break;
        	case 4:System.out.println("Enter the new product name,product price and product quantity to update");
        		   String productName1=sc.next();
        		   product.setProductName(productName1);
        		   double productPrice1=sc.nextDouble();
 	       		   product.setProductPrice(productPrice1);
 	       		   int productQuantity1=sc.nextInt();
	       	 	   product.setProductQuantity(productQuantity1);
        		   productdao.updateProduct(product);
        		   break;
           default:System.err.println("Invalid input");
        	}
        }
        else
        {
        	System.err.println("product with id: "+productId+" not found!!");
        }
	}
	public void deleteProduct() {
		System.out.println("Enter id for the product you want to delete");
        int productId=sc.nextInt();
        Product product=productdao.getProductById(productId);
        if(product!=null)
        	productdao.deleteProduct(product);
        else
        	System.out.println("product with id: "+productId+" not found!!");
    }
}
