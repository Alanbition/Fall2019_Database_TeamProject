package edu.northeastern.cs5200.models;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Entity
public class IndustrialExperience {
	@Id
	@GeneratedValue
	(strategy=GenerationType.IDENTITY)
	private int id;
	private String company;
	private String jobTitle;
	private String description;
	private Date startDate;
	private Date endDate;
	@ManyToOne()
	private Resume thisResumeIndustrialExperience;
	
	public  IndustrialExperience() {}
	
	public  IndustrialExperience(String company, String jobTitle, String description, Date startDate, Date endDate) {
		this.company = company;
		this.jobTitle = jobTitle;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}

	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getStartDate(){
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}	
	
	public Resume getThisResumeIndustrialExperience() {
		return thisResumeIndustrialExperience;
	}
	public void setThisResumeIndustrialExperience(Resume thisResumeIndustrialExperience) {
		this.thisResumeIndustrialExperience = thisResumeIndustrialExperience;
		if (!thisResumeIndustrialExperience.getResumeIndustrialExperiences().contains(this)) {
			thisResumeIndustrialExperience.getResumeIndustrialExperiences().add(this);
		}
	}
}
