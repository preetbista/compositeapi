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
public class DepartmentDto implements Serializable {
    @JsonAlias("DepartmentName")
    private String departmentName;

    @JsonAlias("DepartmentId")
    private String departmentId;
}
