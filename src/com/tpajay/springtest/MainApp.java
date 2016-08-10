package com.tpajay.springtest;

//import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springhibernatetest.beans.Customer;

import java.util.*;

public class MainApp {
   public static void main(String[] args) {
	   
    //ApplicationContext context = 
    @SuppressWarnings("resource")
	ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
      
      // start event.
      context.start();
      
      HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
      obj.getMessage();
      
      HelloWorld2 obj2 = (HelloWorld2) context.getBean("helloWorld2");
      obj2.getMessage();

      //Using Spring JDBCTemplate
      //Use Hibernate instead for more support/larger projects/ORM
      CustomerJDBCTemplate customerJDBCTemplate = (CustomerJDBCTemplate)context.getBean("customerJDBCTemplate");
    
      System.out.println("------Records Creation--------" );
      customerJDBCTemplate.create(11, "Bob", "Smith");
      customerJDBCTemplate.create(12, "John", "Johnson");
      customerJDBCTemplate.create(13, "David", "Brown");

      System.out.println("------Listing Multiple Records--------" );
      List<Customer> customers = customerJDBCTemplate.listCustomers();
      for (Customer record : customers) {
    	  System.out.print("ID : " + record.getCustomerId() );
    	  System.out.print(", First Name : " + record.getFirstName() );
    	  System.out.println(", Last Name : " + record.getLastName());
      }
      
      System.out.println("----Updating Record with ID = 00001 -----" );
      customerJDBCTemplate.update(00001, "8137778888");
      System.out.println("----Listing Record with ID = 00001 -----" );
      Customer customer = customerJDBCTemplate.getCustomer(00001);
      System.out.print("ID : " + customer.getCustomerId() );
      System.out.print(", First Name : " + customer.getFirstName() );
      System.out.println(", Last Name : " + customer.getLastName());
      
      customerJDBCTemplate.delete(11);
      customerJDBCTemplate.delete(12);
      customerJDBCTemplate.delete(13);
      customerJDBCTemplate.delete(null);
          
      
      // stop event.
      context.stop();
      
   }
}
