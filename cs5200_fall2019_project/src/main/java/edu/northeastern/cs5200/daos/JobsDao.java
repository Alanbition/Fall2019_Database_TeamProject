package edu.northeastern.cs5200.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import edu.northeastern.cs5200.models.Job;
import edu.northeastern.cs5200.models.Recruiter;
import edu.northeastern.cs5200.repositories.JobRespository;

@Controller("JobsDao")
@Service

public class JobsDao {
	@Autowired
	
	JobRespository jobRespository;
	
	public void deleteJob() {
		jobRespository.deleteAll();
		
	}
	public void createJob() {
		return jobRespository.save(job);
	}

	public Job setRecruiterForJob(Recruiter recruiter, Job job) {
		job.setRecruiter(recruiter);
		jobRespository.save(job);
    	
    	return job;
    }

    public Recruiter getJobRecruiter(Job job) {
		
		return job.getRecruiter();
	}


   public Job setApplicationrForJob(Application application, Job job) {
		job.setApplication(application);
    	JobRespository.save(job);
    	
    	return job;
    }

    public Application getJobApplication(Job job) {
		
		return job.getApplication();
	}

	

}
