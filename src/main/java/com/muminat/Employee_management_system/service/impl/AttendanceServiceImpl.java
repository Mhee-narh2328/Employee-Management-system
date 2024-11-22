package com.muminat.Employee_management_system.service.impl;

import com.muminat.Employee_management_system.entity.Attendance;
import com.muminat.Employee_management_system.entity.Employee;
import com.muminat.Employee_management_system.entity.enums.AttendanceStatus;
import com.muminat.Employee_management_system.entity.enums.Reasons;
import com.muminat.Employee_management_system.payload.response.ApiResponse;
import com.muminat.Employee_management_system.payload.response.AttendanceResponse;
import com.muminat.Employee_management_system.payload.response.EmployeeResponse;
import com.muminat.Employee_management_system.respository.AttendanceRepository;
import com.muminat.Employee_management_system.respository.EmployeeRespository;
import com.muminat.Employee_management_system.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {
    private final EmployeeRespository employeeRespository;
    private final AttendanceRepository attendanceRepository;
    @Override
    public ResponseEntity<ApiResponse<String>> markAttendance(Long employeeId, AttendanceStatus status, Reasons reasons) {
        Optional<Employee> employeeOpt = employeeRespository.findById(employeeId);
        if (employeeOpt.isEmpty()) {
            throw new RuntimeException("Employee not found");
        }

        Employee employee = employeeOpt.get();

        Attendance attendance = Attendance.builder()
                .attendanceStatus(status)
                .reasons(reasons)
                .employee(employee)
                .build();

        attendanceRepository.save(attendance);
        return ResponseEntity.ok(new ApiResponse<>("Attendance marked successfully", null));
    }

    @Override
    public ResponseEntity<ApiResponse<List<AttendanceResponse>>> getAllAttendance() {
        List<AttendanceResponse> attendance = attendanceRepository.findAll()
                .stream()
                .map(this::mapToAttendanceResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new ApiResponse<>("All attendances retrieved successfully", attendance));

    }

    private AttendanceResponse mapToAttendanceResponse(Attendance attendance) {
        return AttendanceResponse.builder()
                .attendanceStatus(attendance.getAttendanceStatus())
                .reasons(attendance.getReasons())
                .build();
    }

}
