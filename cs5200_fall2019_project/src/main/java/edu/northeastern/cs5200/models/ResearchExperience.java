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
public class ResearchExperience {
	@Id
	@GeneratedValue
	(strategy=GenerationType.IDENTITY)
	private int id;
	private String university;
	private String professor;
	private String jobTitle;
	private String description;
	private Date startDate;
	private Date endDate;
	@ManyToOne()
	private Resume thisResumeResearchExperience;
	
	public ResearchExperience() {}
	
	public ResearchExperience(String university, String professor, String jobTitle, String description, Date startDate, Date endDate) {
		this.university = university;
		this.professor = professor;
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
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}

	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public String getjobTitle() {
		return jobTitle;
	}
	public void setjobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getstartDate(){
		return startDate;
	}
	public void setstartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getendDate() {
		return endDate;
	}
	public void setendDate(Date endDate) {
		this.endDate = endDate;
	}	
	
	public Resume getThisResumeResearchExperience() {
		return thisResumeResearchExperience;
	}
	public void setThisResumeResearchExperience(Resume thisResumeResearchExperience) {
		this.thisResumeResearchExperience =  thisResumeResearchExperience;
		if (!thisResumeResearchExperience.getResumeResearchExperiences().contains(this)) {
			thisResumeResearchExperience.getResumeResearchExperiences().add(this);
		}
	}	
	
}
