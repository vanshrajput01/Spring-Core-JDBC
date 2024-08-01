package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.ApiService;

@RestController
public class ApiController {
	
	@Autowired
	private ApiService apiService;
	
	@GetMapping(value = "/createTable")
	public String addData() {
		return this.apiService.createTable();
		
	}

}
