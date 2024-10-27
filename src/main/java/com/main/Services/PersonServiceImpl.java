package com.main.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.Entities.Person;
import com.main.Repositories.PersonRepository;


@Service
public class PersonServiceImpl  implements PersonService {
	
	@Autowired
    private PersonRepository personRepository;
	
	// add or  insert
	@Override
	public Person addPerson(Person person) {
		
		return personRepository.save(person);
		
		
	}
	
	//get All user
	@Override
	public List<Person> getAllPerson() {
		return personRepository.findAll();
	}
	
	//get user by id
	@Override
	public Optional<Person> getPersonById(int id) {
		return personRepository.findById(id);
		
	}
	
	//Update person /user
	@Override
	public Person updateperson(int id, Person person) {
		// TODO Auto-generated method stub
		
	Person updateperson= personRepository.findById(id).orElse(null);
	
	if(updateperson != null) {
		
	return	personRepository.save(person);
		
	}
	else {
	new RuntimeException("User not found "+id);
	}
	return updateperson;
	
		
	}

	@Override
	public void deletePersonById(int id) {
		
		personRepository.deleteById(id);
		
		
	}

}
