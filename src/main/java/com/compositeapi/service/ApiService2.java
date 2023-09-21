package com.compositeapi.service;

import com.compositeapi.dto.DepartmentDto;
import com.compositeapi.dto.DepartmentResponse;
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
public class ApiService2 {

    private final RestTemplate restTemplate;

    public ApiService2(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    String url = "http://127.0.0.1:8000/department";
    public List<DepartmentResponse> getDataFromService2() {
        ResponseEntity<List<DepartmentDto>> response = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<DepartmentDto>>() {});

        log.info("Returning data from python server for department record: {}", response);
        return Objects.requireNonNull(response.getBody()).stream()
                .map(departmentDto -> {
                    DepartmentResponse departmentResponse = new DepartmentResponse();
                    departmentResponse.setDepartment(departmentDto.getDepartmentName());

                    return departmentResponse;
                })
                .collect(Collectors.toList());
    }
}
