package edu.northeastern.cs5200;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.northeastern.cs5200.daos.ApplicationDao;
import edu.northeastern.cs5200.daos.EmployeeDao;
import edu.northeastern.cs5200.daos.GeneralDao;
import edu.northeastern.cs5200.daos.GroupDao;
import edu.northeastern.cs5200.daos.JobDao;
import edu.northeastern.cs5200.daos.NotificationDao;
import edu.northeastern.cs5200.daos.RecruiterDao;
import edu.northeastern.cs5200.models.Employee;
import edu.northeastern.cs5200.models.Recruiter;

@SpringBootApplication
public class Cs5200Fall2019ProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(Cs5200Fall2019ProjectApplication.class, args); 
	}

}
