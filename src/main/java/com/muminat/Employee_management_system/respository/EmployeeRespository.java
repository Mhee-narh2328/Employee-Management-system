package com.muminat.Employee_management_system.respository;

import com.muminat.Employee_management_system.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRespository extends JpaRepository<Employee, Long> {
    boolean existsByEmail(String email);
}
