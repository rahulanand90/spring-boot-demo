package com.coderahul.springbootdemo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@Entity(name = "customer")
public class Customer {

    @Id
    @SequenceGenerator(name = "customer_customer_id_seq",
            sequenceName = "customer_customer_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_customer_id_seq")
    @Column(name = "customer_id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "store_id")
    private Integer storeId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(name = "activebool")
    private Boolean activeBool;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "last_update")
    private Date lastUpdate;

    @Column(name = "active")
    private Integer active;

}
