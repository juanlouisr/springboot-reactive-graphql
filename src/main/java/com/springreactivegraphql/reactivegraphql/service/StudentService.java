package com.springreactivegraphql.reactivegraphql.service;

import com.springreactivegraphql.reactivegraphql.entity.dao.Student;
import com.springreactivegraphql.reactivegraphql.entity.dto.AddStudentInput;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentService {

  Mono<Student> findById(Long id);

  Mono<Student> create(AddStudentInput studentInput);

  Flux<Student> findAllByName(String name);

  Flux<Student> findAllBySchoolId(Long schoolId);

  Flux<Student> findAll();
}
