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

//http://localhost:8080/HelloSpringWeb/product

@Controller
public class ProductController {
	
	//@Autowired annotation tells Spring where an injection needs to occur
	//@Autowired annotation spares you the need to do the wiring 
	//in the XML file and just finds what needs to be injected and does that for you
	//Good practice: would be to use @Inject instead of @Autowired because it is not Spring-specific
	//Good practice: put the @Inject / @Autowired on a constructor instead of a method
	//               to validate injected bean is not null quickly
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public ModelAndView customer() {
		System.out.println(">>>>>>>> In productController");
		return new ModelAndView("customer", "command", new Customer());
	}
	
}