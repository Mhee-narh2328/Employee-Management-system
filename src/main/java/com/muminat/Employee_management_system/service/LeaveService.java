package com.muminat.Employee_management_system.service;

import com.muminat.Employee_management_system.entity.Leave;
import com.muminat.Employee_management_system.payload.response.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface LeaveService {
    ResponseEntity<ApiResponse<String>> applyForLeave(Long employeeId, Leave leaveRequest);
}
