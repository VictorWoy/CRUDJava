package com.victorvitorianowebiii.ProjetoFinal.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Victor Vitoriano Woycickoski
 * @since 02/12/2021 17:22
 * @version 1.0
 * @category controller
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HelloWorldController {

    @GetMapping("/")
    public ResponseEntity<String> index() {
        return new ResponseEntity<String>(
                "Seja bem vindo ao servidor da DearStage",
                new HttpHeaders(),
                HttpStatus.OK
        );
    }

}
