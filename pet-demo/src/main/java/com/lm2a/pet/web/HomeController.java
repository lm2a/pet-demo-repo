package com.lm2a.pet.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lm2a.pet.model.Pet;

import lombok.extern.slf4j.Slf4j;



@Controller
@RequestMapping("/")
public class HomeController {
	
	
	@GetMapping
	public String home() {
		return "home";
	}
	
	


}
