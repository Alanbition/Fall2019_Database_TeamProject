package edu.northeastern.cs5200.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.models.Person;

public interface PersonRepositories extends CrudRepository<Person, Integer> {

}
