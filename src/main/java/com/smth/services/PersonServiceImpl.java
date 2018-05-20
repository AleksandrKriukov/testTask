package com.smth.services;

import com.smth.converters.PersonDTOToPerson;
import com.smth.dto.PersonDTO;
import com.smth.entities.Person;
import com.smth.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;
    private PersonDTOToPerson personDTOToPerson;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, PersonDTOToPerson personDTOToPerson) {
        this.personRepository = personRepository;
        this.personDTOToPerson = personDTOToPerson;
    }

    @Override
    public Person getById(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public List<Person> listAll() {
        List<Person> persons = new ArrayList<>();
        personRepository.findAll().forEach(persons::add);
        return persons;
    }

    private Person save(Person person) {
        personRepository.save(person);
        return person;
    }

    @Override
    public Person save(PersonDTO personDTO) {
        Person person = personDTOToPerson.convert(personDTO);
        if (person.getId() == null) {
            person.setId(generateId());
        }
        return save(person);
    }

    @Override
    public Person update(PersonDTO personDTO) {
        Person updatedPerson = save(personDTOToPerson.convert(personDTO));
        return updatedPerson;
    }

    @Override
    public void delete(Long id) {
        personRepository.deleteById(id);
    }

    private Long generateId() {

        List<Long> usedIds = getSortedIds();
        for (int i = 1; i < usedIds.size() + 1; i++) {
            if (usedIds.get(i - 1) != i) {
                return new Long(i);
            }
        }

        return new Long(usedIds.size() + 1);
    }

    private List<Long> getSortedIds() {

        List<Person> persons = listAll();
        List<Long> usedIds = new ArrayList<>();
        for (Person person : persons) {
            usedIds.add(person.getId());
        }
        Collections.sort(usedIds);

        return usedIds;
    }
}
