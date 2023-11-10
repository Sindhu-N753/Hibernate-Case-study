package com.jsp.hibernate_case_study_1;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jsp.hibernate_case_study_1.service.ProductService;

public class AppProduct 
{
    public static void main( String[] args )
    {
    	ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
        ProductService pservice = context.getBean(ProductService.class);
        pservice.deleteProduct();
    	
//        Scanner sc=new Scanner(System.in);
//        ProductService productservice=new ProductService();
//        System.out.println("Enter your choice\n"+"1 to add product\n"+"2 to get product by id\n"+"3 to get all products\n"+"4 to update product\n"+"5 to delete product");
//        int choice=sc.nextInt();
//        
//        switch(choice)
//        {
//        case 1:productservice.addProduct();
// 	   	       break;
//        case 2:productservice.getProductById();
// 	           break;
//        case 3:productservice.getAllProducts();
// 	           break;
//        case 4:productservice.updateProduct();
//               break;
//        case 5:productservice.deleteProduct();
//               break;
//        default:System.err.println("Invalid choice");
        } 
    }
