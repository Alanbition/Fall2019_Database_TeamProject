//Ruoyun
package edu.northeastern.cs5200.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Employee extends User{
	private String bankAccount;
	private String jobTitle;
	private Boolean verified;
	private Integer activePoint;
	
	

	@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL,fetch = FetchType.LAZY, optional = false)
	private Group group;

	@OneToMany(mappedBy = "employee")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<MockInterviewRequest> MockInterviewRequests;
	
	@OneToMany(mappedBy = "employee")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<ReferralRequest> ReferralRequests;
	
	
	//For notification OneToMany	
	@OneToMany (mappedBy = "thisEmployeeNotifications")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Notification> notificationsForEmployee;

	public void notificationsForEmployee(Notification nots) {
		this.notificationsForEmployee.add(nots);
		if (nots.getThisEmployeeNotifications() != this)
			nots.setThisEmployeeNotifications(this);
	}

	public List<Notification> getNotificationsForEmployee(){
		return notificationsForEmployee;
	}
	
	public void setNotificationsForEmployee(List<Notification> notificationsForEmployee) {
		this.notificationsForEmployee = notificationsForEmployee;
	}

	//

	public Employee() {
		super();
	}
	

	public Employee(String firstName, String lastName, String password, String email, String bankAccount, Boolean verified,
			String jobTitle, Integer activePoint) {
		super(firstName, lastName, password, email);
		this.bankAccount = bankAccount;
		this.verified = verified;
		this.jobTitle = jobTitle;
		this.activePoint = activePoint;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public Boolean getVerified() {
		return verified;
	}

	public void setVerified(Boolean verified) {
		this.verified = verified;
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
