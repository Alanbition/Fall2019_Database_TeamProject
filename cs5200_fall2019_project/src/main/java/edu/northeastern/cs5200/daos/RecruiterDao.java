package edu.northeastern.cs5200.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import edu.northeastern.cs5200.models.Employee;
import edu.northeastern.cs5200.models.Job;
import edu.northeastern.cs5200.models.Recruiter;
import edu.northeastern.cs5200.repositories.JobRepository;
import edu.northeastern.cs5200.repositories.RecruiterRepository;

@Controller("RecruiterDao")
@Service
public class RecruiterDao {
	@Autowired
	RecruiterRepository recruiterRepository;
	@Autowired
	JobRepository jobRepository;
	
	public void deleteRecruiter(){
		recruiterRepository.deleteAll();
	}

	public Recruiter createRecruiter(Recruiter recruiter){
		return recruiterRepository.save(recruiter);
	}
	
	public Iterable<Recruiter> findAllRecruiter() {
		return recruiterRepository.findAll();
	}

	public Recruiter updateRecruiter(int id, Recruiter recruiter) {
		Recruiter r = recruiterRepository.findById(id).get();
        r.setEmail(recruiter.getEmail());
        r.setFirstName(recruiter.getFirstName());
        r.setLastName(recruiter.getLastName());
        r.setPassword(recruiter.getPassword());
        recruiterRepository.save(r);
        return r;
	}
	
    public Recruiter addJobToRecruiter(Job job, Recruiter recruiter){
    	recruiter.jobsCreatedByRecruiter(job);
    	jobRepository.save(job);
    	return recruiterRepository.save(recruiter);
    }
    
    public Recruiter removeJobfromRecruiter(Job job, Recruiter recruiter){
    	recruiter.removeJob(job);
    	jobRepository.delete(job);;
    	return recruiterRepository.save(recruiter);
    }
    
    
    
   
}

