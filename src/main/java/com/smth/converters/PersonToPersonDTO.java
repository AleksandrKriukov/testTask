package com.smth.converters;

import com.smth.dto.PersonDTO;
import com.smth.entities.Person;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PersonToPersonDTO implements Converter<Person, PersonDTO> {

    @Override
    public PersonDTO convert(Person person) {

        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(person.getId());
        personDTO.setFirstName(person.getFirstName());
        personDTO.setLastName(person.getLastName());
        personDTO.setMiddleName(person.getMiddleName());
        personDTO.setBirthDate(person.getBirthDate());
        personDTO.setComment(person.getComment());
        personDTO.setUpdateDate(person.getUpdateDate());

        return personDTO;
    }
}
