package edu.northeastern.cs5200.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.northeastern.cs5200.models.*;
import edu.northeastern.cs5200.repositories.*;

public class StudentDao {
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	ApplicationRepository applicationRepository;
	@Autowired
	PrimeRepository primeRepository;
	@Autowired
	GroupRepository groupRepository;
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


	public Student updateStudent (int id, Student student) {
		Student s = (Student) studentRepository.findById(id).get();
        s.setEmail(student.getEmail());
        s.setFirstName(student.getFirstName());
        s.setLastName(student.getLastName());
        s.setPassword(student.getPassword());
        studentRepository.save(s);
        return s;
	}

	public void deleteAllStudents(){
		studentRepository.deleteAll();
	}	

	public void deleteStudentById(int id){
		studentRepository.deleteById(id);
	}	


	public void deleteStudentFromGroup(Group group, Student student){
		group.removeEnrolledStudent(student);
		groupRepository.save(group);
		studentRepository.save(student);
	}

	public void quietGroupByStudent(Group group, Student student){
		student.removeEnrolledGroup(group);
		studentRepository.save(student);
		groupRepository.save(group);
	}

	public Group enrollStudentToGroup(Group group, Student student){
		group.enrolledStudents(student);
		studentRepository.save(student);
		return groupRepository.save(group);
	}


    public Student addApplicationToStudent(Application application, Student student){
    	student.applicationsFromThisStudent(application);
    	applicationRepository.save(application);
    	return studentRepository.save(student);
    }

    public void deleteApplicationFromStudent(Application application, Student student){
    	student.removeApplicationsFromThisStudent(application);
    	studentRepository.save(student);
    	applicationRepository.save(application);
    }


    public Student addResumeToStudent(Resume resume, Student student){
    	student.resumesForThisStudent(resume);
    	resumeRepository.save(resume);
    	return studentRepository.save(student);
    }

    public void deleteResumeFromStudent(Resume resume, Student student){
    	student.removeResumeFromThisStudent(resume);
    	resumeRepository.save(resume);
    	studentRepository.save(student);
    }

    public Resume addProjectToResume(Resume resume, Project project){
    	resume.resumeProject(project);
    	projectRepository.save(project);
    	return resumeRepository.save(resume);

    }

    public void deleteProjectFromResume(Resume resume, Project project){
    	resume.removeProjectFromResume(project);
    	projectRepository.save(project);
    	resumeRepository.save(resume);
    }

    public Resume addIndustrialExperienceToResume(Resume resume, IndustrialExperience industrialExperience){
    	resume.resumeIndustrialExperiences(industrialExperience);
    	industrialExperienceRepository.save(industrialExperience);
    	return resumeRepository.save(resume);
    }

    public void deleteIndustrialExperienceFromResume(Resume resume, IndustrialExperience industrialExperience){
    	resume.removeIndustrialExperienceFromResume(industrialExperience);
    	industrialExperienceRepository.save(industrialExperience);
    	resumeRepository.save(resume);
    }

    public Resume addResearchExperienceToResume(Resume resume, ResearchExperience researchExperience){
    	resume.resumeResearchExperiences(researchExperience);
    	researchExperienceRepository.save(researchExperience);
    	return resumeRepository.save(resume);
    }

    public void deleteResearchExperienceFromResume(Resume resume, ResearchExperience researchExperience){
    	resume.removeResearchExperienceFromResume(researchExperience);
     	researchExperienceRepository.save(researchExperience);
    	resumeRepository.save(resume);   	
    } 

     public Resume addEducationBackgroundToResume(Resume resume, EducationBackground educationBackground){
     	resume.resumeEducationBackgrounds(educationBackground);
     	educationBackgroundRepository.save(educationBackground);
     	return resumeRepository.save(resume);
    }

    public void deleteEducationBackgroundFromResume(Resume resume, EducationBackground educationBackground){
    	resume.removeEducationBackgroundFromResume(educationBackground);
     	educationBackgroundRepository.save(educationBackground);
     	resumeRepository.save(resume);
    } 


    public Student enablePrimeService(Prime prime, Student student){
    	student.setEnablePrime(true);
    	student.setPrimeService(prime);
    	primeRepository.save(prime);
    	return studentRepository.save(student);
    }

    public Student disablePrimeService(Prime prime, Student student){
    	student.setEnablePrime(false);
    	student.setPrimeService(prime);
    	primeRepository.save(prime);
    	return studentRepository.save(student);
    }

//    public Student sendMockInterviewRequest(MockInterviewRequest mockInterviewRequest, Prime prime){
//
//
//    }
//
//    public Student sendReferralRequest(MockInterviewRequest mockInterviewRequest, Prime prime){
//    	
//
//    }

	public List<Student> findAllStudents(){
		List<Student> students = (List<Student>) studentRepository.findAll();
		return students;
	}

	public List<Student> findStudentsInGroup(Group group){
		List<Student> students = (List<Student>) group.getEnrolledStudents();
		return students;
	}

	public List<Group> findGroupsForStudent(Student student){
		List<Group> groups = (List<Group>) student.getEnrolledGroups();
		return groups;
	}		

	public Student findStudentByCredentials(String email, String password){
		Student student = studentRepository.findStudentByCredentials(email, password);
		return student;
	}

	public List<Application> findApplicationsForStudent(Student student){
		List<Application> application = (List<Application>) student.getApplicationsFromThisStudent();
		return application;
	}	

	public List<Resume> findResumesForStudent(Student student){
		List<Resume> resume = (List<Resume>) student.getResumesForThisStudent();
		return resume;
	}

}
