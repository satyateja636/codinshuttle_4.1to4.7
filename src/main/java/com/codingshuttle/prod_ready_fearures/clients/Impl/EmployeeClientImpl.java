package com.codingshuttle.prod_ready_fearures.clients.Impl;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.codingshuttle.prod_ready_fearures.advice.ApiResponse;
import com.codingshuttle.prod_ready_fearures.clients.EmployeeClient;
import com.codingshuttle.prod_ready_fearures.dto.EmployeeDTO;
import com.codingshuttle.prod_ready_fearures.exceptions.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeClientImpl implements EmployeeClient {

	private final RestClient restClient;

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		try {
			ApiResponse<List<EmployeeDTO>> employeeDTOList = restClient.get().uri("employees/getAllEmployees")
					.retrieve().body(new ParameterizedTypeReference<>() {
					});
			return employeeDTOList.getData();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public EmployeeDTO getEmployeeById(Long employeeId) {
		try {
			ApiResponse<EmployeeDTO> employeeResponse = restClient.get().uri("/employees/{employeeId}", employeeId)
					.retrieve().body(new ParameterizedTypeReference<>() {
					});
			return employeeResponse.getData();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	@Override
	public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
		try {
			ResponseEntity<ApiResponse<EmployeeDTO>> savedEmployee = restClient.post().uri("/employees").body(employeeDTO).retrieve()
					.onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
						System.out.println(new String("Error Occureds" + res.getBody().readAllBytes()));
						throw new ResourceNotFoundException("could not create the emloyee");
					}).toEntity(new ParameterizedTypeReference<>() {
					});
			return savedEmployee.getBody().getData();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
