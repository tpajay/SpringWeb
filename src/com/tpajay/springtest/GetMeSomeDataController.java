package com.tpajay.springtest;

//import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import com.tutorialspoint.beans.Customer;
import org.springframework.ui.ModelMap;

@Controller
@RequestMapping("/getmesomedata")
//@RequestMapping("/") //use root url instead of prefix view
public class GetMeSomeDataController{
 
   @RequestMapping(method = RequestMethod.GET)
   public String printHello(ModelMap model) {
      model.addAttribute("message", "Hello Spring MVC Framework!  Just used GetMeSomeDataController");
      model.addAttribute("something","This is something from the REQUEST");
      
      return "getmesomedata";
   }

}

