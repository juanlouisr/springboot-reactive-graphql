package com.springreactivegraphql.reactivegraphql.service.impl;

import com.springreactivegraphql.reactivegraphql.entity.dao.Student;
import com.springreactivegraphql.reactivegraphql.entity.dto.AddStudentInput;
import com.springreactivegraphql.reactivegraphql.repository.StudentRepository;
import com.springreactivegraphql.reactivegraphql.service.StudentService;
import com.springreactivegraphql.reactivegraphql.util.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentServiceImpl implements StudentService {

  @Autowired
  private StudentRepository studentRepository;

  @Override
  public Mono<Student> findById(Long id) {
    return studentRepository.findById(id);
  }

  @Override
  public Mono<Student> create(AddStudentInput studentInput) {
    return studentRepository.save(BeanMapper.map(studentInput, Student.class));
  }

  @Override
  public Flux<Student> findAllByName(String name) {
    return studentRepository.findAllByName(name);
  }

  @Override
  public Flux<Student> findAllBySchoolId(Long schoolId) {
    return studentRepository.findAllBySchoolId(schoolId);
  }

  @Override
  public Flux<Student> findAll() {
    return studentRepository.findAll();
  }
}
