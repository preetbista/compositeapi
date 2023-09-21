package com.compositeapi.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeDto implements Serializable {

    @JsonAlias("EmployeeId")
    private String employeeId;

    @JsonAlias("EmployeeName")
    private String employeeName;

    @JsonAlias("DateofJoining")
    private String dateOfJoining;

    @JsonAlias("Department")
    private String department;

    @JsonAlias("PhotoFileName")
    private String photoFileName;
}
