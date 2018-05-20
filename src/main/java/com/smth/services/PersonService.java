package com.smth.services;

import com.smth.dto.PersonDTO;
import com.smth.entities.Person;

import java.util.List;

public interface PersonService {

    Person getById(Long id);

    List<Person> listAll();

    Person save(PersonDTO personDTO);

    Person update(PersonDTO personDTO);

    void delete(Long id);
}
