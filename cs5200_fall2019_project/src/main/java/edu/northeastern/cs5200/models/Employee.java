package edu.northeastern.cs5200.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Employee extends Person{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;

	private String bankAccount;
	private String jobTitle;
	private int activePoint;
	
	@OneToOne( mappedBy = "employee")
	private Group group;

	@OneToMany(mappedBy = "employee")
	private List<MockInterviewRequest> MockInterviewRequests;
	
	@OneToMany(mappedBy = "employee")
	private List<ReferralRequest> ReferralRequests;

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

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public List<MockInterviewRequest> getMockInterviewRequests() {
		return MockInterviewRequests;
	}

	public void setMockInterviewRequests(List<MockInterviewRequest> mockInterviewRequests) {
		MockInterviewRequests = mockInterviewRequests;
	}

	public List<ReferralRequest> getReferralRequests() {
		return ReferralRequests;
	}

	public void setReferralRequests(List<ReferralRequest> referralRequests) {
		ReferralRequests = referralRequests;
	}
	
	

}
