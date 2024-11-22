package com.muminat.Employee_management_system.service.impl;

import com.muminat.Employee_management_system.entity.Employee;
import com.muminat.Employee_management_system.entity.Leave;
import com.muminat.Employee_management_system.entity.enums.LeaveStatus;
import com.muminat.Employee_management_system.payload.response.ApiResponse;
import com.muminat.Employee_management_system.respository.EmployeeRespository;
import com.muminat.Employee_management_system.respository.LeaveRepository;
import com.muminat.Employee_management_system.service.LeaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LeaveServiceImpl implements LeaveService {
    private final EmployeeRespository employeeRespository;
    private final LeaveRepository leaveRepository;
    @Override
    public ResponseEntity<ApiResponse<String>> applyForLeave(Long employeeId, Leave leaveRequest) {
        Optional<Employee> employee = employeeRespository.findById(employeeId);
        if (employee.isEmpty()) {
            throw new RuntimeException("Employee not found");
        }

        leaveRequest.setEmployee(employee.get());
        leaveRequest.setStatus(LeaveStatus.PENDING);

        leaveRepository.save(leaveRequest);
        return ResponseEntity.ok(new ApiResponse<>("Leave request submitted successfully", null));
    }
}
