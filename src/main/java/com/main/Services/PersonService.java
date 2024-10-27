package com.main.Services;

import java.util.List;
import java.util.Optional;

import com.main.Entities.Person;

public interface PersonService {
	public Person addPerson(Person person);  // insert /create
	public List<Person> getAllPerson();      // getAll list
	public Optional<Person> getPersonById(int id);  // get person by id
	
	public Person updateperson(int  id , Person person);  //update 
	
	public void deletePersonById(int id);

}
