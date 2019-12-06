package edu.northeastern.cs5200.controllers;

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
import edu.northeastern.cs5200.models.Employee;
import edu.northeastern.cs5200.models.Group;
import edu.northeastern.cs5200.repositories.EmployeeRepository;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeDao employeeDao;
	//EmployeeRepository emloyeeRepository;
	
	@GetMapping("api/employee/{eid}")
	public Group findEmployeeManagedGroup(@PathVariable("eid") int eid) {
		Employee employee = employeeDao.findEmployeeById(eid);
		Group group = employeeDao.getEmployeeManagedGroup(employee);
		return group;
	}
	
	@GetMapping("api/employee")
	public Iterable<Employee> findAllEmployee() {
		Iterable<Employee> employees = employeeDao.findAllEmployee();
		return employees;
	}
	
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
    public Employee createUser(@RequestBody Employee employee) {
        return employeeDao.createEmployee(employee);
    }
	//@PostMapping("register")
	@GetMapping("/api/employee/login")
    public Employee loginUser(@RequestParam("email") String email, @RequestParam("password") String password) {
        return employeeDao.findEmployeeByCredentials(email, password);
    }
}