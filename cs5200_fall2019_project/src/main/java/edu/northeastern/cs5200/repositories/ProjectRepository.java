package edu.northeastern.cs5200.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.models.Project;

public interface ProjectRepository extends CrudRepository<Project, Integer>{

}