package com.smth.controllers;

import com.smth.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonController {

    private PersonService personService;

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping("/person/show/{id}")
    public String getPerson(@PathVariable String id, Model model) {
        model.addAttribute("person", personService.getById(Long.valueOf(id)));
        return "person/show";
    }
}
