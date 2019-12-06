package edu.northeastern.cs5200.daos;


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

	public Application setApplicationForJob(Job job, Application application) {
		application.setThisJobsApplications(job);
    	jobRepository.save(job);
    	return applicationRepository.save(application);
    }

}
