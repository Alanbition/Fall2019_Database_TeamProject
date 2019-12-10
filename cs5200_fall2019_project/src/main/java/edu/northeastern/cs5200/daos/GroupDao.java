package edu.northeastern.cs5200.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import edu.northeastern.cs5200.models.Employee;
import edu.northeastern.cs5200.models.Group;
import edu.northeastern.cs5200.models.Student;
import edu.northeastern.cs5200.repositories.EmployeeRepository;
import edu.northeastern.cs5200.repositories.GroupRepository;


@Controller("GroupDao")
@Service
public class GroupDao {
	@Autowired
	GroupRepository groupRepository;
	@Autowired
	EmployeeRepository employeeRepository;
	
	public void deleteGroup() {
		groupRepository.deleteAll();
	}
	
	public Group createGroup(Group group) {
		return groupRepository.save(group);
	}
	
	public Group setEmployeeForGroup(Employee employee, Group group) {
		group.setEmployee(employee);
    	employeeRepository.save(employee);
    	return groupRepository.save(group);
    }

    public Group findGroupById(int gid) {
		Group g = (Group) groupRepository.findById(gid).get();
		return g;
    }
    
	public List<Group> findAllGroups(){
		List<Group> groups = (List<Group>) groupRepository.findAll();
		return groups;		
	}    
    
	public Employee getGroupEmployee(Group group) {
		
		return group.getEmployee();
	}
}
