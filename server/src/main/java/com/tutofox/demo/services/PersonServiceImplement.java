package com.tutofox.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutofox.demo.models.City;
import com.tutofox.demo.models.Person;
import com.tutofox.demo.repository.PersonRepository;

@Service("employeeService")
public class PersonServiceImplement implements PersonService {
	
	@Autowired
	private PersonRepository personRepository;
 

	@Override
	public List<Person> getAll() {
		List<Person> listPerson; 
		//listPerson =  personRepository.findAllByEliminado(0);
		listPerson = personRepository.findAll();
		return listPerson; 
	}
	 
	@Override
	public List<City> getAllCity() {
		List<City> listCity; 
		//listPerson =  personRepository.findAllByEliminado(0);
		listCity = personRepository.findAllCity();
		return listCity; 
	}
	
	@Override
	public void save(Person person) {
		personRepository.save(person);
	}
	
	@Override
	public void delete(int id) {
		personRepository.deleteById(id);
	}	 
	@Override 
	public Optional<Person> getPerson(Integer id){
		Optional<Person> employee = personRepository.findById(id);
		return employee;
	}
	 
	@Override 
	public List<Person> validEmail(String email){
		List<Person> listArea; 
		listArea =  personRepository.findByEmail(email);
		return listArea; 
	} 	 
	
	@Override
	public void deleteById(Integer id) {
		personRepository.deleteById(id); 
	} 
 
	
}
