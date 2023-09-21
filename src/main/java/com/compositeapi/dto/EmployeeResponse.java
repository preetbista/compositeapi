package com.compositeapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class EmployeeResponse implements Serializable {
    private String display;
}
