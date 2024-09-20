package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsrHomeController {
	
	
	@GetMapping("/usr/home/count")
	@ResponseBody
	public int ShowMain() {
		
		return 10;
		
	}
	
	@GetMapping("/usr/home/count2")
	@ResponseBody
	public String ShowMain2() {
		return "안녕하세요";
	}
}
