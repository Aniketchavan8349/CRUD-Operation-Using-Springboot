package com.tka.BasicSpring;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entity.Employee;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	
	@PostMapping("/saveEmp")
	public String saveRecord(@RequestBody Employee emp) {
		System.out.println(emp);
		return"record is received..."+emp;
		
	}
	
	@PutMapping("/updateEmp/{kuchbhi}")
	public String updateRecord(@PathVariable("kuchbhi")int id,@RequestBody Employee emp) {
		System.out.println("Id is "+id+" Employee data "+emp);
		return"Record is Updated...";
	}
	
	@DeleteMapping("/deleteEmp/{id}")
	public String deleteRecord(@PathVariable int id) {
		System.out.println("id is"+id);
		return" record is deleted...";
	}
	
	@PutMapping("/putEmp1")
	public String updateRecord1(@RequestParam("id") int id,@RequestBody Employee emp) {
		System.out.println("Id is "+id+" Employee data "+emp);
		return"record is Updated....";
	}
	
}
