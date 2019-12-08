package edu.northeastern.cs5200.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.cs5200.daos.RecruiterDao;
import edu.northeastern.cs5200.models.Application;
import edu.northeastern.cs5200.models.Employee;
import edu.northeastern.cs5200.models.Job;
import edu.northeastern.cs5200.models.JobInterest;
import edu.northeastern.cs5200.models.Recruiter;
import edu.northeastern.cs5200.models.Student;
import edu.northeastern.cs5200.repositories.JobInterestRepository;
import edu.northeastern.cs5200.repositories.JobRepository;
import edu.northeastern.cs5200.repositories.RecruiterRepository;

@RestController
public class RecruiterController {
	@Autowired
	RecruiterDao recruiterDao;
	RecruiterRepository recruiterRepository;
	JobRepository jobrepository;
	JobInterestRepository jobInterestrepository;
	
	@GetMapping("/api/recruiter")
	public Iterable<Recruiter> findAllRecruiter() {
		Iterable<Recruiter> recruiters = recruiterDao.findAllRecruiter();
		return recruiters;
	}
	
	@DeleteMapping("/api/recruiter")
    public void deleteAllRecruiter() {
		recruiterDao.deleteRecruiter();
    }
	
	@PutMapping("/api/recruiter/{rid}")
	public Recruiter updateRecruiter(@PathVariable("rid") int id, @RequestBody Recruiter r) {
		Recruiter recruiter = recruiterDao.updateRecruiter(id, r);
		return recruiter;
    }
	
	@PostMapping("/api/recruiter")
    public Recruiter createRecruiter(@RequestBody Recruiter recruiter) {
        return recruiterDao.createRecruiter(recruiter);
    }
	
	@PostMapping("/api/recruiter/{rid}/job/{jid}")
    public Recruiter addJobToRecruiter(@PathVariable("rid") int rid,@PathVariable("jid") int jid) {
		Job job = jobrepository.findById(jid).get();
		Recruiter recruiter = recruiterRepository.findById(rid).get();
        return recruiterDao.addJobToRecruiter(job,recruiter);
    }
	
	@DeleteMapping("/api/recruiter/{rid}/job/{jid}")
    public void deleteJobFromRecruiter(@PathVariable("rid") int rid,@PathVariable("jid") int jid) {
		Job job = jobrepository.findById(jid).get();
		Recruiter recruiter = recruiterRepository.findById(rid).get();
		recruiterDao.removeJobfromRecruiter(job, recruiter);
    }
	

	@GetMapping("/api/recruiter/{rid}/job/application")
	public List<Application> FindApplicationsByJobsPostedByRecruiters(@PathVariable("rid") int rid) {
		Recruiter recruiter = recruiterRepository.findById(rid).get();
		List<Job> jobs = recruiter.getJobsCreatedByRecruiter();
		List<Application> applications = new ArrayList<Application>();
		for(Job job:jobs) {
			applications.addAll(job.getApplicationsForThisJob());
		}
		return applications;
	}
	
	@GetMapping("/api/recruiter/{rid}/job/{jid}/application")
	public List<Application> FindApplicationsByJobsPostedByRecruiters(@PathVariable("rid") int rid,@PathVariable("jid") int jid) {
		Job job = jobrepository.findById(jid).get();
		List<Application> applications =job.getApplicationsForThisJob();
		return applications;
	}
	


}
