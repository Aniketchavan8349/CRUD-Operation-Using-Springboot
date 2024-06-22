package com.tka.DemoDatabase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.DemoDatabase.dao.Person1Dao;
import com.tka.DemoDatabase.entity.person1;

@Service
public class Person1Service {
	
	
	@Autowired
	Person1Dao dao;
	
	public String InsertData(person1 p) {
		String msg=dao.insertData(p);
		return msg;
	}
	public String UpdateData(int id,person1 p) {
		String s=dao.updateData(id, p);
		return s;
	}
	
	public String DeleteData(int id) {
		String s=dao.deleteData(id);
		return s;
	}
	
	public person1 getPerticularRecord(int id) {
		
	person1 p=	dao.getPerticularRecord(id);
		return p;
	}
	
	public List<person1> getAllRecord() {
		
		List<person1> list=	dao.getAllRecord();
			return list;
		}
	
	
	
	

}