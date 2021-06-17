package com.tutofox.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tutofox.demo.models.City;
import com.tutofox.demo.models.Person;
import com.tutofox.demo.services.PersonService;
 
@RestController
@CrossOrigin(origins = "*", methods= { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT })
@RequestMapping("/api/person")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@GetMapping(value="/city")
	public List<City> listJob(){
		List<City> listCity;
		listCity = personService.getAllCity(); 
		return listCity;
	}
	
	@GetMapping(value="/")
	public List<Person> list(){
		  
		List<Person> listPerson = null; 
		
		try {  
			
			listPerson = personService.getAll(); 
			return listPerson;
			
		} catch (Exception e) {   
			System.out.print(e.getMessage());
			return listPerson;
		} 
	}  
	
	@PostMapping(value="/")
	public Map<String, Object> create(@RequestBody Person data){
		
		HashMap<String, Object> response = new HashMap<String, Object>();
		  
		
		try {
			System.out.print("Resultado de datos 221 \n");  
			 
			
			List<Person> validEmailExist = personService.validEmail(data.getEmail());
			
			 
			if(validEmailExist.size()>=1) { 
				System.out.print("Ya se encuentra registrado el correo \n");
				response.put("message", "El correo ya se encuentra registrado.");
				response.put("success", false); 
			}
			else { 

				System.out.print("Continua el proceso \n");
				personService.save(data);
				response.put("message", "Guardó exitosamente!");
				response.put("success", true); 
			}   
			return response;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("Error 3094883 \n");
			System.out.print(e.getMessage());
			response.put("message", e.getMessage());
			response.put("success",false);
			return response;
		}
		
	}
	
	@GetMapping(value = "{id}" )
	public Optional<Person> get(@PathVariable("id") Integer id){
		 
		Optional<Person> person = null;
		
		try {    
			person = personService.getPerson(id);   
			return person;
			
		} catch (Exception e){ 
			//response.put("message",""+e.getMessage()); 
			System.out.print(e.getMessage());
			return person;
		}
	}
	 
	@PutMapping(value = "{id}" )
	public Map<String, Object> update(@RequestBody Person data, @PathVariable("id") Integer id){
		
		HashMap<String, Object> response = new HashMap<String, Object>();
		
		try {
			System.out.print("Resultado de datos 356 \n");  
			//System.out.print("eL ID ES "+data.getId());  
			data.setId(id);
			personService.save(data);
			response.put("message", "actualizó exitosamente!");
			response.put("success", true); 
			return response;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("Error 3094883 \n");
			System.out.print(e.getMessage());
			response.put("message", e.getMessage());
			response.put("success",false);
			return response;
		}
		
	}
	
	@DeleteMapping(value="/{id}")
	public Map<String, Object> update(@PathVariable("id") Integer id){
		
		HashMap<String, Object> response = new HashMap<String, Object>();
		
		try {  
			personService.deleteById(id);;
			response.put("message","Successful deleted"); 
			response.put("success", true);
			return response; 
		} catch (Exception e) {
			response.put("message",e.getMessage()); 
			response.put("success", false);
			return response;
		}
		
	}
	
	
}
