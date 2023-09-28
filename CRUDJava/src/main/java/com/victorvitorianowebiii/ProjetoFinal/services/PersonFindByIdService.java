package com.victorvitorianowebiii.ProjetoFinal.services;

import com.victorvitorianowebiii.ProjetoFinal.model.PersonEntity;
import com.victorvitorianowebiii.ProjetoFinal.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonFindByIdService {

    @Autowired
    private PersonRepository personRepository;

    public Optional<PersonEntity> findById(long id) {
            return this.personRepository.findById(id);
    }
}
