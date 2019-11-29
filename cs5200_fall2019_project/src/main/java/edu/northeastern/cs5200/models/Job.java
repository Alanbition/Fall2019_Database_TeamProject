package edu.northeastern.cs5200.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Job {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	private String descripition;
	private String location;
	private String requirment;
	private String company;
	
	public Job() {}
	@OneToMany (mappedBy= "Application")
	private Application application;
	@ManyToOne 
	private Recruiter recruiter;

	public Job(String title, String descripition, String location, String requirment, String company,
			Recruiter recruiter) {
		super();
		this.title = title;
		this.descripition = descripition;
		this.location = location;
		this.requirment = requirment;
		this.company = company;
		this.recruiter = recruiter;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescripition() {
		return descripition;
	}

	public void setDescripition(String descripition) {
		this.descripition = descripition;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getRequirment() {
		return requirment;
	}

	public void setRequirment(String requirment) {
		this.requirment = requirment;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Recruiter getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(Recruiter recruiter) {
		this.recruiter = recruiter;
	}
	
	
	
	 

}
