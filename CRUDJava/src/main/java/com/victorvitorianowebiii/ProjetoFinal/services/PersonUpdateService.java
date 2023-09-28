package com.victorvitorianowebiii.ProjetoFinal.services;

import com.victorvitorianowebiii.ProjetoFinal.model.PersonEntity;
import com.victorvitorianowebiii.ProjetoFinal.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonUpdateService {

    @Autowired
    private PersonRepository personRepository;

    public PersonEntity update(PersonEntity personEntity) {
        return this.personRepository.save(personEntity);
    }
}
