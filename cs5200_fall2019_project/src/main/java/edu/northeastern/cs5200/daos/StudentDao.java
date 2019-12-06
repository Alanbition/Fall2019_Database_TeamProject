package edu.northeastern.cs5200.daos;

import org.springframework.beans.factory.annotation.Autowired;

import edu.northeastern.cs5200.models.Application;
import edu.northeastern.cs5200.models.Job;
import edu.northeastern.cs5200.models.Recruiter;
import edu.northeastern.cs5200.models.Student;
import edu.northeastern.cs5200.repositories.ApplicationRepository;
import edu.northeastern.cs5200.repositories.JobRepository;
import edu.northeastern.cs5200.repositories.RecruiterRepository;
import edu.northeastern.cs5200.repositories.StudentRepository;

public class StudentDao {
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	ApplicationRepository applicationRepository;
	
	public void deleteStudent(){
		studentRepository.deleteAll();
	}
	public Student createStudent(Student student){
		return studentRepository.save(student);
	}

    public Student addApplicationToStudent(Application application, Student student){
    	student.applicationsFromThisStudent(application);
    	applicationRepository.save(application);
    	return studentRepository.save(student);
    }
}
