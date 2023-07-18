package com.cjc.curd.webapp.main.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.curd.webapp.main.model.Product;
import com.cjc.curd.webapp.main.repo.HomeRepository;
import com.cjc.curd.webapp.main.service.HomeService;


@Service
public class HomeServiceImpl implements HomeService {
	@Autowired
	HomeRepository hr;
	@Override
	public void saveData(Product e) {
		hr.save(e);	
	}
	
	@Override
	public Product getsingledata(int pid, String name) {
		return hr.findAllByPidAndName(pid, name);
		
	}
	
	@Override
	public Iterable<Product> getAllData() {
		Iterable<Product> list = hr.findAll();
		return list;
	}
	
	@Override
	public void deleteData(int pid) {
		hr.deleteById(pid);
	}

}
