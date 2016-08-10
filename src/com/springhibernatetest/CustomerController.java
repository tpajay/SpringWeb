package com.springhibernatetest;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;
import org.springframework.beans.factory.annotation.Autowired;
import com.springhibernatetest.beans.Customer;
import com.springhibernatetest.service.CustomerService;

//http://localhost:8080/HelloSpringWeb/customerbyid?id=1

@Controller
public class CustomerController {
	
	//@Autowired annotation tells Spring where an injection needs to occur
	//@Autowired annotation spares you the need to do the wiring 
	//in the XML file and just finds what needs to be injected and does that for you
	//Good practice: would be to use @Inject instead of @Autowired because it is not Spring-specific
	//Good practice: put the @Inject / @Autowired on a constructor instead of a method
	//               to validate injected bean is not null quickly
	
	//injecting Service Class Interface that uses the DAO
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public ModelAndView customer() {
		return new ModelAndView("customer", "command", new Customer());
	}
	
	@RequestMapping(value = "/customerbyid", method = RequestMethod.GET)
	//@ModelAttribute("customer")
	//public Customer getCustomer() would be proper, but in Controller
	//doesn't seem to matter the method name, only using due to /customerbyid being
	//called on http url.
	public Customer getAnything(@RequestParam(value="id", required=true) int customerId) {
		Customer cust = (Customer)customerService.getById(customerId);
		System.out.println(">>>>>>>>>>>>>>>>>>>> CustomerController,  getCustomer(), CustomerId = " + cust.getCustomerId());
		return cust;
	}
	
	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public String addCustomer(@ModelAttribute("SpringWeb")Customer customer, ModelMap model) {
		System.out.println(">>>>>>>>>>>>>>>>>>>> CustomerController, addCustomer()");
		//set id column in db as auto-increment
		customerService.save(customer);

		//values for the result page.
		model.addAttribute("firstName", customer.getFirstName());
		model.addAttribute("lastName", customer.getLastName());
		model.addAttribute("phone", customer.getPhone());
		
		//loads the addcustomerresult.jsp page
		return "addcustomerresult";
	}
	
	//http://www.beingjavaguys.com/2014/05/spring4-hibernate4-integration.html
	@RequestMapping(value = "/showCustomers", method = RequestMethod.GET)
	public ModelAndView getCustomerList() {
		List customerList = customerService.getCustomerList();
		return new ModelAndView("customerlist", "customerList", customerList);
	}
	
	
}