package com.main.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.Entities.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{

}
