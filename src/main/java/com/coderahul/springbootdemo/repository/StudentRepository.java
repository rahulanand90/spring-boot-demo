package com.coderahul.springbootdemo.repository;

import com.coderahul.springbootdemo.models.Student;
import org.springframework.data.repository.CrudRepository;

// must extend one of three - JpaRepo, PagingRepo, CrudRepo
public interface StudentRepository extends CrudRepository<Student, Long> {
}
