package com.muminat.Employee_management_system.service;

import com.muminat.Employee_management_system.entity.Leave;
import com.muminat.Employee_management_system.entity.enums.LeaveStatus;
import com.muminat.Employee_management_system.payload.response.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface LeaveService {
    ResponseEntity<ApiResponse<>> applyForLeave(Leave leaveRequest);
    ResponseEntity<ApiResponse<String>> updateLeaveStatus(Long employeeId, LeaveStatus status);
//    ResponseEntity<A>
}
