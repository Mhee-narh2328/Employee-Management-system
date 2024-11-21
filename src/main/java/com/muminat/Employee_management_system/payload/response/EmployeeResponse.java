package com.muminat.Employee_management_system.payload.response;

import com.muminat.Employee_management_system.entity.enums.Department;
import com.muminat.Employee_management_system.entity.enums.Roles;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EmployeeResponse {
    private String firstName;
    private String lastName;
    private String email;
    private double salary;
    private Department department;
    private Roles roles;
}
