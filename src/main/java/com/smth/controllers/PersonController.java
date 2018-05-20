package com.smth.controllers;

import com.smth.converters.PersonToPersonDTO;
import com.smth.dto.PersonDTO;
import com.smth.entities.Person;
import com.smth.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class PersonController {

    private PersonService personService;

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping({"/person/list", "/person"})
    public String getPerson(Model model) {
        model.addAttribute("persons", personService.listAll());
        return "person/list";
    }

    @RequestMapping("/person/show/{id}")
    public String getPerson(@PathVariable String id, Model model) {
        model.addAttribute("person", personService.getById(Long.valueOf(id)));
        return "person/show";
    }

    @RequestMapping("/person/new")
    public String newPerson(Model model) {
        model.addAttribute("personDTO", new PersonDTO());
        return "person/personform";
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public String savePerson(@Valid PersonDTO personDTO, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "person/personform";
        }

        Person savedPerson = personService.save(personDTO);
        return "redirect:/person/show/" + savedPerson.getId();
    }

    @RequestMapping("/person/edit/{id}")
    public String updatePerson(@PathVariable String id, Model model) {
        model.addAttribute("personDTO", new PersonToPersonDTO().convert(personService.getById(Long.valueOf(id))));
        return "person/personform";
    }

    @RequestMapping("/person/delete/{id}")
    public String deletePerson(@PathVariable String id) {
        personService.delete(Long.valueOf(id));
        return "redirect:/person/list";
    }
}
