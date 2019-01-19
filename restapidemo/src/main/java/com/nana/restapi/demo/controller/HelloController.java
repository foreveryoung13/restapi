package com.nana.restapi.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author nana
 * 
 */

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public ModelAndView hello() {
		ModelAndView m = new ModelAndView("HelloPage");
		m.addObject("msg", "Hello World !");
		return m;
	}

}
