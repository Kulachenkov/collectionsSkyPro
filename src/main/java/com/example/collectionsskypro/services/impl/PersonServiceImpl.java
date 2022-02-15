package com.example.collectionsskypro.services.impl;

import com.example.collectionsskypro.data.Person;
import com.example.collectionsskypro.exceptions.NoAccessToPersonException;
import com.example.collectionsskypro.exceptions.WrongPinCodeException;
import com.example.collectionsskypro.services.PersonService;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    int pinCode = 1234;

    Person[] persons = {
            new Person("Oleg Khlebushek", true),
            new Person("Anna Makaronina", false),
            new Person("Bulat Bursak", false),
            new Person("Igor Karamelka", false),
            new Person("Pahlava Ivanova", true)
    };

    @Override
    public String getPerson(Integer id) {
            if(persons.length > id) {
                try {
                    return getPersonWithoutPinCode(id);
                } catch (NoAccessToPersonException e) {
                    return "You do not have an access to this person ";
                }
            } else {
                return "This person does not exist.";
            }
    }

    @Override
    public String getPersonWithPinCode(Integer id, int pinCode) {
        if (this.pinCode == pinCode) {
            return persons[id].getName();
        }else{
            throw new WrongPinCodeException();
        }

    }

    private String getPersonWithoutPinCode(Integer id) throws NoAccessToPersonException {
        Person person = persons[id];
        if (person.isBlock()) {
            throw new NoAccessToPersonException();
        }
        return person.getName();
    }
}
