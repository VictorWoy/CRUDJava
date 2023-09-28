package com.victorvitorianowebiii.ProjetoFinal.controller;

import com.victorvitorianowebiii.ProjetoFinal.model.PersonEntity;
import com.victorvitorianowebiii.ProjetoFinal.repository.PersonRepository;
import com.victorvitorianowebiii.ProjetoFinal.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * @author Victor Vitoriano Woycickoski
 * @since 02/12/2021 17:47
 * @version 1.0
 * @category controller
 */


@RestController
@RequestMapping("/person")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PersonController {

    @Autowired
    private PersonDeleteService personDeleteService;

    @Autowired
    private PersonFindAllService personFindAllService;

    @Autowired
    private PersonFindByIdService personFindByIdService;

    @Autowired
    private PersonSaveService personSaveService;

    @Autowired
    private PersonUpdateService personUpdateService;

    @PostMapping()
    public ResponseEntity<PersonEntity> save(@RequestBody PersonEntity personEntity) {


        return new ResponseEntity<PersonEntity>(
                this.personSaveService.save(personEntity),
                new HttpHeaders(),
                HttpStatus.CREATED
        );
    }

    @GetMapping()
    public ResponseEntity<List<PersonEntity>> findAll() {

        return new ResponseEntity<List<PersonEntity>>(
                this.personFindAllService.findAll(),
                new HttpHeaders(),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<PersonEntity>> findById(@PathVariable("id") long id) {

        return new ResponseEntity<Optional<PersonEntity>>(
                this.personFindByIdService.findById(id),
                new HttpHeaders(),
                HttpStatus.OK
        );
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<HashMap<String, String>> delete(@PathVariable("id") long id) {

        HashMap<String, String> map = new HashMap<>();

        if (this.personDeleteService.deleteById(id)) {

            map.put("success", "true");
            map.put("message", "Excluido com sucesso.");

            return new ResponseEntity(
                    map,
                    new HttpHeaders(),
                    HttpStatus.OK
            );
        }

        map.put("success", "false");
        map.put("message", "Id não encontrado.");


        return new ResponseEntity<HashMap<String, String>>(
                map,
                new HttpHeaders(),
                HttpStatus.NOT_FOUND
        );

    }

    @PutMapping()
    public ResponseEntity<PersonEntity> update(@RequestBody PersonEntity personEntity) {
        return new ResponseEntity<PersonEntity>(
                this.personUpdateService.update(personEntity),
                new HttpHeaders(),
                HttpStatus.CREATED
        );
    }
}
