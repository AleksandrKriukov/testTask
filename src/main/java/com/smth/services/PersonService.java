package com.smth.services;

import com.smth.entities.Person;

import java.util.List;

public interface PersonService {

    Person getById(Long id);

    List<Person> listAll();
}
