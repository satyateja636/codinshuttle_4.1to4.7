package com.codingshuttle.prod_ready_fearures.clients.Impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	Logger log = LoggerFactory.getLogger(EmployeeClientImpl.class);

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		log.trace("Trying to retrieve all employees in getAllEmployees");
		try {
			log.info("Attempting to call the restClient method in getAllEmployees");
			ApiResponse<List<EmployeeDTO>> employeeDTOList = restClient.get().uri("employees/getAllEmployees")
					.retrieve().onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
						log.error(new String("Error Occureds" + res.getBody().readAllBytes()));
						throw new ResourceNotFoundException("could not create the emloyee");
					}).body(new ParameterizedTypeReference<>() {
					});
			log.debug("Successfully retrieved the employees in getAllEmployees");
			log.trace("Retrieved employees list in getAllEmployees : {}", employeeDTOList.getData());
			return employeeDTOList.getData();
		} catch (Exception e) {
			log.error("Exception occured in getAllEmployees", e);
			throw new RuntimeException(e);
		}
	}

	@Override
	public EmployeeDTO getEmployeeById(Long employeeId) {
		log.trace("Trying to retrieve all employees in getEmployeeById with id : {}", employeeId);
		try {
			ApiResponse<EmployeeDTO> employeeResponse = restClient.get().uri("/employees/{employeeId}", employeeId)
					.retrieve().body(new ParameterizedTypeReference<>() {
					});
			return employeeResponse.getData();
		} catch (Exception e) {
			log.error("Exception occured in getEmployeeById", e);
			throw new RuntimeException();
		}
	}

	@Override
	public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
		log.trace("Trying to create employee in getEmployeeById with information : {}", employeeDTO);

		try {
			ResponseEntity<ApiResponse<EmployeeDTO>> employeeDTOApiResponse = restClient.post().uri("/employees").body(employeeDTO).retrieve()
					.onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
						System.out.println(new String("Error Occureds" + res.getBody().readAllBytes()));
						throw new ResourceNotFoundException("could not create the emloyee");
					}).toEntity(new ParameterizedTypeReference<>() {
					});
			log.trace("Successfully created a new emoloyee : {}", employeeDTOApiResponse);
			return employeeDTOApiResponse.getBody().getData();
		} catch (Exception e) {
			log.error("Exception occured in createNewEmployee", e);
			throw new RuntimeException(e);
		}
	}

}
