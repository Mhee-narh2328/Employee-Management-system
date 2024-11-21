package com.muminat.Employee_management_system.entity;

import com.muminat.Employee_management_system.entity.enums.Department;
import com.muminat.Employee_management_system.entity.enums.Roles;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "employee_tbl")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends BaseClass {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private double salary;

    @Enumerated(EnumType.STRING)
    private Department department;

    @Enumerated(EnumType.STRING)
    private Roles roles;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Attendance> attendances;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Leave> leaveRequests;


}
