package com.coderahul.springbootdemo.repositories;

import com.coderahul.springbootdemo.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface CountryRepository extends JpaRepository<Country, UUID> {
    public boolean existsById(UUID id);
}
