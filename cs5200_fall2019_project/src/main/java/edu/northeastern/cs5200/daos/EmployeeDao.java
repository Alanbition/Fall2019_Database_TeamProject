package edu.northeastern.cs5200.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import edu.northeastern.cs5200.models.Employee;
import edu.northeastern.cs5200.models.Group;
import edu.northeastern.cs5200.repositories.EmployeeRepository;

@Controller("EmployeeDao")
@Service
public class EmployeeDao {
	@Autowired
	EmployeeRepository employeeRepository;
	
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
}
