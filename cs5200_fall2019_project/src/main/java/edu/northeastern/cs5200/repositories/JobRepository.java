package edu.northeastern.cs5200.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.models.Job;

public interface JobRepository extends CrudRepository<Job, Integer>{

}