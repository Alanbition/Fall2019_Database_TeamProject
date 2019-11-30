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

public class Applied_Job_Lists {
	@Id
	@GeneratedValue
	(strategy=GenerationType.IDENTITY)
	private int id;
	private String job_title;
	private String company;
	@ManyToOne()
	private Student thisStudent_job_applied;
	
	public Applied_Job_Lists() {}
	
	public Applied_Job_Lists(String job_title, String company) {
		this.job_title = job_title;
		this.company = company;
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
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}

	public Student getThisStudent_job_applied() {
		return thisStudent_job_applied;
	}
	public void setthisStudent_job_applied(Student thisStudent_job_applied) {
		this.thisStudent_job_applied =  thisStudent_job_applied;
		if (!thisStudent_job_applied.getJobsApplied_by_thisStudent().contains(this)) {
			thisStudent_job_applied.getJobsApplied_by_thisStudent().add(this);
		}
	}	
}
