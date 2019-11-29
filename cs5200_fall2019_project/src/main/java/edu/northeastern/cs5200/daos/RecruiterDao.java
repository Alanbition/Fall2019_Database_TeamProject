package edu.northeastern.cs5200.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import edu.northeastern.cs5200.repositories.RecruiterRespository;

@Controller("RecruiterDao")
@Service
public class RecruiterDao {
	@Autowired
	RecruiterRespository recruiterRepository;
	
	public void deleteRecruiter(){
		recruiterRepository.deleteAll();
	}
	public void createRecruiter(){
		return recruiterRepository.save(recruiter);
	}

	public Recruiter setJobForRecruiter(Recruiter recruiter, Job job) {
		recruiter.setjob(job);
		recruiterRepository.save(recruiter);
    	return recruiter;
    }

    public Job getRecruitercreatedJob (Recruiter recruiter){
    	return recruiter.getJob();
    }

    public Recruiter setApplicationForRecruiter(Recruiter recruiter, Application application){
    	recruiter.setapplication(application);
    	recruiterRepository.save(recruiter);
    	return recruiter;
    }

    public Application getRecruiterviewedJob(Recruiter recruiter){
    	return recruiter.getapplication();
    }

	

	
		
	}
	

 



	

}
