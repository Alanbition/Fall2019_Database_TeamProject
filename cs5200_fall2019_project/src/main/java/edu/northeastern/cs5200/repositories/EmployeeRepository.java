package edu.northeastern.cs5200.repositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.northeastern.cs5200.models.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
	 @Query("SELECT * FROM Employee p WHERE p.id=:id ")
	 public Employee findEmployeeById(@Param("id") int id);

	 @Query("SELECT * FROM Employee p WHERE p.email=:email AND p.pass=:pass ")
	 public Employee findEmployeeByCredentials(@Param("email") String email, @Param("pass") String pass);

}
