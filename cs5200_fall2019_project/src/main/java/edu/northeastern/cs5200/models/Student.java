//Shijin Wang
package edu.northeastern.cs5200.models;

import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
@Entity
public class Student extends User{
	private Boolean verified;
	private Boolean enablePrime;

	//Many to many for groups
	@ManyToMany
	@JoinTable(name = "StudentGroupEnrollment", joinColumns = @JoinColumn(name = "studentId", referencedColumnName="ID"), 
		inverseJoinColumns = @JoinColumn(name = "groupId", referencedColumnName="ID"))
	private List<Group> enrolledGroups;

	

	//One To many for job interests
	@OneToMany(mappedBy="thisStudentJobInterests", orphanRemoval = true, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SELECT)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<JobInterest> jobsForThisStudent;
	


	//One to many for resumes
	@OneToMany(mappedBy="thisStudentResume", orphanRemoval = true, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SELECT)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Resume> resumesForThisStudent;	



	//One to Many for applications
	@OneToMany(mappedBy="thisStudentApplications", orphanRemoval = true, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SELECT)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Application> applicationsFromThisStudent;		
	

	
	//For notification OneToMany	
	@OneToMany (mappedBy = "thisStudentNotifications")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Notification> notificationsForStudent;



	//For prime Service OneToOne relationship
	@OneToOne(mappedBy = "thisStudentPrimeService", cascade = CascadeType.ALL)
	private Prime primeService;
	//
	public Student() {
		super();
	}
	
	public Student(String firstName, String lastName, String password, String email, String userDtype, Boolean verified, Boolean enablePrime) {
		super(firstName, lastName, password, email, userDtype);
		this.verified = verified;
		this.enablePrime = enablePrime;
	}
	
	public Boolean getVerified() {
		return verified;
	}
	
	public void setVerified(Boolean verified) {
		this.verified = verified;
	}

	public Prime getPrimeService() {
		return primeService;
	}
	
	public void setPrimeService(Prime primeService) {
		this.primeService = primeService;
	}
	
	public Boolean getEnablePrime() {
		return enablePrime;
	}
	
	public void setEnablePrime(Boolean enablePrime) {
		this.enablePrime = enablePrime;
	}
	//Group
	public void enrolledGroups(Group group) {
		this.enrolledGroups.add(group);
		if (!group.getEnrolledStudents().contains(this)) {
			group.getEnrolledStudents().add(this);
		}
	}

	public void removeEnrolledGroup(Group group) {
		this.enrolledGroups.remove(group);
		if (group.getEnrolledStudents().contains(this)) {
			group.getEnrolledStudents().remove(this);
		}
	}
	
	public List<Group> getEnrolledGroups(){
		return enrolledGroups;
	}
	
	public void setEnrolledGroups(List<Group> enrolledGroups) {
		this.enrolledGroups = enrolledGroups;
	}
	//Job Interests
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
	//Resume
	public void resumesForThisStudent(Resume resume) {
		this.resumesForThisStudent.add(resume);
		if (resume.getThisStudentResume() != this)
			resume.setThisStudentResume(this);
	}
	
	public void removeResumeFromThisStudent(Resume res) {
		this.resumesForThisStudent.remove(res);
		res.setThisStudentResume(null);
	}

	public List<Resume> getResumesForThisStudent(){
		return resumesForThisStudent;
	}
	
	public void setResumesForThisStudent(List<Resume> resumesForThisStudent) {
		this.resumesForThisStudent = resumesForThisStudent;
	}
	
	//Application
	public void applicationsFromThisStudent(Application app) {
		this.applicationsFromThisStudent.add(app);
		if (app.getThisStudentApplications() != this)
			app.setThisStudentApplications(this);
	}
	
	public void removeApplicationsFromThisStudent(Application app) {
		this.applicationsFromThisStudent.remove(app);
		app.setThisStudentApplications(null);
	}

	public List<Application> getApplicationsFromThisStudent(){
		return applicationsFromThisStudent;
	}
	
	public void setApplicationsFromThisStudent(List<Application> applicationsFromThisStudent) {
		this.applicationsFromThisStudent = applicationsFromThisStudent;
	}
	//Notification
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
	
	
}
