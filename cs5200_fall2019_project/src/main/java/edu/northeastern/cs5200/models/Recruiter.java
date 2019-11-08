package edu.northeastern.cs5200.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class Recruiter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String fristName;
	private String lastName;
	private String password;
	private String email;
	private String verified;
	private String jobTitle;
	
	public Recruiter() {}
	
	@OneToMany( mappedBy = "Job")
	private List<Job> job;
	
	@OneToMany (mappedBy = "Application")
	private List<Application> application;
	
//	@OneToMany (mappedBy = "Resume")
//	private List<Resume> resume;
	
//	@OneToMany (mappedBy = "notification")
//	private List<Notification> notification;

	public Recruiter(String fristName, String lastName, String password, String email, String verified,
			String jobTitle) {
		super();
		this.fristName = fristName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.verified = verified;
		this.jobTitle = jobTitle;
	}

	public String getFristName() {
		return fristName;
	}

	public void setFristName(String fristName) {
		this.fristName = fristName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVerified() {
		return verified;
	}

	public void setVerified(String verified) {
		this.verified = verified;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public List<Job> getJob() {
		return job;
	}

	public void setJobs(List<Job> job) {
		this.job = job;
	}
	
	
	

}
