package edu.northeastern.cs5200.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.models.Application;

public interface ApplicationRepository extends CrudRepository<Application, Integer>{

}