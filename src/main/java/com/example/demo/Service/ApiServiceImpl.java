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

	@Override
	public String AddData(int id, String name, String city) {
		return this.apiRepo.AddDataInfo(id,name,city);
	}

	@Override
	public String UpdateData(int id, String name, String city) {
		
		return this.apiRepo.updateDataInfo(id,name,city);
	}

		@Override
	public String insertData(GetInputCls input) {
		return this.apirepo.insertData(input);
	}

}
