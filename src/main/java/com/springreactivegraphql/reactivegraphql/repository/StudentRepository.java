package com.springreactivegraphql.reactivegraphql.repository;

import com.springreactivegraphql.reactivegraphql.entity.dao.Student;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface StudentRepository extends ReactiveCrudRepository<Student, Long> {
  Flux<Student> findAllByName(String name);
  Flux<Student> findAllBySchoolId(Long id);
}
