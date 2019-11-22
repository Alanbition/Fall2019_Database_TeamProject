package edu.northeastern.cs5200.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import edu.northeastern.cs5200.models.Employee;
import edu.northeastern.cs5200.models.Group;
import edu.northeastern.cs5200.models.MockInterviewRequest;
import edu.northeastern.cs5200.models.ReferralRequest;
import edu.northeastern.cs5200.repositories.*;

@Controller("EmployeeDao")
@Service
public class EmployeeDao {
	@Autowired
	EmployeeRepository employeeRepository;
	MockInterviewRequestRepository interviewRepository;
	ReferralRequestRepository referralRepository;
	
	public void deleteEmployee() {
		employeeRepository.deleteAll();
	}
	
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public Employee setGroupForEmployee(Employee employee, Group group) {
		employee.setGroup(group);
		employeeRepository.save(employee);
    	return employee;
    }

	public Group getEmployeeManagedGroup(Employee employee) {
		
		return employee.getGroup();
	}
	// TODO: 
	public void receivePayment() {
		
	}
	
	public MockInterviewRequest sendInterviewRequest(MockInterviewRequest req, Employee employee) {
		req.setEmployee(employee); 
		interviewRepository.save(req);
		
		List<MockInterviewRequest> interviewrequests = employee.getMockInterviewRequests();
		interviewrequests.add(req);
		employee.setMockInterviewRequests(interviewrequests);
    	employeeRepository.save(employee);
    	return req;
		
	}
	public MockInterviewRequest approveInterview(MockInterviewRequest req) {
		req.setApproved(true); 
		interviewRepository.save(req);
		return req;
		
	}
	
	public ReferralRequest sendReferralRequest(ReferralRequest req, Employee employee) {
		req.setEmployee(employee); 
		referralRepository.save(req);
		
		List<ReferralRequest> requests = employee.getReferralRequests();
		requests.add(req);
		employee.setReferralRequests(requests);
    	employeeRepository.save(employee);
    	return req;
		
	}
	public ReferralRequest approveReferral(ReferralRequest req) {
		req.setApproved(true); 
		referralRepository.save(req);
		return req;
		
	}
}
