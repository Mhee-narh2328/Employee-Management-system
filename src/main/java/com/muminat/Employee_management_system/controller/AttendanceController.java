package com.muminat.Employee_management_system.controller;

import com.muminat.Employee_management_system.entity.enums.AttendanceStatus;
import com.muminat.Employee_management_system.payload.response.ApiResponse;
import com.muminat.Employee_management_system.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee/")
@RequiredArgsConstructor
public class AttendanceController {
    private final AttendanceService attendanceService;

    @PostMapping("attendance/{id}")
    public ResponseEntity<ApiResponse<String>> markAttendance(
            @PathVariable Long id,
            @RequestParam AttendanceStatus status) {
        return attendanceService.markAttendance(id, status);
    }
}
