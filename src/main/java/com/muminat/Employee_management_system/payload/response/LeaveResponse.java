package com.muminat.Employee_management_system.payload.response;

import com.muminat.Employee_management_system.entity.enums.LeaveStatus;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LeaveResponse {
    private LocalDate startDate;
    private LocalDate endDate;
    private String reason;
    private LeaveStatus status;
    private String employeeName;
}
