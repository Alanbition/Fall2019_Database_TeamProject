package edu.northeastern.cs5200.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import edu.northeastern.cs5200.models.Employee;
import edu.northeastern.cs5200.models.Group;
import edu.northeastern.cs5200.repositories.GroupRepository;


@Controller("GroupDao")
@Service
public class GroupDao {
	@Autowired
	GroupRepository groupRepository;
	
	public void deleteGroup() {
		groupRepository.deleteAll();
	}
	
	public Group createGroup(Group group) {
		return groupRepository.save(group);
	}
	
	public Group setEmployeeForGroup(Employee employee, Group group) {
		group.setEmployee(employee);
    	groupRepository.save(group);
    	
    	return group;
    }

	public Employee getGroupEmployee(Group group) {
		
		return group.getEmployee();
	}
}
