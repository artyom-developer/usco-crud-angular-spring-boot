package com.tutofox.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tutofox.demo.models.City;
import com.tutofox.demo.models.Person;

 
@Repository("employeeRepository")
public interface PersonRepository extends JpaRepository<Person, Integer> {
  

	List<Person> findByEmail(String email);
  
	@Query("from City")
	List<City> findAllCity();
 
}