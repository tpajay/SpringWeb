package com.springhibernatetest;

import java.util.HashSet;
import java.util.HashSet;
import java.util.Set;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction; 
import com.springhibernatetest.beans.Customer;
import com.springhibernatetest.beans.CustomerRecord;
 
public class MainTest {
 
/*
    public static void main(String a[])
    {
        SessionFactory sessionFactory = HibernateUtil.getInstnce();
        Session session = sessionFactory.openSession();    
         
        Vendor vendor=new Vendor();
        vendor.setVendorId(101);
        vendor.setVendorName("IBM");
         
        Customer customer=new Customer();
        customer.setCustomerId(102);
        customer.setCustomerName("NIFY");
        customer.setCustomerAddress("BANG");
         
        Customer customer2=new Customer();
        customer2.setCustomerId(104);
        customer2.setCustomerName("TCS");
        customer2.setCustomerAddress("HYD");
         
        Customer customer3=new Customer();
        customer3.setCustomerId(105);
        customer3.setCustomerName("VERIZON");
        customer3.setCustomerAddress("US");
         
         
        Set customers = new HashSet();
        customers.add(customer);
        customers.add(customer2);
        customers.add(customer3);
         
        vendor.setCustomers(customers);
         
        Transaction transaction=session.beginTransaction();
         
        session.save(vendor);
         
        transaction.commit();
         
        session.close();
        sessionFactory.close();
    }
*/
}
