package com.springhibernatetest.service;

import com.springhibernatetest.beans.Customer;
import java.util.List;

public interface CustomerService {
	
	public Customer getById(int customerId);
	 
	public Customer getByName(String customerLastName, String customerFirstName);
	
	public List getCustomerList();
	 
	public void save(Customer customer);
	 
	public void delete(Customer customer);

}
