package edu.northeastern.cs5200.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import edu.northeastern.cs5200.models.Notification;
import edu.northeastern.cs5200.models.Recruiter;
import edu.northeastern.cs5200.models.User;
import edu.northeastern.cs5200.repositories.*;

@Controller("NotificationDao")
@Service
public class NotificationDao {
	@Autowired
	NotificationRepository notificationRepository;
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired 
	RecruiterRepository recruiterRepository;
	
	public void deleteNotification(){
		notificationRepository.deleteAll();
	}
	public Notification createNotification(Notification notification){
		return notificationRepository.save(notification);
	}
}
