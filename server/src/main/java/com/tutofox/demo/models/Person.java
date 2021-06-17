package com.tutofox.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "persona")
public class Person {

	// TODO- Generate Getters and Setter of all the fields 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "email")
	private String email;
	 
	@Column(name = "phone")
	private Long phone;
	
	//@Column(name = "ciudad")
	//private Integer city;

	public Integer getId() {
		return id;
	}	
			
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	 
	public Person(Integer id, String name, String lastname, String email, Long phone, City city) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
		this.city = city;
	} 
	
	
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private City city;
 

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	/*
 

	public Integer getCity() {
		return city;
	}

	public void setCity(Integer city) {
		this.city = city;
	}
	*/

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}	

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}
	 
	 
  
}