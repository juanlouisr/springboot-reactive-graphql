package com.springreactivegraphql.reactivegraphql.service;

import com.springreactivegraphql.reactivegraphql.entity.dao.School;
import com.springreactivegraphql.reactivegraphql.entity.dto.AddSchoolInput;
import com.springreactivegraphql.reactivegraphql.entity.dto.AddStudentInput;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SchoolService {

  Mono<School> findById(Long id);

  Mono<School> create(AddSchoolInput schoolInput);

  Flux<School> findByName(String name);

  Flux<School> findAll();
}
