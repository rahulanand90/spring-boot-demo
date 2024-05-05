package com.coderahul.springbootdemo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity(name="country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "country_code", unique = true )
    private String countryCode;

    @Column(name = "country_name", unique = true )
    private String countryName;
}
