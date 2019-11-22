package edu.northeastern.cs5200.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ReferralRequest {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;

	private int student_id;
	
	private String description;
	
	private boolean approved;
	
	@ManyToOne
	private Employee employee;
	
	public ReferralRequest(int student_id, String description) {
		this.student_id=student_id;
		this.description = description;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
	    this.id = id;
	}
	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
