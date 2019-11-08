package edu.northeastern.cs5200.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


public class releatedFields extends Recruiter{
	

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String major;
	private String skills;
	private String jobTitle;
	private String researchArea;
	
	
	public releatedFields() {}


	public releatedFields(String fristName, String lastName, String password, String email, String verified,
			String jobTitle, String major, String skills, String jobTitle2, String researchArea) {
		super(fristName, lastName, password, email, verified, jobTitle);
		this.major = major;
		this.skills = skills;
		jobTitle = jobTitle2;
		this.researchArea = researchArea;
	}


	public String getMajor() {
		return major;
	}


	public void setMajor(String major) {
		this.major = major;
	}


	public String getSkills() {
		return skills;
	}


	public void setSkills(String skills) {
		this.skills = skills;
	}


	public String getJobTitle() {
		return jobTitle;
	}


	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}


	public String getResearchArea() {
		return researchArea;
	}


	public void setResearchArea(String researchArea) {
		this.researchArea = researchArea;
	}


	
	
	
	
	
	
	
	

}
