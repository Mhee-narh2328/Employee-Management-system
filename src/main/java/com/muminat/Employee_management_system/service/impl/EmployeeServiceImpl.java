package com.muminat.Employee_management_system.service.impl;

import com.muminat.Employee_management_system.entity.Employee;
import com.muminat.Employee_management_system.entity.enums.Department;
import com.muminat.Employee_management_system.entity.enums.Roles;
import com.muminat.Employee_management_system.payload.request.EmployeeRequest;
import com.muminat.Employee_management_system.payload.response.ApiResponse;
import com.muminat.Employee_management_system.payload.response.EmployeeResponse;
import com.muminat.Employee_management_system.respository.EmployeeRespository;
import com.muminat.Employee_management_system.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private  final EmployeeRespository employeeRespository;

    @Override
    public ResponseEntity<ApiResponse<EmployeeResponse>> registerEmployee(EmployeeRequest request) {
        boolean isEmailPresent = employeeRespository.existsByEmail(request.getEmail());

        if (isEmailPresent){
            throw new RuntimeException("Email already exist");
        }

        Employee newEmployee = Employee.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(request.getPassword())
                .salary(request.getSalary())
                .department(Department.IT)
                .roles(Roles.USER)
                .build();

        employeeRespository.save(newEmployee);

        EmployeeResponse response = EmployeeResponse.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .salary(request.getSalary())
                .department(Department.IT)
                .roles(Roles.USER)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("Account Created Successfully", response));

    }

    @Override
    public ResponseEntity<ApiResponse<List<EmployeeResponse>>> getAllEmployees() {
        List<EmployeeResponse> employees = employeeRespository.findAll()
                .stream()
                .map(this::mapToEmployeeResponse)
                .collect(Collectors.toList());

        return  ResponseEntity.ok(new ApiResponse<>("All employees retrieved successfully", employees));
    }

    @Override
    public ResponseEntity<ApiResponse<EmployeeResponse>> getEmployeeById(Long id) {
        Employee employee = employeeRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        EmployeeResponse response = mapToEmployeeResponse(employee);
        return ResponseEntity.ok(new ApiResponse<>("Employee Retrieved successfully", response));
    }

    @Override
    public ResponseEntity<ApiResponse<EmployeeResponse>> updateEmployee(Long id, EmployeeRequest request) {
        Employee employee = employeeRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        // Update fields
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setEmail(request.getEmail());
        employee.setSalary(request.getSalary());
        employee.setDepartment(request.getDepartment());
        employee.setRoles(request.getRoles());

        employeeRespository.save(employee);

        EmployeeResponse response = mapToEmployeeResponse(employee);
        return ResponseEntity.ok(new ApiResponse<>("Employee updated successfully", response));

    }

    @Override
    public ResponseEntity<ApiResponse<String>> deleteEmployee(Long id) {
        if (!employeeRespository.existsById(id)) {
            throw new RuntimeException("Employee not found");
        }

        employeeRespository.deleteById(id);
        return ResponseEntity.ok(new ApiResponse<>("Employee deleted successfully", null));
    }

    private EmployeeResponse mapToEmployeeResponse(Employee employee) {
        return EmployeeResponse.builder()
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .salary(employee.getSalary())
                .department(employee.getDepartment())
                .roles(employee.getRoles())
                .build();
    }
}
