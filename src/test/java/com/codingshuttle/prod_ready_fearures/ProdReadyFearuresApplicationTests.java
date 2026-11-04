package com.codingshuttle.prod_ready_fearures;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codingshuttle.prod_ready_fearures.clients.EmployeeClient;
import com.codingshuttle.prod_ready_fearures.dto.EmployeeDTO;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProdReadyFearuresApplicationTests {

	
	@Autowired
	private EmployeeClient employeeClient;
	
	@Test
	@Order(3) // we use the order annotation If we want to run the testcases to be run in the specified order
	void getAllEmployeesTest() {
		List<EmployeeDTO> employeeDTOList = employeeClient.getAllEmployees();
		System.out.println(employeeDTOList);
	}
	
	@Test
	@Order(2)
	void getEmployeeByIdTest() {
		EmployeeDTO employeeDTO= employeeClient.getEmployeeById(455L);
		System.out.println(employeeDTO);
	}

	@Test
	@Order(1)
	void createNewEmployeeTest() {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setName("TEj");
		employeeDTO.setEmail("tej@gmail.com");
		employeeDTO.setAge(27);
		employeeDTO.setDateOfJoining(LocalDate.of(2026, 06, 29));
		employeeDTO.setRole("USER");
		employeeDTO.setSalary(99999.00);
		employeeDTO.setIsActive(true);
		EmployeeDTO savedEmployee = employeeClient.createNewEmployee(employeeDTO);
		System.out.println(savedEmployee);
	}
}
