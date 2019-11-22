package edu.northeastern.cs5200.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import edu.northeastern.cs5200.repositories.ApplicationRepository;

@Controller("ApplicationDao")
@Service
public class ApplicationDao {
	@Autowired
	ApplicationRepository applicationRepository;

}
