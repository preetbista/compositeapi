package com.compositeapi.service;

import com.compositeapi.dto.EmployeeDto;
import com.compositeapi.dto.EmployeeResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ApiService1 {

    String url = "http://127.0.0.1:8000/employee";

    private final  RestTemplate restTemplate;

    public ApiService1(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<EmployeeResponse> getDataFromService1() {
        ResponseEntity<List<EmployeeDto>> response = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<EmployeeDto>>() {});

        log.info("Returning data from python server for employee record: {}", response);
        return Objects.requireNonNull(response.getBody()).stream()
                .map(employeeDto -> {
                    EmployeeResponse employeeResponse = new EmployeeResponse();
                        employeeResponse.setDisplay(employeeDto.getEmployeeName()
                                .concat(" [").concat(employeeDto.getDepartment()).concat("]"));
                return employeeResponse;
                })
                .collect(Collectors.toList());
    }

}
