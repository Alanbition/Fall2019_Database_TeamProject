package edu.northeastern.cs5200.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import edu.northeastern.cs5200.models.Application;
import edu.northeastern.cs5200.models.Job;
import edu.northeastern.cs5200.models.Recruiter;
import edu.northeastern.cs5200.repositories.ApplicationRepository;
import edu.northeastern.cs5200.repositories.JobRepository;
import edu.northeastern.cs5200.repositories.RecruiterRepository;

@Controller("JobDao")
@Service

public class JobDao {
	@Autowired
	JobRepository jobRepository;
	@Autowired
	RecruiterRepository recruiterRepository;
	@Autowired
	ApplicationRepository applicationRepository; 
	
	public void deleteJob() {
		jobRepository.deleteAll();
	}

	public Job createJob(Job job) {
		return jobRepository.save(job);
	}

	public Job setRecruiterForJob(Recruiter recruiter, Job job) {
		job.setThisRecruiterJobs(recruiter);
		recruiterRepository.save(recruiter);
    	return jobRepository.save(job);
    }

    public Job addApplicationToJob(Application application, Job job){
    	job.applicationsForThisJob(application);
    	applicationRepository.save(application);
    	return jobRepository.save(job);
    }




}
