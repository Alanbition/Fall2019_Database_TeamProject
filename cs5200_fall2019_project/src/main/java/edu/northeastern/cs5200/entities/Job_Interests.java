package edu.northeastern.cs5200.entities;
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

public class Job_Interests {
	@Id
	@GeneratedValue
	(strategy=GenerationType.IDENTITY)
	private int id;
	private String job_title;
	private String skills;
	private String location;
	@ManyToOne()
	private Student thisStudent_job_interests;
	
	public Job_Interests() {}
	
	public Job_Interests(String job_title, String skills, String location) {
		this.job_title = job_title;
		this.skills = skills;
		this.location = location;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJob_title() {
		return job_title;
	}
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Student getThisStudent_job_interests() {
		return thisStudent_job_interests;
	}
	public void setThisStudent_job_interests(Student thisStudent_job_interests) {
		this.thisStudent_job_interests =  thisStudent_job_interests;
		if (!thisStudent_job_interests.getJobs_for_thisStudent().contains(this)) {
			thisStudent_job_interests.getJobs_for_thisStudent().add(this);
		}
	}
}
