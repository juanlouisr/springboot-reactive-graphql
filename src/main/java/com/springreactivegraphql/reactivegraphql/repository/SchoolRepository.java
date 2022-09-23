package com.springreactivegraphql.reactivegraphql.repository;

import com.springreactivegraphql.reactivegraphql.entity.dao.School;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface SchoolRepository extends ReactiveCrudRepository<School, Long> {
  Flux<School> findAllByName(String name);
}
