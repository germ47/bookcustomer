package com.example.demo.controller;

import org.springframework.stereotype.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@Slf4j
public class IndexController {
	
	@GetMapping("/")
	public String index() {
		//log.info("index메서드 call");
		return "index";
	}
	

}