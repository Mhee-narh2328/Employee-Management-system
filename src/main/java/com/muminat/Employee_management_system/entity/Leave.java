package com.muminat.Employee_management_system.entity;

import com.muminat.Employee_management_system.entity.enums.LeaveStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "leave_tbl")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Leave extends BaseClass{

    @Enumerated(EnumType.STRING)
    private LeaveStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
