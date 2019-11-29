package edu.northeastern.cs5200.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity

public class Application {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String description;
	private String referral;
	private String process;
	
	@ManyToOne
	private Job job;
	
	@ManyToOne
	private Recruiter recruiter;
	
//	@ManyToOne
//	private Student student;
	

	public Application(String description, String referral, String process, Job job) {
		super();
		this.description = description;
		this.referral = referral;
		this.process = process;
		this.job = job;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReferral() {
		return referral;
	}

	public void setReferral(String referral) {
		this.referral = referral;
	}

	public String getProcess() {
		return process;
	}

	public void setProcess(String process) {
		this.process = process;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}
	
	

}
