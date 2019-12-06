package edu.northeastern.cs5200.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity

public class Notification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String message;
	private Date time;
	private String senderType;
	private String receiverType;

	@ManyToOne()
	private Recruiter thisRecruiterNotifications;
	@ManyToOne()
	private Student thisStudentNotifications;
	@ManyToOne()
	private Employee thisEmployeeNotifications;	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getSenderType() {
		return senderType;
	}
	public void setSenderType(String senderType) {
		this.senderType = senderType;
	}
	public String getReceiverTyoe() {
		return receiverType;
	}
	public void setReceiverType(String receiverType) {
		this.receiverType = receiverType;
	}

	//Many To One for recruiter
	public Recruiter getThisRecruiterNotifications() {
		return thisRecruiterNotifications;
	}
	public void setThisRecruiterNotifications(Recruiter thisRecruiterNotifications) {
		this.thisRecruiterNotifications =  thisRecruiterNotifications;
		if (!thisRecruiterNotifications.getNotificationsForRecruiter().contains(this)) {
			thisRecruiterNotifications.getNotificationsForRecruiter().add(this);
		}
	}

	//Many To One for student
	public Student getThisStudentNotifications() {
		return thisStudentNotifications;
	}
	public void setThisStudentNotifications(Student thisStudentNotifications) {
		this.thisStudentNotifications =  thisStudentNotifications;
		if (!thisStudentNotifications.getNotificationsForStudent().contains(this)) {
			thisStudentNotifications.getNotificationsForStudent().add(this);
		}
	}

	//Many To One for employee
	public Employee getThisEmployeeNotifications() {
		return thisEmployeeNotifications;
	}
	public void setThisEmployeeNotifications(Employee thisEmployeeNotifications) {
		this.thisEmployeeNotifications =  thisEmployeeNotifications;
		if (!thisEmployeeNotifications.getNotificationsForEmployee().contains(this)) {
			thisEmployeeNotifications.getNotificationsForEmployee().add(this);
		}
	}
	
}
