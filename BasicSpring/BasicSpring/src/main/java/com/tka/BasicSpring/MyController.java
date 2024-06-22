package com.tka.BasicSpring;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {
	
	@RequestMapping("/getApi")
	public String getApi() {
		return"U are called GETApi";
	}
	
	@RequestMapping( value="/postApi",method=RequestMethod.POST)
	public String postApi() {
		return"U are called POSTAPI";
	}
	@RequestMapping(value="/putApi",method=RequestMethod.PUT)
	public String putApi() {
		return"U are called PUTAPI";
	}

	@RequestMapping(value="/deleteApi",method=RequestMethod.DELETE)
	public String deleteApi() {
		return"U are called DELETEAPI";
	}

	@GetMapping("/getMapping")
	public String getmapping() {
		return"U are in GetMapping";
	}
	
	@PostMapping("/postMapping")
	public String postMapping() {
		return"U are in PostMapping";
	}
	
	@PutMapping("/putMapping")
	public String putMapping() {
		return"U are in PUTMapping";
	}
	@DeleteMapping("/deleteMapping")
	public String deletemapping() {
		return"U are in DeleteMapping";
	}
}
