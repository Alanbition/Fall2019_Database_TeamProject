package edu.northeastern.cs5200.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.northeastern.cs5200.models.Admin;
import edu.northeastern.cs5200.models.User;

public interface AdminRepository extends CrudRepository<Admin, Integer> {

}