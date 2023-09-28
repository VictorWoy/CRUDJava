package com.victorvitorianowebiii.ProjetoFinal.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * @author Victor Vitoriano Woycickoski
 * @since 02/12/2021 17:35
 * @version 1.0
 * @category model
 */

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Component

@Entity
@Table(name = "person")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "idolgroup")
    private String idolGroup;

    @Column(name = "height")
    private double height;

    @Column(name = "age")
    private int age;

    @Column(name = "birthplace")
    private String birthplace;
}
