package edu.northeastern.cs5200.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import edu.northeastern.cs5200.models.Application;
import edu.northeastern.cs5200.models.EducationBackground;
import edu.northeastern.cs5200.models.Employee;
import edu.northeastern.cs5200.models.Group;
import edu.northeastern.cs5200.models.IndustrialExperience;
import edu.northeastern.cs5200.models.Job;
import edu.northeastern.cs5200.models.JobInterest;
import edu.northeastern.cs5200.models.MockInterviewRequest;
import edu.northeastern.cs5200.models.Notification;
import edu.northeastern.cs5200.models.Prime;
import edu.northeastern.cs5200.models.Project;
import edu.northeastern.cs5200.models.Recruiter;
import edu.northeastern.cs5200.models.ReferralRequest;
import edu.northeastern.cs5200.models.ResearchExperience;
import edu.northeastern.cs5200.models.Resume;
import edu.northeastern.cs5200.models.Student;
import edu.northeastern.cs5200.repositories.ApplicationRepository;
import edu.northeastern.cs5200.repositories.EducationBackgroundRepository;
import edu.northeastern.cs5200.repositories.EmployeeRepository;
import edu.northeastern.cs5200.repositories.GroupRepository;
import edu.northeastern.cs5200.repositories.IndustrialExperienceRepository;
import edu.northeastern.cs5200.repositories.JobInterestRepository;
import edu.northeastern.cs5200.repositories.JobRepository;
import edu.northeastern.cs5200.repositories.MockInterviewRequestRepository;
import edu.northeastern.cs5200.repositories.NotificationRepository;
import edu.northeastern.cs5200.repositories.PrimeRepository;
import edu.northeastern.cs5200.repositories.ProjectRepository;
import edu.northeastern.cs5200.repositories.RecruiterRepository;
import edu.northeastern.cs5200.repositories.ReferralRequestRepository;
import edu.northeastern.cs5200.repositories.ResearchExperienceRepository;
import edu.northeastern.cs5200.repositories.ResumeRepository;
import edu.northeastern.cs5200.repositories.StudentRepository;

@Controller("GeneralDao")
@Service
public class GeneralDao {
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	JobInterestRepository jobInterestRepository;
	@Autowired
	ProjectRepository projectRepository;
	@Autowired
	IndustrialExperienceRepository industrialExperienceRepository;
	@Autowired
	ResumeRepository resumeRepository;
	@Autowired
	EducationBackgroundRepository educationBackgroundRepository;
	@Autowired
	ResearchExperienceRepository researchExperienceRepository;
	@Autowired
	RecruiterRepository recruiterRepository;
	@Autowired
	JobRepository jobRepository;
	@Autowired
	ApplicationRepository applicationRepository;
	@Autowired
	GroupRepository groupRepository;
	@Autowired
	PrimeRepository primeRepository;
	@Autowired
	MockInterviewRequestRepository mockInterviewRequestRepository;
	@Autowired
	ReferralRequestRepository referralRequestRepository;
	@Autowired
	NotificationRepository notificationRepository;
	@Autowired
	EmployeeRepository employeeRepository;
	
	
	


	
	public void truncateDatabase () {
		studentRepository.deleteAll();
		jobInterestRepository.deleteAll();
		projectRepository.deleteAll();
		industrialExperienceRepository.deleteAll();
		resumeRepository.deleteAll();
		educationBackgroundRepository.deleteAll();
		researchExperienceRepository.deleteAll();
		recruiterRepository.deleteAll();
		jobRepository.deleteAll();
		applicationRepository.deleteAll();
		jobRepository.deleteAll();
		groupRepository.deleteAll();
		primeRepository.deleteAll();
		mockInterviewRequestRepository.deleteAll();		
		referralRequestRepository.deleteAll();
		notificationRepository.deleteAll();
		employeeRepository.deleteAll();
		recruiterRepository.deleteAll();
		
		
		
	}
	
	
	public Student createStudent(Student student){
		return studentRepository.save(student);
	}
	
	public JobInterest createJobInterest(JobInterest jobInterest) {
		return jobInterestRepository.save(jobInterest);
	}
	
	public Project createProject(Project project) {
		return projectRepository.save(project);
	}
	
	public IndustrialExperience createIndustrialExperience(IndustrialExperience industrialExperience) {
		return industrialExperienceRepository.save(industrialExperience);
	}
	public Resume createResume (Resume resume) {
		return resumeRepository.save(resume);
	}
	public EducationBackground createEducationBackground(EducationBackground educationBackground) {
		return educationBackgroundRepository.save(educationBackground);
	}
	public ResearchExperience createResearchExperience(ResearchExperience researchExperience) {
		return researchExperienceRepository.save(researchExperience);
	}
	public Recruiter createRecruiter(Recruiter recruiter) {
		return recruiterRepository.save(recruiter);
	}
	public Job createJob (Job job) {
		return jobRepository.save(job);
	}
	public Application createApplication (Application application) {
		return applicationRepository.save(application);
	}
	public Group createGroup (Group group) {
		return groupRepository.save(group);
	}
	public Prime createPrime(Prime prime) {
		return primeRepository.save(prime);
	}
	public MockInterviewRequest createMockInterviewRequest(MockInterviewRequest mockInterviewRequest) {
		return mockInterviewRequestRepository.save(mockInterviewRequest);
	}
	public MockInterviewRequest findMockInterviewRequestById(int id) {
		return mockInterviewRequestRepository.findById(id).get();
	}
	public ReferralRequest createReferralRequest(ReferralRequest referralRequest) {
		return referralRequestRepository.save(referralRequest);
		
	}
	public Notification createNotification(Notification notification) {
		return notificationRepository.save(notification);
	}
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
		
	}

}
