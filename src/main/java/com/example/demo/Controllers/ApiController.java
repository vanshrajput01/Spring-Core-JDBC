package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.ApiService;

@RestController
public class ApiController {
	
	@Autowired
	private ApiService apiService;
	
	@GetMapping(value = "/createTable")
	public String CreateTable() {
		return this.apiService.createTable();
		
	}
	
	@GetMapping("/addData")
	public String AddData(@RequestParam(name = "id") int id,
						  @RequestParam(name = "name") String name,
						  @RequestParam(name = "city_name") String city) {
		
		
		return this.apiService.AddData(id,name,city);
		
	}
	
	@GetMapping("/UpdateData")
	public String UpdateData(@RequestParam(name = "id") int id,
							 @RequestParam(name = "name") String name,
							 @RequestParam(name = "city_name") String city) {
		
		return this.apiService.UpdateData(id,name,city);
	}
###########################################################  how to save data using Procedure   ###########################################################

	
	@PostMapping("/insert-data")
	public String insertData(@RequestBody GetInputCls input) {
		return this.service.insertData(input);
	}

	
	
	

}
