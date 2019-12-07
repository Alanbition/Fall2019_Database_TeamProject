package edu.northeastern.cs5200.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class MockInterviewRequest {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;

	private String description;
	
	private boolean approved;
	
	@ManyToOne()
	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
		if(!employee.getMockInterviewRequests().contains(this)) {
			employee.getMockInterviewRequests().add(this);
		}
	}
	
	@ManyToOne()
	private Prime prime;

	public Prime getPrime() {
		return prime;
	}
	public void setPrime(Prime prime) {
		this.prime = prime;
		if(!prime.getMockInterviewRequests().contains(this)) {
			prime.getMockInterviewRequests().add(this);
		}
	}
	
	
	public MockInterviewRequest() {
	}
	
	public MockInterviewRequest(String description, boolean approved) {
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
