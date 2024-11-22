package com.muminat.Employee_management_system.service.impl;

import com.muminat.Employee_management_system.entity.Employee;
import com.muminat.Employee_management_system.entity.Leave;
import com.muminat.Employee_management_system.entity.enums.LeaveStatus;
import com.muminat.Employee_management_system.payload.request.LeaveRequest;
import com.muminat.Employee_management_system.payload.response.ApiResponse;
import com.muminat.Employee_management_system.payload.response.LeaveResponse;
import com.muminat.Employee_management_system.respository.EmployeeRespository;
import com.muminat.Employee_management_system.respository.LeaveRepository;
import com.muminat.Employee_management_system.service.LeaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LeaveServiceImpl implements LeaveService {
    private final EmployeeRespository employeeRespository;
    private final LeaveRepository leaveRepository;

    @Override
    public ResponseEntity<ApiResponse<LeaveResponse>> applyForLeave(Long employeeId, LeaveRequest request) {
        // Find the employee by ID
        Optional<Employee> employeeOpt = employeeRespository.findById(employeeId);
        if (employeeOpt.isEmpty()) {
            throw new RuntimeException("Employee not found");
        }
        Employee employee = employeeOpt.get();

        Leave newLeave = Leave.builder()
                .status(LeaveStatus.PENDING)
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .reason(request.getReason())
                .employee(employee)
                .build();

        leaveRepository.save(newLeave);

        LeaveResponse response = LeaveResponse.builder()
                .status(LeaveStatus.PENDING)
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .reason(request.getReason())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("Leave request submitted successfully", response));
    }

    @Override
    public ResponseEntity<ApiResponse<LeaveResponse>> updateLeaveStatus(Long id, LeaveStatus status) {
        Leave leave = leaveRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Leave not found"));

        // Update the leave status
        leave.setStatus(status);
        Leave updatedLeave = leaveRepository.save(leave);

        // Map to response object
        LeaveResponse response = LeaveResponse.builder()
                .startDate(updatedLeave.getStartDate())
                .endDate(updatedLeave.getEndDate())
                .reason(updatedLeave.getReason())
                .status(updatedLeave.getStatus())
                .build();

        return ResponseEntity.ok(new ApiResponse<>("Leave status updated successfully", response));
    }

    @Override
    public ResponseEntity<ApiResponse<List<LeaveResponse>>> getAllLeaves() {
        // Fetch all leaves from the repository
        List<Leave> leaves = leaveRepository.findAll();

        // Map the Leave entities to LeaveResponse DTOs
        List<LeaveResponse> responses = leaves.stream().map(leave -> LeaveResponse.builder()
                .startDate(leave.getStartDate())
                .endDate(leave.getEndDate())
                .reason(leave.getReason())
                .status(leave.getStatus())
                .employeeName(leave.getEmployee().getFirstName() + " " + leave.getEmployee().getLastName()) // Include employee details
                .build()).toList();

        return ResponseEntity.ok(new ApiResponse<>("Leaves retrieved successfully", responses));
    }
}
