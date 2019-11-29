package edu.northeastern.cs5200.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import edu.northeastern.cs5200.repositories.ApplicationRepository;

@Controller("ApplicationDao")
@Service
public class ApplicationDao {
	@Autowired
	ApplicationRepository applicationRepository;

	public void deleteApplication() {
		ApplicationRespository.deleteAll();
		
	}
	public void createApplication() {
		return ApplicationRepository.save(application);
	}

	public Application setRecruiterForApplication(Recruiter recruiter, Application application) {
		application.setRecruiter(recruiter);
    	ApplicationRespository.save(application);
    	
    	return application;
    }

    public Recruiter getApplicationRecruiter(Application application) {
		
		return recruiter.getApplication();
	}





	public Application setApplicationForJob(Application application, Job job) {
		application.setJob(job);
    	ApplicationRespository.save(application);
    	
    	return application;
    }

    public Job getApplicaitonJob(Application application){
    	return application.getJob();
    }

    public Application 

}
