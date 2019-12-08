package edu.northeastern.cs5200.controllers;

import java.util.ArrayList;
import java.util.List;

import java.util.Map;
import javax.servlet.http.HttpServletRequest; 
import org.springframework.beans.factory.annotation.Value;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.cs5200.daos.*;
import edu.northeastern.cs5200.models.*;
import edu.northeastern.cs5200.repositories.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginRegisterController {
	@Autowired
	GeneralDao generalDao;
	List<User> users = new ArrayList<User>();
	@RequestMapping("/")
	public String index() {
	     return "register";
	}

	@RequestMapping(value="/redirect", method = RequestMethod.GET)
	public String redirectToLogin() {
	    return "redirect:login";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public void register(@RequestParam("userRole")String userRole, @RequestParam("firstName")String firstName,@RequestParam("lastName")String lastName, @RequestParam("email")String email, @RequestParam("password")String password, HttpSession session){
	//user object will automatically be populated with values sent from browser or jsp page. Provide your authentication logic here
		System.out.println("Start Registration");
		if (userRole.equals("Student")) {
			Student student = new Student(firstName, lastName, email, password, false, false);
			generalDao.createStudent(student);
		}else if(userRole.equals("Employee")){
			Employee employee = new Employee(firstName, lastName, email, password, "", false,"", 0);
			generalDao.createEmployee(employee);
		}else if(userRole.equals("Recruiter")){
			Recruiter recruiter = new Recruiter(firstName, lastName, email, password,false, "", "");
			generalDao.createRecruiter(recruiter);
		}else {
			
		}

		
	} 

    @RequestMapping(value="/login", method=RequestMethod.POST)  
    public String loginUser(@RequestParam("email")String email, @RequestParam("password")String password, HttpSession session)  
    {  
    	return "login";
    } 
    
	@RequestMapping("/api/register")
	public String register(@RequestBody User user,HttpSession session) {
		session.setAttribute("currentUser", user);
		users.add(user);
		return "test";
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
