package edu.northeastern.cs5200.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.cs5200.daos.*;
import edu.northeastern.cs5200.models.*;
import edu.northeastern.cs5200.repositories.*;

@RestController
@RequestMapping("api/job")
public class JobController {
	@Autowired
	JobRepository jobRepository;
	  
	@GetMapping("/select/all")
	public List<Jobs> getAlljob (){
		return jobRepository.findAll();
	}
	
}
