package com.capstonebackend.managementuserservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApprovalModuleDTO {
    private Long id;
    private String uuid;
    private String name;
    private String explain;
}
