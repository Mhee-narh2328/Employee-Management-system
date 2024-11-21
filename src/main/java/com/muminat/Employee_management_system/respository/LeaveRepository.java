package com.muminat.Employee_management_system.respository;

import com.muminat.Employee_management_system.entity.Leave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRepository extends JpaRepository<Leave, Long> {
}
