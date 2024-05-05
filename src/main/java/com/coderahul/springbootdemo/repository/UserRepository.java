package com.coderahul.springbootdemo.repository;

import com.coderahul.springbootdemo.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
