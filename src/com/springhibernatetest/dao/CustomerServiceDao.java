package com.springhibernatetest.dao;

import java.util.List;
import com.springhibernatetest.beans.Customer;
 
 
public interface CustomerServiceDao {
 
public Customer getById(int customerId);
 
public Customer getByName(String customerLastName, String customerFirstName);

public List getCustomerList();
 
public void save(Customer customer);

public void update(Customer customer);
 
public void delete(Customer customer);

public void delete(int id);
 
}