package com.muminat.Employee_management_system.service.impl;

import com.muminat.Employee_management_system.entity.Attendance;
import com.muminat.Employee_management_system.entity.Employee;
import com.muminat.Employee_management_system.entity.enums.AttendanceStatus;
import com.muminat.Employee_management_system.payload.response.ApiResponse;
import com.muminat.Employee_management_system.respository.AttendanceRepository;
import com.muminat.Employee_management_system.respository.EmployeeRespository;
import com.muminat.Employee_management_system.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {
    private final EmployeeRespository employeeRespository;
    private final AttendanceRepository attendanceRepository;
    @Override
    public ResponseEntity<ApiResponse<String>> markAttendance(Long employeeId, AttendanceStatus status) {
        Optional<Employee> employeeOpt = employeeRespository.findById(employeeId);
        if (employeeOpt.isEmpty()) {
            throw new RuntimeException("Employee not found");
        }

        Employee employee = employeeOpt.get();

        Attendance attendance = Attendance.builder()
                .attendanceStatus(status)
                .employee(employee)
                .build();

        attendanceRepository.save(attendance);
        return ResponseEntity.ok(new ApiResponse<>("Attendance marked successfully", null));
    }

}
