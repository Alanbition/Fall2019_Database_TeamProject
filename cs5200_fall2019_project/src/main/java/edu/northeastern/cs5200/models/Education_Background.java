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
public class Education_Background {
	@Id
	@GeneratedValue
	(strategy=GenerationType.IDENTITY)
	private int id;
	private String university;
	private String degree;
	private String major;
	private Date start_date;
	private Date end_date;
	@ManyToOne()
	private Resume this_resume_education_background;
	
	public Education_Background() {}
	
	public Education_Background(String university, String degree, String major, Date start_date, Date end_date) {
		this.university = university;
		this.degree = degree;
		this.major = major;
		this.start_date = start_date;
		this.end_date = end_date;
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
	
	public Resume getThis_resume_education_background() {
		return this_resume_education_background;
	}
	public void setThis_resume_education_background(Resume this_resume_education_background) {
		this.this_resume_education_background = this_resume_education_background;
		if (!this_resume_education_background.getResume_education_backgrounds().contains(this)) {
			this_resume_education_background.getResume_education_backgrounds().add(this);
		}
	}
}
