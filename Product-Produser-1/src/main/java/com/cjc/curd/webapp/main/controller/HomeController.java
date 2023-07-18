package com.cjc.curd.webapp.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cjc.curd.webapp.main.model.Product;
import com.cjc.curd.webapp.main.service.HomeService;
@CrossOrigin("*")
@RestController
public class HomeController {
	@Autowired
	HomeService hs;
	@PostMapping("/saveData")
	public ResponseEntity<String> saveData(@RequestBody Product e) {
		hs.saveData(e);
		return new ResponseEntity<String>("Data saved",HttpStatus.CREATED);	
	}
	
	@GetMapping("/getsingledata/{pid}/{name}")
	public ResponseEntity<Product> getsingleData(@PathVariable int pid,@PathVariable String name){
		Product pr = hs.getsingledata(pid, name);
		if(pr !=null) {
			return new ResponseEntity<Product>(pr,HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
		}
	} 
	
	@GetMapping("/getalldata")
	public Iterable<Product>getALlData(){
		Iterable<Product>list = hs.getAllData();
		return list;
		
	}

	@PutMapping("/update/{pid}")
	public String updatealldata(@PathVariable int pid,@RequestBody Product e) {
		hs.saveData(e);
		return "update put";
	}
	@PatchMapping("/updatedata/{pid}")
	public String updatedata(@PathVariable("pid")int pid,@RequestBody Product e) {
		hs.saveData(e);
		return "update patch"; 
	}
	@DeleteMapping("/delete/{pid}")
	public String deletedata(@PathVariable("pid")int pid) {
		hs.deleteData(pid);
		return "delete";
	}
	
}
