package com.victorvitorianowebiii.ProjetoFinal.services;

import com.victorvitorianowebiii.ProjetoFinal.model.PersonEntity;
import com.victorvitorianowebiii.ProjetoFinal.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonFindAllService {

    @Autowired
    private PersonRepository personRepository;

    public List<PersonEntity> findAll() {
        return(List<PersonEntity>) this.personRepository.findAll();
    }
}

