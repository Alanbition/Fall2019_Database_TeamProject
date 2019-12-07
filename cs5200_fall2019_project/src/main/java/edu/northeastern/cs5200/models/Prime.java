package edu.northeastern.cs5200.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
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
	@MapsId
	private Student thisStudentPrimeService;

	@OneToMany(mappedBy = "prime")
	private List<MockInterviewRequest> MockInterviewRequests;

	@OneToMany(mappedBy = "prime")
	private List<ReferralRequest> ReferralRequests;
	
	
	public Prime() {}
	
	public Prime(Date Duedate, Boolean Autorenew) {
		this.Duedate = Duedate;
		this.Autorenew = Autorenew;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDuedate() {
		return Duedate;
	}

	public void setDuedate(Date duedate) {
		this.Duedate = duedate;
	}

	public Boolean getAutorenew() {
		return Autorenew;
	}

	public void setAutorenew(Boolean autorenew) {
		this.Autorenew = autorenew;
	}

	public Student getThisStudentPrimeService() {
		return thisStudentPrimeService;
	}

	public void setThisStudentPrimeService(Student thisStudentPrimeService) {
		this.thisStudentPrimeService = thisStudentPrimeService;
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