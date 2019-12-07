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
	
	private String description;
	
	private boolean approved;
	
	@ManyToOne
	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}
	public Employee setEmployee(Employee employee) {
		if(!employee.getReferralRequests().contains(this)) {
			employee.getReferralRequests().add(this);
		}
		return employee;
	}
	
	@ManyToOne
	private Prime prime;

	public Prime getPrime() {
		return prime;
	}
	
	public void setStudent(Prime prime) {
		if(!prime.getReferralRequests().contains(this)) {
			prime.getReferralRequests().add(this);
		}
	}

	
	public ReferralRequest() {
	}
	
	public ReferralRequest(String description, boolean approved) {
		this.description = description;
		this.approved = approved;
	}
	

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
	    this.id = id;
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


}
