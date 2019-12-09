package edu.northeastern.cs5200.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.northeastern.cs5200.models.Student;
import edu.northeastern.cs5200.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
