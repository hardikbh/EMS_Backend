package com.restfulapi.ems.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data // generate getter setter methods  constructor as a boiler plate
@Entity // it specify this class is a JPA entity
@Table(name="employees")   // it specify the table in the database with which this entity is mapped.
public class Employee {
	@Id // specify the primary key of the entity
	@GeneratedValue(strategy = GenerationType.IDENTITY) // define startegy for the primary key
	private long id;
	
	@Column(name="first_name")// it map database filed ex table column with class property
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
