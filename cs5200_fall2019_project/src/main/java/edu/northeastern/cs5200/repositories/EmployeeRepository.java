package edu.northeastern.cs5200.repositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.northeastern.cs5200.models.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
	 @Query("SELECT p FROM Person p WHERE p.username=:username ")
	 public Employee findEmployeeById(@Param("id") int id);

}
