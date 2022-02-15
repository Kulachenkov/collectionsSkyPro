package com.example.collectionsskypro.services;

public interface PersonService {
    String getPerson(Integer id);

    String getPersonWithPinCode(Integer id, int pinCode);
}
