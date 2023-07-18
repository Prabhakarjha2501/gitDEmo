package com.cjc.curd.webapp.main.service;

import com.cjc.curd.webapp.main.model.Product;

public interface HomeService {

	public void saveData(Product e);

	public Product getsingledata(int pid,String name);

	public Iterable<Product> getAllData();
	
	public void deleteData(int pid);

}
