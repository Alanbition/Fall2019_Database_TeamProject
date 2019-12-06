package edu.northeastern.cs5200.models;
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

public class JobInterest {
	@Id
	@GeneratedValue
	(strategy=GenerationType.IDENTITY)
	private int id;
	private String jobTitle;
	private String skills;
	private String location;
	@ManyToOne()
	private Student thisStudentJobInterests;
	
	public JobInterest() {}
	
	public JobInterest(String jobTitle, String skills, String location) {
		this.jobTitle = jobTitle;
		this.skills = skills;
		this.location = location;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
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
	public Student getThisStudentJobInterests() {
		return thisStudentJobInterests;
	}
	public void setThisStudentJobInterests(Student thisStudentJobInterests) {
		this.thisStudentJobInterests =  thisStudentJobInterests;
		if (!thisStudentJobInterests.getJobsForThisStudent().contains(this)) {
			thisStudentJobInterests.getJobsForThisStudent().add(this);
		}
	}
}
