package edu.northeastern.cs5200.controllers;

import java.util.ArrayList;
import java.util.List;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.cs5200.daos.*;
import edu.northeastern.cs5200.models.*;
import edu.northeastern.cs5200.repositories.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginRegisterController {
	@Autowired
	GeneralDao generalDao;
	@Autowired
	UserDao userDao;
	@Autowired
	StudentDao studentDao;
	@Autowired
	EmployeeDao employeeDao;
	@Autowired
	RecruiterDao recruiterDao;
	@Autowired
	GroupDao groupDao;
	
	List<User> users = new ArrayList<User>();
	@RequestMapping("/")
	public String index() {
	     return "register";
	}


	@RequestMapping(value="/student",method = RequestMethod.GET)
	public String welcomeStudent(HttpServletRequest request, HttpSession session) {
		System.out.println("/student");
		User currentUser = (User) session.getAttribute("currentUser");
		
		//model.addAttribute("message", currentUser.getEmail());
		//model.addAttribute("test", "Goodbye Word");findGroupsForStudent
		Student thisStudent = studentDao.findStudentById(currentUser.getId());
		List<Application> applications = studentDao.findApplicationsForStudent(thisStudent);
		List<Group> groups = studentDao.findGroupsForStudent(thisStudent);
		List<Resume> resumes = studentDao.findResumesForStudent(thisStudent);
		List<Employee> employees = new ArrayList<Employee>();
		for (Group group: groups) {
			employees.add(groupDao.getGroupEmployee(group));		
		}
		request.setAttribute("employees", employees);
		request.setAttribute("applications", applications);
		request.setAttribute("groups", groups);
		request.setAttribute("resumes", resumes);		
		request.setAttribute("firstName", currentUser.getFirstName());
		request.setAttribute("lastName", currentUser.getLastName());
	    return "student";
	}

	@RequestMapping(value="/addActivePoints",method = RequestMethod.POST)
	public String addActivePoints(HttpServletRequest request, HttpSession session) {
		System.out.println("/addActivePoints");
		User currentUser = (User) session.getAttribute("currentUser");
	   	String id = request.getParameter("id");
		request.setAttribute("employees", employeeDao.findAllEmployee());
		if (id != null) {
			Employee thisEmployee = employeeDao.findEmployeeById(Integer.parseInt(id));
			employeeDao.addPointsToEmployee(thisEmployee);
			return "redirect:student";
		}	  
	    return "addActivePoints";
	}

	@RequestMapping(value="/addGroup",method = RequestMethod.POST)
	public String addGroup(HttpServletRequest request, HttpSession session) {
		System.out.println("/addGroup");
		User currentUser = (User) session.getAttribute("currentUser");
	   	String groupId = request.getParameter("groupId");
		request.setAttribute("groups", groupDao.findAllGroups());
		if (groupId != null) {
			Group thisGroup = groupDao.findGroupById(Integer.parseInt(groupId));
			Student thisStudent = studentDao.findStudentById(currentUser.getId());
			studentDao.enrollStudentToGroup(thisGroup, thisStudent);
			return "redirect:student";
		}	  
	    return "addGroup";
	}
	
	@RequestMapping(value="/employee",method = RequestMethod.GET)
	public String welcomeEmployee(HttpServletRequest request, HttpSession session) {
		System.out.println("/employee");
		User currentUser = (User) session.getAttribute("currentUser");
		Employee thisEmployee = employeeDao.findEmployeeById(currentUser.getId());		
		Group group = employeeDao.getEmployeeManagedGroup(thisEmployee);
		if (group != null) {
			List<Student> students = studentDao.findStudentsInGroup(group);	
			request.setAttribute("students", students);
		}
		request.setAttribute("points", thisEmployee.getActivePoint());
		request.setAttribute("group", group);
		request.setAttribute("firstName", currentUser.getFirstName());
		request.setAttribute("lastName", currentUser.getLastName());
	    return "employee";
	}
	
	@RequestMapping(value="/createGroup",method = RequestMethod.POST)
	public String createGroup(HttpServletRequest request, HttpSession session) {
		System.out.println("/createGroup");
		User currentUser = (User) session.getAttribute("currentUser");
	   	String groupName = request.getParameter("groupName");
	   	String activePoint = request.getParameter("activePoint");		
		if (groupName != null) {
			Group group = new Group(groupName, Integer.parseInt(activePoint));
			Group thisGroup = generalDao.createGroup(group);
			Employee thisEmployee = employeeDao.findEmployeeById(currentUser.getId());
			groupDao.setEmployeeForGroup(thisEmployee, thisGroup);
			return "redirect:employee";
		}	  
	    return "createGroup";
	}

	@RequestMapping(value="/recruiter",method = RequestMethod.GET)
	public ModelAndView welcomeRecruiter(HttpServletRequest request, HttpSession session) {
		System.out.println("/recruiter");
		User currentUser = (User) session.getAttribute("currentUser");
		
		//model.addAttribute("message", currentUser.getEmail());
		//model.addAttribute("test", "Goodbye Word");
		
	    ModelAndView model = new ModelAndView("recruiter");
	    model.addObject("firstName", currentUser.getFirstName());
	    model.addObject("lastName", currentUser.getLastName());


	    
	    return model;
	}
	
	@RequestMapping(value="/admin",method = RequestMethod.GET)
	public String welcomeAdmin(Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("/admin");
		User currentUser = (User) session.getAttribute("currentUser");
		List<User> users = userDao.findAllUsers();
		//model.addAttribute("message", currentUser.getEmail());
		//model.addAttribute("test", "Goodbye Word");
		
	    //ModelAndView modelN = new ModelAndView("admin");
		request.setAttribute("users", users);
		request.setAttribute("firstName", currentUser.getFirstName());
		request.setAttribute("lastName", currentUser.getLastName());
	    //modelN.addObject("users", users);
	    //modelN.addObject("firstName", currentUser.getFirstName());
	    //modelN.addObject("lastName", currentUser.getLastName());
	    return "admin";//modelN;
	}
	
	@RequestMapping(value="/updateuser",method = RequestMethod.POST)
	public String updateUser(Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("/updateUser");
	   	String id = request.getParameter("id");	
	   	String userRole = request.getParameter("userRole");
	   	String firstName = request.getParameter("firstName");
    	String lastName = request.getParameter("lastName");		
	   	String email = request.getParameter("email");
    	String password = request.getParameter("password");		
		if (userRole != null && userRole.equals("Student")) {
			Student student = new Student(firstName, lastName, password, email, userRole, false, false);
			studentDao.updateStudent(Integer.parseInt(id), student);
			return "redirect:admin";
		}else if(userRole != null && userRole.equals("Employee")){
			Employee employee = new Employee(firstName, lastName, password, email, userRole,  "", false,"", 0);
			employeeDao.updateEmployee(Integer.parseInt(id), employee);
			return "redirect:admin";
		}else if(userRole != null && userRole.equals("Recruiter")){
			Recruiter recruiter = new Recruiter(firstName, lastName, password, email, userRole, false, "", "");
			recruiterDao.updateRecruiter(Integer.parseInt(id), recruiter);
			return "redirect:admin";
		}
		//model.addAttribute("message", currentUser.getEmail());
		//model.addAttribute("test", "Goodbye Word");
		return "updateuser";
	}

	@RequestMapping(value="/deleteuser",method = RequestMethod.POST)
	public String adminDeleteUser(Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("/deleteuser");
	   	String id = request.getParameter("id");	
	   	if(id != null){
	   		userDao.deleteUserById(Integer.parseInt(id));
			return "redirect:admin";
	   	}
	   	return "deleteuser";
	}
	
    @RequestMapping(value="/createuser", method = RequestMethod.POST)
    public String createUser(Model model, HttpServletRequest request, HttpSession session)  
    { 
    	String userRole = request.getParameter("userRole");
    	String firstName = request.getParameter("firstName");
    	String lastName = request.getParameter("lastName");
    	String email = request.getParameter("email");
    	String password = request.getParameter("password");
		System.out.println("createser");
		System.out.println(userRole);
		if (userRole != null && userRole.equals("Student")) {
			Student student = new Student(firstName, lastName, password, email, userRole, false, false);
			generalDao.createStudent(student);
			return "redirect:admin";
		}else if(userRole != null && userRole.equals("Employee")){
			Employee employee = new Employee(firstName, lastName, password, email, userRole,  "", false,"", 0);
			generalDao.createEmployee(employee);
			return "redirect:admin";
		}else if(userRole != null && userRole.equals("Recruiter")){
			Recruiter recruiter = new Recruiter(firstName, lastName, password,email,  userRole, false, "", "");
			generalDao.createRecruiter(recruiter);
			return "redirect:admin";
		}else if(userRole != null && userRole.contentEquals("Admin")){
			Admin admin = new Admin(firstName, lastName, password, email, userRole);
			generalDao.createAdmin(admin);
			return "redirect:admin";
		}
    	return "createuser";
    }
/*
	@RequestMapping(value="/createuser",method = RequestMethod.POST)
	public String adminCreateUser(Model model, HttpServletRequest request, HttpSession session) {

	   	String userRole = request.getParameter("userRole");
	   	String firstName = request.getParameter("firstName");
    	String lastName = request.getParameter("lastName");		
	   	String email = request.getParameter("email");
    	String password = request.getParameter("password");	
		System.out.println("createuser");
		System.out.println(userRole);
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(email);
		System.out.println(password);
		if (userRole.equals("Student")) {
			Student student = new Student(firstName, lastName, email, password, userRole, false, false);
			generalDao.createStudent(student);
			return "redirect:admin";
		}else if(userRole.equals("Employee")){
			Employee employee = new Employee(firstName, lastName, email, password, userRole,  "", false,"", 0);
			generalDao.createEmployee(employee);
			return "redirect:admin";
		}else if(userRole.equals("Recruiter")){
			Recruiter recruiter = new Recruiter(firstName, lastName, email, password, userRole, false, "", "");
			generalDao.createRecruiter(recruiter);
			return "redirect:admin";
		}else if(userRole.contentEquals("Admin")){
			Admin admin = new Admin(firstName, lastName, email, password, userRole);
			generalDao.createAdmin(admin);
			return "redirect:admin";
		}
		return "createuser";
	}
	*/
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String register(HttpServletRequest request,HttpSession session){
	//user object will automatically be populated with values sent from browser or jsp page. Provide your authentication logic here
		System.out.println("Start Registration");
    	String userRole = request.getParameter("userRole");
    	String firstName = request.getParameter("firstName");
    	String lastName = request.getParameter("lastName");
    	String email = request.getParameter("email");
    	String password = request.getParameter("password");
		if (userRole != null && userRole.equals("Student")) {
			Student student = new Student(firstName, lastName, password, email, userRole, false, false);
			generalDao.createStudent(student);
			session.setAttribute("currentUser", student);
			return "redirect:student";
		}else if(userRole != null && userRole.equals("Employee")){
			Employee employee = new Employee(firstName, lastName, password, email, userRole,  "", false,"", 0);
			generalDao.createEmployee(employee);
			session.setAttribute("currentUser", employee);
			return "redirect:employee";
		}else if(userRole != null && userRole.equals("Recruiter")){
			Recruiter recruiter = new Recruiter(firstName, lastName, password, email, userRole, false, "", "");
			generalDao.createRecruiter(recruiter);
			session.setAttribute("currentUser", recruiter);
			return "redirect:recruiter";
		}else if(userRole != null && userRole.contentEquals("Admin")){
			Admin admin = new Admin(firstName, lastName, password, email, userRole);
			generalDao.createAdmin(admin);
			session.setAttribute("currentUser", admin);
			return "redirect:admin";
		}
		//if (request.getParameter("login")!= null){
			//return "redirect:login";
		//}
		//System.out.println(request.getParameterNames());
		return "register";
	} 

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String loginUser(Model model, HttpServletRequest request, HttpSession session)  
    { 
    	String email = request.getParameter("email");
    	String password = request.getParameter("password");
		System.out.println("login");
		List<User> users = (List<User>) userDao.findAllUsers();
		for (User user: users) {
			if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
				session.setAttribute("currentUser", user);
				String userRole = user.getUserDtype();
				if (userRole.equals("Student")) {
					return "redirect:student";
				}else if(userRole.equals("Employee")){
					return "redirect:employee";
				}else if(userRole.equals("Recruiter")){
					return "redirect:recruiter";
				}else if(userRole.contentEquals("Admin")){
					return "redirect:admin";
				}
			}
		}
    	return "login";
    } 
    
	@RequestMapping("/logout")
	public String requestLogout(HttpSession session) {
		session.invalidate();
		return "register";
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
