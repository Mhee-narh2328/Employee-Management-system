package com.muminat.Employee_management_system.payload.request;

import com.muminat.Employee_management_system.entity.enums.Department;
import com.muminat.Employee_management_system.entity.enums.Roles;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EmployeeRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private double Salary;
    private Department department;
    private Roles roles;

}
