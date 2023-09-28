package com.victorvitorianowebiii.ProjetoFinal.services;

import com.victorvitorianowebiii.ProjetoFinal.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonDeleteService {

    @Autowired
    private PersonRepository personRepository;


    public boolean deleteById(long id) {
        if (this.personRepository.existsById(id)) {
            this.personRepository.deleteById(id);
            return true;
        }
        return false;

    }
}
