package com.jsp.hibernate_case_study_1;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jsp.hibernate_case_study_1.service.CartService;

public class AppCart {
	public static void main( String[] args )
    {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
        CartService cservice = context.getBean(CartService.class);
        cservice.addProductToCart();
        
//        Scanner sc=new Scanner(System.in);
//        CartService cartservice=new CartService();
//        System.out.println("Enter your choice\n"+"1 to create cart\n"+"2 to add product to cart\n"+"3 to remove product from cart");
//        int choice=sc.nextInt();
//        
//        switch(choice)
//        {
//        case 1:cartservice.createCart();
//        	   break;
//        case 2:cartservice.addProductToCart();
//        	   break;
//        case 3:cartservice.removeProductFromCart();
//        	   break;
//        default:System.err.println("Invalid choice");
        } 
    }
