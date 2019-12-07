package edu.northeastern.cs5200;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.northeastern.cs5200.daos.*;
import edu.northeastern.cs5200.models.*;
import edu.northeastern.cs5200.repositories.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class projectTestSuite {
	@Autowired
	ApplicationDao applicationDao;
	@Autowired
	EmployeeDao employeeDao;
	@Autowired
	GeneralDao generalDao;
	@Autowired
	GroupDao groupDao;
	@Autowired
	JobDao jobDao;
	@Autowired
	NotificationDao notificationDao;
	@Autowired
	RecruiterDao recuriterDao;
	@Autowired
	StudentDao studentDao;
	@Before
	public void projectTestSuite() {
		System.out.println("IN THE TEST!!!!");
	}
	@Test
	public void validates_users() {
		System.out.println("PASS TEST!!!!");
		
	}
}



