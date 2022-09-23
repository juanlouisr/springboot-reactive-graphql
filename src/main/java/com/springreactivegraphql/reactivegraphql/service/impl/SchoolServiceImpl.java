package com.springreactivegraphql.reactivegraphql.service.impl;

import com.springreactivegraphql.reactivegraphql.entity.dao.School;
import com.springreactivegraphql.reactivegraphql.entity.dto.AddSchoolInput;
import com.springreactivegraphql.reactivegraphql.entity.dto.AddStudentInput;
import com.springreactivegraphql.reactivegraphql.repository.SchoolRepository;
import com.springreactivegraphql.reactivegraphql.service.SchoolService;
import com.springreactivegraphql.reactivegraphql.util.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SchoolServiceImpl implements SchoolService {

  @Autowired
  private SchoolRepository schoolRepository;

  @Override
  public Mono<School> findById(Long id) {
    return schoolRepository.findById(id);
  }

  @Override
  public Mono<School> create(AddSchoolInput schoolInput) {
    return schoolRepository.save(BeanMapper.map(schoolInput, School.class));
  }

  @Override
  public Flux<School> findByName(String name) {
    return schoolRepository.findAllByName(name);
  }

  @Override
  public Flux<School> findAll() {
    return schoolRepository.findAll();
  }
}
