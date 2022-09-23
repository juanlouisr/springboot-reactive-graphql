package com.springreactivegraphql.reactivegraphql.controller;

import com.springreactivegraphql.reactivegraphql.entity.dao.School;
import com.springreactivegraphql.reactivegraphql.entity.dao.Student;
import com.springreactivegraphql.reactivegraphql.entity.dto.AddSchoolInput;
import com.springreactivegraphql.reactivegraphql.entity.dto.AddStudentInput;
import com.springreactivegraphql.reactivegraphql.service.SchoolService;
import com.springreactivegraphql.reactivegraphql.service.StudentService;
import java.time.Duration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Controller
public class GraphQLController {

  @Autowired
  private SchoolService schoolService;

  @Autowired
  private StudentService studentService;


  @SchemaMapping(typeName = "Mutation", field = "addStudent")
  public Mono<Student> addStudent(@Argument AddStudentInput addStudentInput) {
    return studentService.create(addStudentInput);
  }

  @MutationMapping
  public Mono<School> addSchool(@Argument AddSchoolInput addSchoolInput) {
    return schoolService.create(addSchoolInput);
  }

  @QueryMapping
  public Flux<Student> studentByName(@Argument String studentName) {
    return studentService.findAllByName(studentName);
  }

  @QueryMapping
  public Flux<School> schoolByName(@Argument String schoolName) {
    return schoolService.findByName(schoolName);
  }

  @QueryMapping
  public Flux<School> allSchool() {
    return schoolService.findAll();
  }

  @SchemaMapping(typeName = "School")
  public Flux<Student> students(School school) {
    log.info("get all students for school id " + school.getId());
    return studentService.findAllBySchoolId(school.getId());
  }

//  @BatchMapping
//  public Mono<Map<School, Collection<Student>>> students(List<School> schools) {
//    return Flux.fromIterable(schools)
//        .flatMap(school -> this.studentService.findBySchoolId(school.getId()))
//        .collectMultimap(student -> schools.stream()
//            .filter(school -> school.getId().equals(student.getSchoolId())).findFirst().get());
//  }

  @SubscriptionMapping
  public Flux<Student> allStudent() {
    return this.studentService.findAll().delayElements(Duration.ofSeconds(2));
  }

}
