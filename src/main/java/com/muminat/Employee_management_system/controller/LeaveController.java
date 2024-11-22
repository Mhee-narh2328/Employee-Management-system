package com.muminat.Employee_management_system.controller;


import com.muminat.Employee_management_system.entity.Leave;
import com.muminat.Employee_management_system.entity.enums.LeaveStatus;
import com.muminat.Employee_management_system.payload.request.LeaveRequest;
import com.muminat.Employee_management_system.payload.response.ApiResponse;
import com.muminat.Employee_management_system.payload.response.LeaveResponse;
import com.muminat.Employee_management_system.service.EmployeeService;
import com.muminat.Employee_management_system.service.LeaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/leaves")
@RequiredArgsConstructor
public class LeaveController {
    private  final LeaveService leaveService;


    @PostMapping("apply/{employeeId}")
    public ResponseEntity<ApiResponse<LeaveResponse>> applyForLeave(
            @PathVariable Long employeeId,
            @RequestBody LeaveRequest leaveRequest) {
        return leaveService.applyForLeave(employeeId, leaveRequest);
    }

    @PutMapping("status/{leaveId}")
    public ResponseEntity<ApiResponse<LeaveResponse>> updateLeaveStatus(
            @PathVariable Long leaveId,
            @RequestParam LeaveStatus status) {
        return leaveService.updateLeaveStatus(leaveId, status);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<LeaveResponse>>> getAllLeaves() {
        return leaveService.getAllLeaves();
    }

}
