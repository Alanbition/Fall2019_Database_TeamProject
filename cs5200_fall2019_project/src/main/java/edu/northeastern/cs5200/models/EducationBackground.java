package edu.northeastern.cs5200.models;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
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
public class EducationBackground {
	@Id
	@GeneratedValue
	(strategy=GenerationType.IDENTITY)
	private int id;
	private String university;
	private String degree;
	private String major;
	private Date startDate;
	private Date endDate;
	private String GPA;
	@ManyToOne()
	private Resume thisResumeEducationBackground;
	
	public EducationBackground() {}
	
	public EducationBackground(String university, String degree, String major, Date startDate, Date endDate, String GPA) {
		this.university = university;
		this.degree = degree;
		this.major = major;
		this.startDate = startDate;
		this.endDate = endDate;
		this.GPA = GPA;
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

	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}	
	
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
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
	public String getGPA() {
		return GPA;
	}

	public void setGPA(String GPA) {
		this.GPA = GPA;
	}
	public Resume getThisResumeEducationBackground() {
		return thisResumeEducationBackground;
	}
	public void setThisResumeEducationBackground(Resume thisResumeEducationBackground) {
		this.thisResumeEducationBackground = thisResumeEducationBackground;
		if (!thisResumeEducationBackground.getResumeEducationBackgrounds().contains(this)) {
			thisResumeEducationBackground.getResumeEducationBackgrounds().add(this);
		}
	}
}
