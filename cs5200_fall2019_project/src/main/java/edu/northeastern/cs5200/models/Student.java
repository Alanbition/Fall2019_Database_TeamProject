//Shijin Wang
package edu.northeastern.cs5200.models;

import java.util.List;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
@Entity
public class Student extends User{
	private Boolean verified;

	//One To many for job interests
	@OneToMany(mappedBy="thisStudentJobInterests", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<JobInterest> jobsForThisStudent;
	
	public void jobsForThisStudent(JobInterest job) {
		this.jobsForThisStudent.add(job);
		if (job.getThisStudentJobInterests() != this)
			job.setThisStudentJobInterests(this);
	}
	
	public List<JobInterest> getJobsForThisStudent(){
		return jobsForThisStudent;
	}
	
	public void setJobsForThisStudent(List<JobInterest> jobsForThisStudent) {
		this.jobsForThisStudent = jobsForThisStudent;
	}

	//One to many for resumes
	@OneToMany(mappedBy="thisStudentResume", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Resume> resumesForThisStudent;	

	public void resumesForThisStudent(Resume resume) {
		this.resumesForThisStudent.add(resume);
		if (resume.getThisStudentResume() != this)
			resume.setThisStudentResume(this);
	}
	
	public List<Resume> getResumesForThisStudent(){
		return resumesForThisStudent;
	}
	
	public void setResumesForThisStudent(List<Resume> resumesForThisStudent) {
		this.resumesForThisStudent = resumesForThisStudent;
	}

	//One to Many for applications
	@OneToMany(mappedBy="thisStudentApplications", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Application> applicationsFromThisStudent;		
	
	public void applicationsFromThisStudent(Application app) {
		this.applicationsFromThisStudent.add(app);
		if (app.getThisStudentApplications() != this)
			app.setThisStudentApplications(this);
	}
	
	public List<Application> getApplicationsFromThisStudent(){
		return applicationsFromThisStudent;
	}
	
	public void setApplicationsFromThisStudent(List<Application> applicationsFromThisStudent) {
		this.applicationsFromThisStudent = applicationsFromThisStudent;
	}
	//
	
	//For notification OneToMany	
	@OneToMany (mappedBy = "thisStudentNotifications")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Notification> notificationsForStudent;

	public void notificationsForStudent(Notification nots) {
		this.notificationsForStudent.add(nots);
		if (nots.getThisStudentNotifications() != this)
			nots.setThisStudentNotifications(this);
	}

	public List<Notification> getNotificationsForStudent(){
		return notificationsForStudent;
	}
	
	public void setNotificationsForStudent(List<Notification> notificationsForStudent) {
		this.notificationsForStudent = notificationsForStudent;
	}

	//
	
	public Student() {
		super();
	}
	
	public Student(String firstName, String lastName, String password, String email, Boolean verified) {
		super(firstName, lastName, password, email);
		this.verified = verified;
	}
	
	public Boolean getVerified() {
		return verified;
	}
	
	public void setVerified(Boolean verified) {
		this.verified = verified;
	}
	
}
