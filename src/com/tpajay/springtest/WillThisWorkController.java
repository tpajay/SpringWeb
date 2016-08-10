package com.tpajay.springtest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;

@Controller
@RequestMapping("/wtw")
//@RequestMapping("/") //use root url instead of prefix view
public class WillThisWorkController{
 
   @RequestMapping(method = RequestMethod.GET)
   public String printHello(ModelMap model) {
      model.addAttribute("message", "In WillThisWorkController using /wtw");

      return "hello";
   }

}
