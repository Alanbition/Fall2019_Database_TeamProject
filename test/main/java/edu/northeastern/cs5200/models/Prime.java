package edu.northeastern.cs5200.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Prime {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date Duedate;
	private Boolean Autorenew;

	@OneToOne
	private Student student;

	@OneToMany(mappedBy = "prime")
	private Group group;

	@OneToMany(mappedBy = "prime")
	private List<MockInterviewRequest> MockInterviewRequests;

	@OneToMany(mappedBy = "prime")
	private List<ReferralRequest> ReferralRequests;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDuedate() {
		return duedate;
	}

	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}

	public Boolean getAutorenew() {
		return autorenew;
	}

	public void setAutorenew(Boolean autorenew) {
		this.autorenew = autorenew;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
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