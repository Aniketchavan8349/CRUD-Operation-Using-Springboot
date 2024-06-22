package com.tka.DemoDatabase.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class person1 {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String fname;
	@Column(unique = true)
	String Email;
	String mobileno;
	
	
	
	public person1() {
		
	}
	
	
	public person1(int id, String fname, String email, String mobileno) {
		super();
		this.id = id;
		this.fname = fname;
		Email = email;
		this.mobileno = mobileno;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	@Override
	public String toString() {
		return "person1 [id=" + id + ", fname=" + fname + ", Email=" + Email + ", mobileno=" + mobileno + "]";
	}
	
	
	

}
