package edu.northeastern.cs5200.daos;

import java.util.List;
import java.util.Optional;

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
	public void deleteEmployeeById(int id) {
		employeeRepository.deleteById(id);
	}
	
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public Iterable<Employee> findAllEmployee() {
		return employeeRepository.findAll();
	}
	
	public Employee updateEmployee(int id, Employee employee) {
		Employee e = employeeRepository.findEmployeeById(id);
        e.setEmail(employee.getEmail());
        e.setfirstName(employee.getfirstName());
        e.setLast_name(employee.getLastName());
        e.setPassword(employee.getPassword());
        employeeRepository.save(e);
        return e;
	}
	
	public Employee findEmployeeById(int eid) {
		Employee e = employeeRepository.findEmployeeById(eid);
		return e;
    }

	public Group getEmployeeManagedGroup(Employee employee) {
		
		return employee.getGroup();
	}
	// TODO: 
	public void receivePayment() {
		
	}
	public List<MockInterviewRequest> findAllInterviewRequest(Employee employee) {
		List<MockInterviewRequest> interviewrequests = employee.getMockInterviewRequests();
    	return interviewrequests;
		
	}
	public List<ReferralRequest> findAllReferralRequest(Employee employee) {
		List<ReferralRequest> referralRequests = employee.getReferralRequests();
    	return referralRequests;
		
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
	public MockInterviewRequest reviewInterview(MockInterviewRequest req, Boolean approve) {
		req.setApproved(approve); 
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
	public ReferralRequest reviewReferral(ReferralRequest req, Boolean approve) {
		req.setApproved(approve); 
		referralRepository.save(req);
		return req;
		
	}
	public Employee findEmployeeByCredentials(String email, String password) {
		Employee e = employeeRepository.findEmployeeByCredentials(email, password);
		return e;
	}
}
