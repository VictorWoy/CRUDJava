package com.victorvitorianowebiii.ProjetoFinal.services;

import com.victorvitorianowebiii.ProjetoFinal.model.PersonEntity;
import com.victorvitorianowebiii.ProjetoFinal.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonSaveService {

    @Autowired
    private PersonRepository personRepository;

    public PersonEntity save(PersonEntity personEntity) {
        if (personEntity.getName().length() >3) {
            return this.personRepository.save(personEntity);
        }
        return null;
    }
}
