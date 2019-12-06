package edu.northeastern.cs5200.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import edu.northeastern.cs5200.repositories.PrimeRepository;

@Controller("PrimeDao")
@Service
public class PrimeDao {
	@Autowired
	PrimeRepository primeRepository;

	public PrimeRepository getPrimeRepository() {
		return primeRepository;
	}

	public void setPrimeRepository(PrimeRepository primeRepository) {
		this.primeRepository = primeRepository;
	}

}
