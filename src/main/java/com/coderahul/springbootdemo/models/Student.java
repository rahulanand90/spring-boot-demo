package com.coderahul.springbootdemo.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name = "Student") // name is optional - case-insensitive
@Table(name = "Student", uniqueConstraints = {@UniqueConstraint(name = "email_unique", columnNames = "email")}) //optional
public class Student {

    @Id
    @SequenceGenerator(name = "student_seq",
            sequenceName = "student_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(name = "surname", updatable = false, nullable = false, columnDefinition = "TEXT")
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    // @Nonnull - doesn't work. BEWARE
    @Column(nullable = false)
    private Integer age;

    public Student(String firstName, String lastName, String email, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    public Student() {

    }
}

// Unique might not be cleared/modified. In that case, remove and update again.