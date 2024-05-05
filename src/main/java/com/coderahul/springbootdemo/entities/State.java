package com.coderahul.springbootdemo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
@Entity(name="state")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "state_code", unique = true )
    private String stateCode;
    @Column(name = "state_name", unique = true )
    private String stateName;
}
