package com.example.ProjectDemo.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProjectDemo.dao.MainDao;
import com.example.ProjectDemo.entity.Country;
import com.example.ProjectDemo.entity.Employee2;

@Service
public class MainService {
	
	@Autowired
	MainDao dao;
	



	public String addCountry(Country c) {
		String msg=dao.addCountry(c);
		if(Objects.isNull(msg)) {
			msg="Data is not Added...";
		}
		return msg;

}
	public String updateData(Country c) {
		String msg=dao.updateData(c);
		if(Objects.isNull(msg)) {
			msg="Data is not updated...";
		}
		return msg;

}
	public String deleteCountry(Country c) {
		String msg= dao.deleteCountry(c);
		if(Objects.isNull(msg)) {
			msg="Country not deleted...";
		}
		return msg;

}
	public Country getPerticularRecord(Country c) {
		Country msg=dao.getPerticularRecord(c);
		
		return msg;
	
}
	
	public List<Country> getAllRecords(){
		 List<Country> list= dao.getAllRecords();
		 return list;
	}
	
	//Employee Class
	
	public String addEmployee(Employee2 e) {
		String msg=dao.addEmployee(e);
		if(Objects.isNull(msg)) {
			msg="Data is not Added...";
		}
		return msg;
}
	
	public String updateEmployee(Employee2 e) {
		String msg=dao.updateEmployee(e);
		if(Objects.isNull(msg)) {
			msg="Data is not updated...";
		}
		return msg;

}
	

	
	public String deleteEmployee(Employee2 e) {
		String msg= dao.deleteEmployee(e);
		if(Objects.isNull(msg)) {
			msg="Country not deleted...";
		}
		return msg;

}
	
	public Employee2 getPerticularEmployee(Employee2 e) {
		Employee2 msg= dao.getPerticularEmployee(e);
		return msg;
		
	}
	
	public List<Employee2> getAllEmployee(){
		List<Employee2> msg=dao.getAllEmployee();
		return msg;
	}
	
	public List<Employee2> getStatus(Employee2 e) {
		List<Employee2> s=dao.getStatus(e);
		return s;
	}
	public HashMap checkUser(Employee2 e) {
		
		Employee2 emp=dao.checkUser(e);
		HashMap map=new HashMap();
		if(Objects.isNull(e)) {
			map.put("msg","Invalid user");
			map.put("User",e);
			
		}else
		{
			map.put("msg","Valid user");
			map.put("User",e);
		}
		return map;
	}
	
	public List<Employee2> fromDate(Employee2 e){
		
		List<Employee2> msg=dao.fromDate(e);
		return msg;
	}
}
