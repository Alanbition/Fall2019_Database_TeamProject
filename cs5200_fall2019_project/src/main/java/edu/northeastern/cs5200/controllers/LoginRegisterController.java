package edu.northeastern.cs5200.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.cs5200.daos.RecruiterDao;
import edu.northeastern.cs5200.models.*;
import edu.northeastern.cs5200.repositories.*;
public class LoginRegisterController {
	List<User> users = new ArrayList<User>();
	@PostMapping("/api/register")
	public User register(@RequestBody User user,HttpSession session) {
		session.setAttribute("currentUser", user);
		users.add(user);
		return user;
	}

	@GetMapping("/api/profile")
	public User profile(HttpSession session) {
		User currentUser = (User)
		session.getAttribute("currentUser");	
	return currentUser;
	}

	@PostMapping("/api/logout")
	public void logout(HttpSession session) {
		session.invalidate();
	}

	@PostMapping("/api/login")
	public User login(	@RequestBody User credentials,HttpSession session) {
	 for (User user : users) {
	  if( user.getEmail().equals(credentials.getEmail())
	   && user.getPassword().equals(credentials.getPassword())) {
	    session.setAttribute("currentUser", user);
	    return user;
	  }
	 }
	 return null;
	}

}
