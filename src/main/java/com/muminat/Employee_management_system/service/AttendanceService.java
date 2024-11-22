package com.muminat.Employee_management_system.service;

import com.muminat.Employee_management_system.entity.enums.AttendanceStatus;
import com.muminat.Employee_management_system.entity.enums.Reasons;
import com.muminat.Employee_management_system.payload.response.ApiResponse;
import com.muminat.Employee_management_system.payload.response.AttendanceResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AttendanceService {
    ResponseEntity<ApiResponse<String>> markAttendance(Long employeeId, AttendanceStatus status, Reasons reasons);
    ResponseEntity<ApiResponse<List<AttendanceResponse>>> getAllAttendance();
}
