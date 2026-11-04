package com.codingshuttle.prod_ready_fearures.clients;

import java.util.List;

import com.codingshuttle.prod_ready_fearures.dto.EmployeeDTO;

public interface EmployeeClient {

	List<EmployeeDTO> getAllEmployees(); 
	
	EmployeeDTO getEmployeeById(Long employeeId);
	
	EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO);
}
