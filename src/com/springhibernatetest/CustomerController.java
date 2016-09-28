package com.springhibernatetest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.springhibernatetest.beans.Customer;
import com.springhibernatetest.beans.CustomerRecord;
import com.springhibernatetest.service.CustomerService;

//http://localhost:8080/SpringWeb/customerbyid?id=1
//http://localhost:8080/SpringWeb/showCustomers

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
		System.out.println(">>>>>>>>>>>>>>>>>>>> CustomerController,  getCustomer(), CustomerLastname = " + cust.getLastName());
		
		Set custRecs = cust.getRecords();
		java.util.Iterator iter = custRecs.iterator();
		while (iter.hasNext()){
			CustomerRecord custrec = (CustomerRecord)iter.next();
			System.out.println(">>> " + custrec.getRecId());
			System.out.println(">>> " + custrec.getRecType());
			System.out.println(">>> " + custrec.getRecDesc());
		}
		
		return cust;
	}
	
	//added following jar files to lib to transform result to JSON or add as dependency to pom.xml
	//jackson-annotations-2.5.0
	//jackson-core-2.5.0
	//jackson-databind-2.5.0
	//http://wiki.fasterxml.com/JacksonHome
	//ResponseEntity infinite recursion issue @JsonIgnore at OnetoMany on Entity object resolved
	@RequestMapping(value="/customer/{id}", method = RequestMethod.GET )
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Integer id) {
		Customer cust = customerService.getById(id);
		return new ResponseEntity<Customer>(cust, HttpStatus.OK);
	}	
	
	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public String addCustomer(@ModelAttribute("customer")Customer customer, ModelMap model) {
	//public String addCustomer(@ModelAttribute Customer customer, ModelMap model) {
		System.out.println(">>>>>>>>>>>>>>>>>>>> CustomerController, addCustomer(), "
				+ "	name: " + customer.getFirstName() + " " + customer.getLastName());
		
		//set id column in db as auto-increment
		//dao actually does a merge
		customerService.save(customer);

		//values for the result page.
		model.addAttribute("firstName", customer.getFirstName());
		model.addAttribute("lastName", customer.getLastName());
		model.addAttribute("phone", customer.getPhone());
		
		//loads the addcustomerresult.jsp page
		//return "addcustomerresult";
		return "redirect:/showCustomers";
	}
	
	@RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
	public String updateCustomer(@ModelAttribute("customer")Customer customer, ModelMap model) {
		System.out.println(">>>>>>>>>>>>>>>>>>>> CustomerController, updateCustomer()");
		
		customerService.update(customer);

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
	
	//http://wiki.fasterxml.com/JacksonHome
	//ResponseEntity infinite recursion issue @JsonIgnore at OnetoMany on Entity object resolved
	//@RequestMapping(value= "/customer", method = RequestMethod.GET)
	@RequestMapping(value= "/customers", method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> getAllCustomerss() {
		List<Customer> list = customerService.getCustomerList();
		return new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
	}	

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id){
        customerService.delete(id);
        return "redirect:/showCustomers";
    }
	
	@RequestMapping(value = "/deleteCustomer", method = RequestMethod.GET)
	public String deleteCustomer(@RequestParam(value="id", required=true) int customerId) {
		//get the customer first using ID
		Customer cust = (Customer)customerService.getById(customerId);
		System.out.println(">>>>>>>>>>>>>>>>>>>> CustomerController,  deleteCustomer(), CustomerId = " + cust.getCustomerId());
		System.out.println(">>>>>>>>>>>>>>>>>>>> CustomerController,  deleteCustomer(), CustomerLastname = " + cust.getLastName());
		
		Set custRecs = cust.getRecords();
		java.util.Iterator iter = custRecs.iterator();
		while (iter.hasNext()){
			CustomerRecord custrec = (CustomerRecord)iter.next();
			System.out.println(">>> " + custrec.getRecId());
			System.out.println(">>> " + custrec.getRecType());
			System.out.println(">>> " + custrec.getRecDesc());
		}
		
		//delete the customer with the id
		//could return Customer with details for success message, or just redirct to listing.
		customerService.delete(cust);
        return "redirect:/showCustomers";
	}
	
}