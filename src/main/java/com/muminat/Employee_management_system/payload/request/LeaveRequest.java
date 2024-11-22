package com.muminat.Employee_management_system.payload.request;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LeaveRequest {
    private LocalDate startDate;
    private LocalDate endDate;
    private String reason;
}
