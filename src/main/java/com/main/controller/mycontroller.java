package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.Entities.Person;
import com.main.Services.PersonService;
@RestController
public class mycontroller {
	
	@Autowired
	private  PersonService personService;

	//+++++++++++++++++Crate/Insert++++++++++++++++++++++++++++++++++++
	@PostMapping("/person")
	public Person AddPersonDetail(@RequestBody Person person) {
		
		//personService.addPerson(person);
		return 	personService.addPerson(person);
		
	}
	//+++++++++++++++++++FindAll++++++++++++++++++++++++++++++++++++++==
	@GetMapping("/person")
public List<Person> getAllpersonDetail() {
	return personService.getAllPerson();
}
	
	//+++++++++++++ FindAllbyID ++++++++++++++++++++++++++++++
	
	@GetMapping("/person/{id}")
	public ResponseEntity<Person> getPerson(@PathVariable int id ) {
		Person person =personService.getPersonById(id).orElse(null);
		if(person != null) {
			
			return ResponseEntity.ok().body(person);
			
		}
		else {
			return ResponseEntity.notFound().build();
					
		}
	}
		
		@PutMapping("/person/{id}")
		public ResponseEntity<Person> updatepersondetail(@PathVariable int id , @RequestBody Person person ) {
			
			Person updatedperson= personService.updateperson(id, person);
			
			if(updatedperson != null) {
				
			return	ResponseEntity.ok(updatedperson);
				
			}
			else {
			return 	ResponseEntity.notFound().build();
			}
		
		}
		
		@DeleteMapping("/person/{id}")
		public ResponseEntity<String> DeletepersonbyId(@PathVariable int  id){
			personService.deletePersonById(id);
			 return ResponseEntity.ok("Deleted  Successfully");
			//return ResponseEntity.noContent().build();
			
		}
		
	}


