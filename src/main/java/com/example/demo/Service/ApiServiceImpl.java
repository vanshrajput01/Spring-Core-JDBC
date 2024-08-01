package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ApiRepository.ApiRespositoryCls;

@Service
public class ApiServiceImpl implements ApiService{
	
	@Autowired
	private ApiRespositoryCls apiRepo;

	@Override
	public String createTable() {
		
		return this.apiRepo.createTbl();
	}

}
