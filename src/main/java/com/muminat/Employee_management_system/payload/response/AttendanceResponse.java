package com.muminat.Employee_management_system.payload.response;

import com.muminat.Employee_management_system.entity.enums.AttendanceStatus;
import com.muminat.Employee_management_system.entity.enums.Reasons;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AttendanceResponse {
    private AttendanceStatus attendanceStatus;
    private Reasons reasons;
}
