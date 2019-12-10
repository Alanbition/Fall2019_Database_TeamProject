package edu.northeastern.cs5200.daos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import edu.northeastern.cs5200.models.Application;
import edu.northeastern.cs5200.models.Job;
import edu.northeastern.cs5200.repositories.ApplicationRepository;
import edu.northeastern.cs5200.repositories.JobRepository;

@Controller("ApplicationDao")
public class ApplicationDao {
	@Autowired
	ApplicationRepository applicationRepository;
	@Autowired
	JobRepository jobRepository;

	public void deleteApplication() {
		applicationRepository.deleteAll();
	}

	public Application createApplication(Application application) {
		return applicationRepository.save(application);
	}

	public Application setJobForApplication(Job job, Application application) {
		application.setThisJobApplications(job);
    	jobRepository.save(job);
    	return applicationRepository.save(application);
    }
	
	public List<Job> findJobForApplication(List<Application> applications) {
		List<Job> jobs= new ArrayList<Job>();
		for (Application application:applications) {
			Job job = application.getThisJobApplications();
			jobs.add(job);
		}
    	return jobs;
    }

}
