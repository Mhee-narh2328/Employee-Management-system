package com.muminat.Employee_management_system.entity;


import com.muminat.Employee_management_system.entity.enums.AttendanceStatus;
import com.muminat.Employee_management_system.entity.enums.Reasons;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "attendance_tbl")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Attendance extends BaseClass{

    @Enumerated(EnumType.STRING)
    private AttendanceStatus attendanceStatus;

    @Enumerated(EnumType.STRING)
    private Reasons reasons;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
