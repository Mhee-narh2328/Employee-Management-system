package com.muminat.Employee_management_system.controller;


import com.muminat.Employee_management_system.entity.Leave;
import com.muminat.Employee_management_system.payload.response.ApiResponse;
import com.muminat.Employee_management_system.service.EmployeeService;
import com.muminat.Employee_management_system.service.LeaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee/")
@RequiredArgsConstructor
public class LeaveController {
    private  final LeaveService leaveService;


    @PostMapping("leave/{id}")
    public ResponseEntity<ApiResponse<String>> applyForLeave(@PathVariable Long id, @RequestBody Leave leaveRequest) {
        return leaveService.applyForLeave(id, leaveRequest);
    }
}
