package edu.northeastern.cs5200.controllers;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.cs5200.daos.GeneralDao;
import edu.northeastern.cs5200.daos.GroupDao;
import edu.northeastern.cs5200.daos.StudentDao;
import edu.northeastern.cs5200.models.Application;
import edu.northeastern.cs5200.models.EducationBackground;
import edu.northeastern.cs5200.models.Employee;
import edu.northeastern.cs5200.models.Group;
import edu.northeastern.cs5200.models.IndustrialExperience;
import edu.northeastern.cs5200.models.Job;
import edu.northeastern.cs5200.models.Project;
import edu.northeastern.cs5200.models.Recruiter;
import edu.northeastern.cs5200.models.ResearchExperience;
import edu.northeastern.cs5200.models.Resume;
import edu.northeastern.cs5200.models.Student;
import edu.northeastern.cs5200.models.User;
import edu.northeastern.cs5200.repositories.ApplicationRepository;
import edu.northeastern.cs5200.repositories.EducationBackgroundRepository;
import edu.northeastern.cs5200.repositories.GroupRepository;
import edu.northeastern.cs5200.repositories.IndustrialExperienceRepository;
import edu.northeastern.cs5200.repositories.ProjectRepository;
import edu.northeastern.cs5200.repositories.ResearchExperienceRepository;
import edu.northeastern.cs5200.repositories.ResumeRepository;
import edu.northeastern.cs5200.repositories.StudentRepository;

	
@Controller
public class StudentController {

	@Autowired
	StudentDao studentDao;
	@Autowired
	GroupDao groupDao;
	@Autowired
	GeneralDao generalDao;
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	GroupRepository groupRepository;
	@Autowired
	ApplicationRepository applicationRepository;
	@Autowired
	ResumeRepository resumeRepository;
	@Autowired
	ProjectRepository projectRepository;
	@Autowired
	IndustrialExperienceRepository industrialExperienceRepository;
	@Autowired
	ResearchExperienceRepository researchExperienceRepository;
	@Autowired
	EducationBackgroundRepository educationBackgroundRepository;
	

	
	@RequestMapping(value="/apply", method=RequestMethod.POST)
	public void apply(@RequestParam("jobTitle")String jobTitle, HttpSession session){
	//user object will automatically be populated with values sent from browser or jsp page. Provide your authentication logic here
		System.out.println("applying?");
		Job job = new Job(jobTitle,"Description of the job posting","Boston","","Authentic");
		Student currentUser = (Student)
		session.getAttribute("currentUser");
		Application application = new Application(currentUser,job);

		
	} 

	
	
	

	@GetMapping ("/api/student")
	public Iterable <Student> findAllStudent (){
		Iterable<Student> student = studentDao.findAllStudents();
		return student;
	}

	@DeleteMapping ("/api/student/{sid}")
	public void deleteStudent(@PathVariable("sid") int id){
		studentDao.deleteStudentById(id);
	}

	@PostMapping ("api/student/{sid}/group/{gid}")
	public Group enrollStudentToGruop(@PathVariable("sid") int sid, @PathVariable("gid") int gid){
		Student student= studentRepository.findById(sid).get();
		Group group = groupRepository.findById(gid).get();
		return studentDao.enrollStudentToGroup(group, student);
	} 
	
	@DeleteMapping ("api/student/{sid}/group/{gid}")
	public void quitGroupByStudent (@PathVariable("sid") int sid, @PathVariable("gid") int gid ){
		Student student= studentRepository.findById(sid).get();
		Group group = groupRepository.findById(gid).get();
		 studentDao.quitGroupByStudent(group, student);
	}

	@PostMapping ("api/student/{sid}/applicaition/{aid}")
	public Student addApplicationToStudent(@PathVariable("sid") int sid, @PathVariable("aid") int aid){
		Student student= studentRepository.findById(sid).get();
		Application applicaition = applicationRepository.findById(aid).get();
		return studentDao.addApplicationToStudent(applicaition, student);
	}

	@DeleteMapping("api/student/{sid}/applicaition/{aid}")
	public void deleteApplicationFromStudent(@PathVariable("sid") int sid, @PathVariable("aid") int aid){
		Student student= studentRepository.findById(sid).get();
		Application applicaition = applicationRepository.findById(aid).get();
		 studentDao.deleteApplicationFromStudent(applicaition, student);
	}	

	@PostMapping ("api/student/{sid}/resume/{rid}")
	public Student addResumeToStudent(@PathVariable("sid") int sid, @PathVariable("rid") int rid){
		Student student= studentRepository.findById(sid).get();
		Resume resume = resumeRepository.findById(rid).get();
		return studentDao.addResumeToStudent(resume, student);
	}

	@DeleteMapping ("api/student/{sid}/resume/{rid}")
	public void deleteResumeFromStudent(@PathVariable("sid") int sid, @PathVariable("rid") int rid){
		Student student= studentRepository.findById(sid).get();
		Resume resume = resumeRepository.findById(rid).get();
		 studentDao.deleteResumeFromStudent(resume, student);
	}

	@PostMapping ("api/resume/{rid}/project/{pid}")
	public Resume addProjectToResume(@PathVariable("rid") int rid, @PathVariable("pid") int pid){
		Resume resume =resumeRepository.findById(rid).get();
		Project project = projectRepository.findById(pid).get();
		return studentDao.addProjectToResume(resume, project);
	}

	@DeleteMapping ("api/resume/{rid}/project/{pid}")
	public void deleteProjectFromResume(@PathVariable("rid") int rid, @PathVariable("pid") int pid){
		Resume resume =resumeRepository.findById(rid).get();
		Project project = projectRepository.findById(pid).get();
		studentDao.deleteProjectFromResume(resume, project);
	}

	@PostMapping ("api/resume{rid}/IndustrialExperience/{iid}")
	public Resume addIndustrialExperienceToResume(@PathVariable("rid") int rid,@PathVariable("iid") int iid){
		Resume resume =resumeRepository.findById(rid).get();
		IndustrialExperience industrialExperience = industrialExperienceRepository.findById(iid).get();
		return studentDao.addIndustrialExperienceToResume(resume, industrialExperience);
		
}
	@DeleteMapping ("api/resume{rid}/IndustrialExperience/{iid}")
	public void deleteIndustrialExperienceFromResume(@PathVariable("rid") int rid,@PathVariable("iid") int iid){
		Resume resume =resumeRepository.findById(rid).get();
		IndustrialExperience industrialExperience = industrialExperienceRepository.findById(iid).get();
		 studentDao.deleteIndustrialExperienceFromResume(resume, industrialExperience);
		
}

	@PostMapping ("api/resume{rid}/ResearchExperience/{reid}")
		public Resume addResearchExperienceToResume(@PathVariable("rid") int rid,@PathVariable("iid") int reid){
		Resume resume =resumeRepository.findById(rid).get();
		ResearchExperience researchExperience = researchExperienceRepository.findById(reid).get();
		return studentDao.addResearchExperienceToResume(resume, researchExperience);
		
}
	@DeleteMapping ("api/resume{rid}/ResearchExperience/{reid}")
		public void deleteResearchExperienceFromResume(@PathVariable("rid") int rid,@PathVariable("iid") int reid){
		Resume resume =resumeRepository.findById(rid).get();
		ResearchExperience researchExperience = researchExperienceRepository.findById(reid).get();
		 studentDao.deleteResearchExperienceFromResume(resume, researchExperience);
		
}
	@PostMapping ("api/resume{rid}/EducationBackground/{ebid}")
		public Resume addEducationBackgroundToResume(@PathVariable("rid") int rid,@PathVariable("ebid") int ebid){
		Resume resume =resumeRepository.findById(rid).get();
		EducationBackground educationBackground = educationBackgroundRepository.findById(ebid).get();
		return studentDao.addEducationBackgroundToResume(resume, educationBackground);
		
}
	@DeleteMapping ("api/resume{rid}/EducationBackground/{ebid}")
		public Resume deleteEducationBackgroundToResume (@PathVariable("rid") int rid,@PathVariable("ebid") int ebid){
		Resume resume =resumeRepository.findById(rid).get();
		EducationBackground educationBackground = educationBackgroundRepository.findById(ebid).get();
		return studentDao.addEducationBackgroundToResume(resume, educationBackground);
		
}


	@GetMapping("api/student/{sid}")
	public List<Student> students(@PathVariable("sid") int sid){
		List<Student> students = studentDao.findAllStudents();
		return students;
	}

	

	

	@GetMapping("api/student/{sid}/group")
	public List<Group> findGroupsForStudent (@PathVariable("sid") int sid) {	
		Student student = studentDao.findStudentById(sid);
		List<Group> group = studentDao.findGroupsForStudent(student);
		return group;
	}
	
	@GetMapping("api/student/{sid}/application/{aid}")
	public List<Application> findApplicationsForStudent(@PathVariable("aid") int aid, @PathVariable ("sid") int sid){
		Student student = studentDao.findStudentById(sid);
		List<Application> applications = studentDao.findApplicationsForStudent(student);
		return applications;
	}
	
	@GetMapping("api/student/{sid}/resume")
	public List<Resume> findResumesForStudent(@PathVariable ("sid") int sid){
		Student student = studentDao.findStudentById(sid);
		List<Resume> resumes = studentDao.findResumesForStudent(student);
		return resumes;
	}
	@GetMapping("/api/employee/login")
    public Student loginUser(@RequestParam("email") String email, @RequestParam("password") String password) {
        return studentDao.findStudentByCredentials(email, password);
    }
	
	

}
