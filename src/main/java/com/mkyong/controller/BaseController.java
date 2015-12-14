package com.mkyong.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BaseController {

	private static int counter = 0;
	private static final String VIEW_INDEX = "index";
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	private static ICalculator calculator;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {

		model.addAttribute("message", "Welcome");
		model.addAttribute("counter", ++counter);
		logger.debug("[welcome] counter : {}", counter);

		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_INDEX;

		
	}

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) {

		//calculator hinzugefügt damit die JUnit Tests einen Sinn ergeben
		calculator = new Calculator();
		int par1 = Integer.parseInt(name);
		int par2 = 1;
		int result = calculator.sum(par1, par2);
		String returnstring = Integer.toString(result);
		
		model.addAttribute("message", "Welcome " + returnstring);
		model.addAttribute("counter", returnstring);
		logger.debug("[welcomeName] counter : {}", returnstring);
		return VIEW_INDEX;

	}

}