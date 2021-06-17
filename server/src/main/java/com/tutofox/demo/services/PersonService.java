package com.tutofox.demo.services;

import java.util.List;
import java.util.Optional;

import com.tutofox.demo.models.City;
import com.tutofox.demo.models.Person;
 

public interface PersonService {
	
	public List<Person> getAll();

	void delete(int id); 
	
	Optional<Person> getPerson(Integer id);

	List<Person> validEmail(String email);

	void save(Person employee);

	public void deleteById(Integer id);

	List<City> getAllCity();
	
}

 