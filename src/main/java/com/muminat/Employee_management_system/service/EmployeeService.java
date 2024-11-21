package com.muminat.Employee_management_system.service;

import com.muminat.Employee_management_system.payload.request.EmployeeRequest;
import com.muminat.Employee_management_system.payload.response.ApiResponse;
import com.muminat.Employee_management_system.payload.response.EmployeeResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {

    ResponseEntity<ApiResponse<EmployeeResponse>> registerEmployee(EmployeeRequest request);
    ResponseEntity<ApiResponse<List<EmployeeResponse>>> getAllEmployees();
    ResponseEntity<ApiResponse<EmployeeResponse>> getEmployeeById(Long id);
    ResponseEntity<ApiResponse<EmployeeResponse>> updateEmployee(Long id, EmployeeRequest request);
    ResponseEntity<ApiResponse<String>> deleteEmployee(Long id);
}
