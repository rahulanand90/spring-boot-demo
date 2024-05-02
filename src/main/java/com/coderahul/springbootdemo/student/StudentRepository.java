package com.coderahul.springbootdemo.student;

import org.springframework.data.repository.CrudRepository;

// must extend one of three - JpaRepo, PagingRepo, CrudRepo
public interface StudentRepository extends CrudRepository<Student, Long> {
}
