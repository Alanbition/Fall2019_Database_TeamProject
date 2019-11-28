package edu.northeastern.cs5200.entities;

import java.util.List;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
@Entity
public class Student extends User{
	@Column(name = "major")
	private Integer major;
	@Column(name = "verified")
	private Boolean verified;
	@Column(name = "degree")
	private Integer degree;	
	@OneToMany(mappedBy="thisStudent_job_interests", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Job_Interests> jobs_for_thisStudent;

	@OneToMany(mappedBy="thisStudent_job_applied", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Applied_Job_Lists> jobsApplied_by_thisStudent;
	
	@OneToMany(mappedBy="thisStudent_resume", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Resume> resumes_for_thisStudent;	
	
	
	
	
	public Student() {
		super();
	}
	
	public Student(String first_name, String last_name, String password, String email, Integer major, Boolean verified, Integer degree) {
		super(first_name, last_name, password, email);
		this.major = major;
		this.verified = verified;
		this.degree = degree;
	}
	
	public Integer getMajor() {
		return major;
	}
	
	public void setMajor(Integer major) {
		this.major = major;
	}
	
	public Boolean getVerified() {
		return verified;
	}
	
	public void setVerified(Boolean verified) {
		this.verified = verified;
	}
	
	public Integer getDegree() {
		return degree;
	}
	
	public void setDegree(Integer degree) {
		this.degree = degree;
	}	
	
	public void jobs_for_thisStudent(Job_Interests job) {
		this.jobs_for_thisStudent.add(job);
		if (job.getThisStudent_job_interests() != this)
			job.setThisStudent_job_interests(this);
	}
	
	public List<Job_Interests> getJobs_for_thisStudent(){
		return jobs_for_thisStudent;
	}
	
	public void setJobs_for_thisStudent(List<Job_Interests> jobs_for_thisStudent) {
		this.jobs_for_thisStudent = jobs_for_thisStudent;
	}
	
	
	public void jobsApplied_by_thisStudent(Applied_Job_Lists jobs) {
		this.jobsApplied_by_thisStudent.add(jobs);
		if (jobs.getThisStudent_job_applied() != this)
			jobs.setthisStudent_job_applied(this);
	}
	
	public List<Applied_Job_Lists> getJobsApplied_by_thisStudent(){
		return jobsApplied_by_thisStudent;
	}
	
	public void setJobsApplied_by_thisStudent(List<Applied_Job_Lists> jobsApplied_by_thisStudent) {
		this.jobsApplied_by_thisStudent = jobsApplied_by_thisStudent;
	}
	
	public void resumes_for_thisStudent(Resume resume) {
		this.resumes_for_thisStudent.add(resume);
		if (resume.getThisStudent_resume() != this)
			resume.setThisStudent_resume(this);
	}
	
	public List<Resume> getResumes_for_thisStudent(){
		return resumes_for_thisStudent;
	}
	
	public void setResumes_for_thisStudent(List<Resume> resumes_for_thisStudent) {
		this.resumes_for_thisStudent = resumes_for_thisStudent;
	}
}
