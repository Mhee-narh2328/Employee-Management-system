package com.muminat.Employee_management_system.service;

import com.muminat.Employee_management_system.entity.Leave;
import com.muminat.Employee_management_system.entity.enums.LeaveStatus;
import com.muminat.Employee_management_system.payload.request.LeaveRequest;
import com.muminat.Employee_management_system.payload.response.ApiResponse;
import com.muminat.Employee_management_system.payload.response.LeaveResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LeaveService {
    ResponseEntity<ApiResponse<LeaveResponse>> applyForLeave(Long employeeId, LeaveRequest request);
    ResponseEntity<ApiResponse<LeaveResponse>> updateLeaveStatus(Long id, LeaveStatus status);
    ResponseEntity<ApiResponse<List<LeaveResponse>>> getAllLeaves();
}
