package com.example.collectionsskypro.controllers;

import com.example.collectionsskypro.services.PersonService;
import com.example.collectionsskypro.services.impl.PersonServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }
@GetMapping(path = "/person/{id}")
    public String getPerson(@PathVariable("id") Integer id) {
        return personService.getPerson(id);
    }
@GetMapping(path = "/org/person/{id}")
    public String getPersonWithPinCode(@PathVariable("id")Integer id, @RequestParam("pin-code") int pinCode) {
    return personService.getPersonWithPinCode(id, pinCode);

    }
}
