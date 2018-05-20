package com.smth.converters;

import com.smth.dto.PersonDTO;
import com.smth.entities.Person;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

@Component
public class PersonDTOToPerson implements Converter<PersonDTO, Person> {

    @Nullable
    @Override
    public Person convert(PersonDTO personDTO) {

        Person person = new Person();
        if (personDTO.getId() != null && !StringUtils.isEmpty(personDTO.getId())) {
            person.setId(new Long(personDTO.getId())); //TODO: check is it OK or not in case of autoincrement
        }
        person.setFirstName(personDTO.getFirstName());
        person.setLastName(personDTO.getLastName());
        person.setMiddleName(personDTO.getMiddleName());
//        person.setBirthDate(personDTO.getBirthDate());
//        person.setComment(personDTO.getComment());
//        person.setUpdateDate(personDTO.getUpdateDate());

        return person;
    }
}
