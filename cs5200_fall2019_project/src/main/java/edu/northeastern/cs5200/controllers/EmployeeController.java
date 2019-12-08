package edu.northeastern.cs5200.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.cs5200.daos.EmployeeDao;
import edu.northeastern.cs5200.daos.GeneralDao;
import edu.northeastern.cs5200.models.Employee;
import edu.northeastern.cs5200.models.Group;
import edu.northeastern.cs5200.models.MockInterviewRequest;
import edu.northeastern.cs5200.models.ReferralRequest;
import edu.northeastern.cs5200.repositories.EmployeeRepository;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeDao employeeDao;
	GeneralDao generalDao;
	//EmployeeRepository emloyeeRepository;
	
	@GetMapping("/api/employee/{eid}")
	public Group findEmployeeManagedGroup(@PathVariable("eid") int eid) {
		Employee employee = employeeDao.findEmployeeById(eid);
		Group group = employeeDao.getEmployeeManagedGroup(employee);
		return group;
	}
	
	@GetMapping("/api/employee")
	public Iterable<Employee> findAllEmployee() {
		Iterable<Employee> employees = employeeDao.findAllEmployee();
		return employees;
	}
	@GetMapping("/api/employee/{eid}/mockinterviewrequest")
	public List<MockInterviewRequest> ViewMockInterviewRequests(@PathVariable("eid") int eid) {
		Employee employee = employeeDao.findEmployeeById(eid);
		List<MockInterviewRequest> requests = employeeDao.findAllInterviewRequest(employee);
		return requests;
	}

	// may cause problem or be redundant to have two functions instead of updateMockInterviewrequest
	
	@PutMapping("/api/employee/{eid}/mockinterviewrequest/{mid}")
	public MockInterviewRequest ApproveMockInterviewRequests(@PathVariable("eid") int eid, @PathVariable("mid") int mid) {
		MockInterviewRequest req = generalDao.findMockInterviewRequestById(mid);
		return employeeDao.reviewInterview(req, true);
	}
//	@PutMapping("/api/employee/{eid}/mockinterviewrequest/{mid}")
//	public MockInterviewRequest RejectMockInterviewRequests(@PathVariable("eid") int eid, @PathVariable("mid") int mid) {
//		MockInterviewRequest req = generalDao.findMockInterviewRequestById(mid);
//		return employeeDao.reviewInterview(req, false);
//	}
	@GetMapping("/api/employee/{eid}/referral")
	public List<ReferralRequest> ViewReferralRequests(@PathVariable("eid") int eid) {
		Employee employee = employeeDao.findEmployeeById(eid);
		List<ReferralRequest> requests = employeeDao.findAllReferralRequest(employee);
		return requests;
	}

	@PutMapping("/api/employee/{eid}/referral/{rid}")
	public ReferralRequest ApproveReferralRequests(@PathVariable("eid") int eid, @PathVariable("rid") int rid) {
		ReferralRequest req = generalDao.findReferralRequestById(eid);
		return employeeDao.reviewReferral(req, true);
	}
//	@PutMapping("/api/employee/{eid}/referral/{rid}")
//	public ReferralRequest RejectReferralRequests(@PathVariable("eid") int eid, @PathVariable("rid") int rid) {
//		ReferralRequest req = generalDao.findReferralRequestById(rid);
//		return employeeDao.reviewReferral(req, false);
//	}
	
	@DeleteMapping("/api/employee/{eid}")
    public void deleteEmployee(@PathVariable("eid") int id) {
		employeeDao.deleteEmployeeById(id);
    }
	
	@PutMapping("/api/employee/{eid}")
	public Employee updateEmployee(@PathVariable("eid") int id, @RequestBody Employee e) {
		Employee employee = employeeDao.updateEmployee(id, e);
		return employee;
    }
	
	@PostMapping("/api/employee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeDao.createEmployee(employee);
    }

	//TODO: notification and login-register
	
}
