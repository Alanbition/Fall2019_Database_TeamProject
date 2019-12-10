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
	
	//Many to One for Students
	@ManyToOne
	private Student thisStudentApplications;

	public Student getThisStudentApplications() {
		return thisStudentApplications;
	}
	public void setThisStudentApplications(Student thisStudentApplications) {
		this.thisStudentApplications = thisStudentApplications;
		if (!thisStudentApplications.getApplicationsFromThisStudent().contains(this)) {
			thisStudentApplications.getApplicationsFromThisStudent().add(this);
		}
	}	
	//
	//Many To One for Jobs
	@ManyToOne
	private Job thisJobApplications;

	public Job getThisJobApplications() {
		return thisJobApplications;
	}
	public void setThisJobApplications(Job thisJobApplications) {
		this.thisJobApplications =  thisJobApplications;
		if (!thisJobApplications.getApplicationsForThisJob().contains(this)) {
			thisJobApplications.getApplicationsForThisJob().add(this);
		}
	}	
	//

	public Application(String description, String referral, String process) {
		super();
		this.description = description;
		this.referral = referral;
		this.process = process;
	}
	
//	public Application(Student student, Job job) {
//		super();
//		this.thisStudentApplications = student;
//		this.thisJobApplications = job;
//	}

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
	

}
