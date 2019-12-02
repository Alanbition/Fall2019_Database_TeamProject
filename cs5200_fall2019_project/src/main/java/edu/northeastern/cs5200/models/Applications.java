package edu.northeastern.cs5200.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity

public class Applications {
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
	private Jobs thisJobsApplications;

	public Jobs getThisJobsApplications() {
		return thisJobsApplications;
	}
	public void setThisJobsApplications(Jobs thisJobsApplications) {
		this.thisJobsApplications =  thisJobsApplications;
		if (!thisJobsApplications.getApplicationsForThisJob().contains(this)) {
			thisJobsApplications.getApplicationsForThisJob().add(this);
		}
	}	
	//

	public Applications(String description, String referral, String process) {
		super();
		this.description = description;
		this.referral = referral;
		this.process = process;
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
	

}
