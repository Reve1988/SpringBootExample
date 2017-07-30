package org.geniurd.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/simple")
public class SimpleViewController {
	@RequestMapping("/hello")
	@ResponseBody
	public String showHello() {
		return "Hello!!";
	}

	@RequestMapping("/private")
	@ResponseBody
	public String showPrivate() {
		return "This is private page!!";
	}
}
