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
public class Projects{
	@Id
	@GeneratedValue
	(strategy=GenerationType.IDENTITY)
	private int id;
	private String project_name;
	private String description;
	private Date start_date;
	private Date end_date;
	@ManyToOne()
	private Resume this_resume_project;
	
	public Projects() {}
	
	public Projects(String project_name, String description, Date start_date, Date end_date) {
		this.project_name = project_name;
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
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
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
	
	public Resume getThis_resume_project() {
		return this_resume_project;
	}
	public void setThis_resume_project(Resume this_resume_project) {
		this.this_resume_project =  this_resume_project;
		if (!this_resume_project.getResume_projects().contains(this)) {
			this_resume_project.getResume_projects().add(this);
		}
	}	
	
}
