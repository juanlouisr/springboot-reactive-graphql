package com.springreactivegraphql.reactivegraphql.entity.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("students")
public class Student {

  @Id
  private Long id;
  private String name;
  @Column("school_id")
  private Long schoolId;
}
