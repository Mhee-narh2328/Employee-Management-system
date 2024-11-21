package com.muminat.Employee_management_system.respository;

import com.muminat.Employee_management_system.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
}
