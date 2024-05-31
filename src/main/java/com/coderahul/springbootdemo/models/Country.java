package com.coderahul.springbootdemo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@Entity(name = "country")
public class Country {

    @Id
    @SequenceGenerator(name = "country_country_id_seq",
            sequenceName = "country_country_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "country_country_id_seq")
    @Column(name = "country_id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "country")
    private String country;

    @Column(name = "last_update")
    private Date lastUpdate;
}
