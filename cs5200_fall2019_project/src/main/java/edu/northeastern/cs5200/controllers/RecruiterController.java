package edu.northeastern.cs5200.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.cs5200.daos.RecruiterDao;
import edu.northeastern.cs5200.models.Recruiter;
import edu.northeastern.cs5200.repositories.RecruiterRepository;

@RestController
public class RecruiterController {
	@Autowired
	RecruiterDao recruiterDao;
	RecruiterRepository recruiterRepository;
	
	@GetMapping("api/recruiter")
	public Iterable<Recruiter> findAllRecruiter() {
		Iterable<Recruiter> recruiters = recruiterRepository.findAll();
		return recruiters;
	}
	
	@DeleteMapping("/api/recruiter")
    public void deleteAllRecruiter() {
		recruiterDao.deleteRecruiter();
    }
	
	@PutMapping("/api/recruiter/{eid}")
	public Recruiter updateRecruiter(@PathVariable("rid") int id, @RequestBody Recruiter r) {
		Recruiter recruiter = recruiterDao.updateRecruiter(id, r);
		return recruiter;
    }
	
	@PostMapping("/api/recruiter")
    public Recruiter createRecruiter(@RequestBody Recruiter recruiter) {
        return recruiterDao.createRecruiter(recruiter);
    }

}
