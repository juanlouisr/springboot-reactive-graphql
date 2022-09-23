package com.springreactivegraphql.reactivegraphql.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddStudentInput {
  private String name;
  private Long schoolId;
}
