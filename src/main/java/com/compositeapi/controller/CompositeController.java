package com.compositeapi.controller;

import com.compositeapi.dto.DepartmentResponse;
import com.compositeapi.dto.EmployeeResponse;
import com.compositeapi.service.ApiService1;
import com.compositeapi.service.ApiService2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/composite")
public class CompositeController {
    private final ApiService1 apiService1;
    private final ApiService2 apiService2;

    public CompositeController(ApiService1 apiService1, ApiService2 apiService2) {
        this.apiService1 = apiService1;
        this.apiService2 = apiService2;
    }

    @GetMapping("/data")
    public ResponseEntity<?> getCompositeData() {
        List<EmployeeResponse> dataFromService1 = apiService1.getDataFromService1();
        List<DepartmentResponse> dataFromService2 = apiService2.getDataFromService2();

        Map<String, Object> responseData = new HashMap<>();
        responseData.put("employeeService", dataFromService1);
        responseData.put("departmentService", dataFromService2);

        return ResponseEntity.ok(responseData);
    }
}
