package com.springhibernatetest.service;

import com.springhibernatetest.beans.Customer;
import com.springhibernatetest.dao.CustomerServiceDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

	//@Autowired annotation tells Spring where an injection needs to occur
	//@Autowired annotation spares you the need to do the wiring 
	//in the XML file and just finds what needs to be injected and does that for you
	//Good practice: would be to use @Inject instead of @Autowired because it is not Spring-specific
	//Good practice: put the @Inject / @Autowired on a constructor instead of a method
	//               to validate injected bean is not null quickly 
	
	//injecting DAO interface
	@Autowired
	private CustomerServiceDao customerDao;
	 
	//public Collection<Country> getAllCountries() {
	//return countryDao.getAll();
	//}
	 
	//public Customer getCustomerById(int customerId) {
	//	return customerDao.getById(customerId);
	//}
	public Customer getById(int customerId) {
		return customerDao.getById(customerId);
	}	
	 
	//public Customer getCustomerByName(String customerLastName, String customerFirstName) {
	//	return customerDao.getByName(customerLastName, customerFirstName);
	//}
	public Customer getByName(String customerLastName, String customerFirstName) {
		return customerDao.getByName(customerLastName, customerFirstName);
	}
	
	public List getCustomerList() {
		return customerDao.getCustomerList();
	}	
	 
	public void saveCustomer(Customer customer) {
		customerDao.save(customer);
	}
	public void save(Customer customer) {
		customerDao.save(customer);
	}	
	 
	//public void deleteCustomer(Customer customer) {
	//	customerDao.delete(customer);
	//}	
	public void delete(Customer customer) {
		customerDao.delete(customer);
	}	
 
}
