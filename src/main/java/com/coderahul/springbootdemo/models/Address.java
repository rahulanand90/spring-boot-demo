package com.coderahul.springbootdemo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@Entity(name = "address")
public class Address {

    @Id
    @SequenceGenerator(name = "address_address_id_seq",
            sequenceName = "address_address_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_address_id_seq")
    @Column(name = "address_id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "address")
    private String address;

    @Column(name = "address2")
    private String address2;

    @Column(name = "district")
    private String district;

    @Column(name = "city_id")
    private Integer cityId;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "phone")
    private String phone;

    @Column(name = "last_update")
    private Date lastUpdate;

}
