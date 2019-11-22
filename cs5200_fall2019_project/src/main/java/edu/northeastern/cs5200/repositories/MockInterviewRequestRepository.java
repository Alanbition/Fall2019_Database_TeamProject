package edu.northeastern.cs5200.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.models.MockInterviewRequest;

public interface MockInterviewRequestRepository extends CrudRepository<MockInterviewRequest, Integer>{

}
