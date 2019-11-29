package edu.northeastern.cs5200.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Employee extends Person{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;

	private String bankAccount;
	private String jobTitle;
	private int activePoint;
	
	@OneToMany( mappedBy = "employee")
	private List<Group> groups;


	public Employee() {}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
	    this.id = id;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public int getActivePoint() {
		return activePoint;
	}

	public void setActivePoint(int activePoint) {
		this.activePoint = activePoint;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
	
	

}
