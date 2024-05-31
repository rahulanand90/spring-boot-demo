package com.coderahul.springbootdemo.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "city")
public class City {

    @Id
    @SequenceGenerator(name = "city_city_id_seq",
            sequenceName = "city_city_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_city_id_seq")
    @Column(name = "city_id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "city")
    private String city;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id", referencedColumnName = "country_id")
    private Country countryId;

    @Column(name = "last_update")
    private Date lastUpdate;

}
