package com.codingshuttle.prod_ready_fearures.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeDTO {

	private Long id;

	private String name;

	private String email;
	
	private Integer age;
	
	private String role;
	
	private LocalDate dateOfJoining;

	private Boolean isActive;

	private Double salary;
	
	
}
