package com.muminat.Employee_management_system.service;

import com.muminat.Employee_management_system.entity.enums.AttendanceStatus;
import com.muminat.Employee_management_system.payload.response.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface AttendanceService {
    ResponseEntity<ApiResponse<String>> markAttendance(Long employeeId, AttendanceStatus status);
}
