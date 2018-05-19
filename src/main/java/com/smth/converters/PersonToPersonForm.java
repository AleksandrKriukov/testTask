package com.smth.converters;

import com.smth.commands.PersonForm;
import com.smth.domain.Person;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PersonToPersonForm implements Converter<Person, PersonForm> {

    @Override
    public PersonForm convert(Person person) {

        PersonForm personForm = new PersonForm();
        personForm.setId(person.getId());
        personForm.setFirstName(person.getFirstName());
        personForm.setLastName(person.getLastName());
        personForm.setMiddleName(person.getMiddle_name());
//        personForm.setBirthDate(person.getBirthDate());
        personForm.setComment(person.getComment());
        personForm.setUpdateDate(person.getUpdateDate());

        return personForm;
    }
}
