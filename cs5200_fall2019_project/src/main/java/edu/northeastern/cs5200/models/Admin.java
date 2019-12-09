package edu.northeastern.cs5200.models;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Admin extends User{


	public Admin() {
		super();
	}
	

	public Admin(String firstName, String lastName, String password, String email, String userDtype) {
		super(firstName, lastName, password, email, userDtype);
	}

	
}
