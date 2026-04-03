package com.gguek.app.home;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class HomeController {
	


	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home() throws Exception {

	
		
		
		
		
//		System.out.println("home controller");
		return "index";
	}

	
	
	
	
	
}
