package com.cjc.curd.webapp.main.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cjc.curd.webapp.main.model.Product;


@Repository
public interface HomeRepository extends CrudRepository<Product, Integer>{
	public Product findAllByPidAndName(Integer pid, String name);
}
