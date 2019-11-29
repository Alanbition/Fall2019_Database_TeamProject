package edu.northeastern.cs5200.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import edu.northeastern.cs5200.models.notifications;
import edu.northeastern.cs5200.repositories.*;

@Controller("NotificationDao")
@Service
public class Notificationdao {
	@Autowired
	NotificationRepository NotificationRepository;
	
	public  Notification sendNotification (notifications req, Person person) {
		req.setPerson(person); 
		NotificationRepository.save(req);
		
		List<Notification > Notification  = person.getNotification();
		Notification.add(req);
		person.setNotification(Notification);
		NotificationRepository.save(person);
    	return req;
		
	}
	public Notification receiveNotification(notifications req) {
		req.setReceived(true); 
		NotificationRepository.save(req);
		return req;
		
	}

}
