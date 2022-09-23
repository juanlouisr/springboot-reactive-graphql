package com.springreactivegraphql.reactivegraphql.entity.dao;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("schools")
public class School {

  @Id
  private Long id;
  private String name;
  @Transient
  private List<Student> students = new ArrayList<>();
}
