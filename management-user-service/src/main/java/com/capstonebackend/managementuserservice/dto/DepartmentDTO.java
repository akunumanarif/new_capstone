package com.capstonebackend.managementuserservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class DepartmentDTO {
    private Long id;
    private String uuid;
    private String code;
    private String name;
}
