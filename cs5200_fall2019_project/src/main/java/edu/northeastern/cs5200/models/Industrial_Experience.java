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
public class Industrial_Experience {
	@Id
	@GeneratedValue
	(strategy=GenerationType.IDENTITY)
	private int id;
	private String company;
	private String job_title;
	private String description;
	private Date start_date;
	private Date end_date;
	@ManyToOne()
	private Resume this_resume_industrial_experience;
	
	public  Industrial_Experience() {}
	
	public  Industrial_Experience(String company, String job_title, String description, Date start_date, Date end_date) {
		this.company = company;
		this.job_title = job_title;
		this.description = description;
		this.start_date = start_date;
		this.end_date = end_date;
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

	public String getJob_title() {
		return job_title;
	}
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getStart_date(){
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}	
	
	public Resume getThis_resume_industrial_experience() {
		return this_resume_industrial_experience;
	}
	public void setThis_resume_industrial_experience(Resume this_resume_industrial_experience) {
		this.this_resume_industrial_experience = this_resume_industrial_experience;
		if (!this_resume_industrial_experience.getResume_industrial_experiences().contains(this)) {
			this_resume_industrial_experience.getResume_industrial_experiences().add(this);
		}
	}
}
