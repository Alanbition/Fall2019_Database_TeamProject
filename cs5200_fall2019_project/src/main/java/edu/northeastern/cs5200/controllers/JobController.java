package edu.northeastern.cs5200.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.cs5200.repositories.*;

@RestController
@RequestMapping("api/job")
public class JobController {
	@Autowired
	JobRepository jobRepository;
	
//	@RequestMapping("/api/hello/string")
//	public String sayHello() {
//		return "Hello Ruoyun Chen!";
//	}
//	@RequestMapping("/api/hello/object")
//	public HelloObject sayHelloObject() {
//		HelloObject obj = new HelloObject("Hello Ruoyun Chen!");
//		return obj;
//	}
//	@RequestMapping("/api/hello/insert")
//	public HelloObject insertHelloObject() {
//		HelloObject obj = new HelloObject("Hello Ruoyun Chen!!");
//		helloRepository.save(obj);
//		return obj;
//	}
//	@RequestMapping("/api/hello/insert/{msg}")
//	public HelloObject insertMessage(@PathVariable("msg") String message) {
//		HelloObject obj = new HelloObject(message);
//		helloRepository.save(obj);
//		return obj;
//	}
//	@RequestMapping("/api/hello/select/all")
//	public List<HelloObject> selectAllHelloObjects() {
//		List<HelloObject> hellos =
//			(List<HelloObject>)helloRepository.findAll();
//		return hellos;
	}
}
