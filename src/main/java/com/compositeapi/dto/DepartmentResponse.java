package com.compositeapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class DepartmentResponse implements Serializable {
    private String department;
}
