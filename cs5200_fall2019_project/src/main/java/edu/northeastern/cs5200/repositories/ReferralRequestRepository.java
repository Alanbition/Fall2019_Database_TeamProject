package edu.northeastern.cs5200.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.models.ReferralRequest;

public interface ReferralRequestRepository extends CrudRepository<ReferralRequest, Integer>{

}

