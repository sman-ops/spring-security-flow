package com.spring.restaurant.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/about")
public class AboutController {
	
	@GetMapping("/start")
	public String start() {
		return "this show about controller" ;
	}

}
