package com.smth.converters;

import com.smth.commands.PersonForm;
import com.smth.domain.Person;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

@Component
public class PersonFormToPerson implements Converter<PersonForm, Person> {

    @Nullable
    @Override
    public Person convert(PersonForm personForm) {

        Person person = new Person();
        if (personForm.getId() != null && !StringUtils.isEmpty(personForm.getId())) {
            person.setId(new Long(personForm.getId()));
        }
        person.setFirstName(personForm.getFirstName());
        person.setLastName(personForm.getLastName());
        person.setMiddleName(personForm.getMiddleName());
//        person.setBirthDate(personForm.getBirthDate());
        person.setComment(personForm.getComment());
        person.setUpdateDate(personForm.getUpdateDate());

        return person;
    }
}
