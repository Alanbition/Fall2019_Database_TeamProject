package edu.northeastern.cs5200.repositories;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;


import edu.northeastern.cs5200.models.Prime;

public interface PrimeRepository extends CrudRepository<Prime, Integer>{
	public default Date findDuedateForPrime(Prime prime) {
		
		return prime.getDuedate();
	}
	
	public default Boolean findAutorenewForPrime(Prime prime) {
		
		return prime.getAutorenew();
	}

}
